/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.SQL;

import Jpa.JpaUtil;
import Modelo.BEAN.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.sql.Connection;
import JasperSoft.ConnectionFactory;
import com.sun.xml.internal.ws.api.pipe.ClientPipeAssemblerContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guilherme
 */
public class ClienteSql {

    public static void insereCliente(Cliente c) throws PersistenceException {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        try {
            tx.begin();

            manager.persist(c);

            tx.commit();
        } finally {
            manager.close();
        }

    }

    public static void editaCliente(Cliente c) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        try {
            tx.begin();

            manager.merge(c);

            tx.commit();
        } finally {
            manager.close();
        }

    }

    public static void deletaCliente(Cliente c) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        try {
            tx.begin();

            Cliente cli = manager.merge(c);

            manager.remove(cli);

            tx.commit();
        } finally {
            manager.close();
        }

    }

    public static List<Cliente> listarTodos() throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery<Cliente> tq = manager.createQuery("from Cliente", Cliente.class);
            return tq.getResultList();
        } finally {
            manager.close();
        }

    }

    public static List<Cliente> listarTodosAtivos() throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery<Cliente> tq = manager.createQuery("select c from Cliente c where c.situacaoCli = :situacao", Cliente.class);
            tq.setParameter("situacao", Cliente.SituacaoCli.ATIVO);
            return tq.getResultList();
        } finally {
            manager.close();
        }

    }

    public static List<Cliente> listarTodosDesligados() throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery<Cliente> tq = manager.createQuery("select c from Cliente c where c.situacaoCli = :situacao", Cliente.class);
            tq.setParameter("situacao", Cliente.SituacaoCli.DESLIGADO);
            return tq.getResultList();
        } finally {
            manager.close();
        }
    }

    public static List<Cliente> listarTudoTodosOuPorCodigo(int codigo) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            if (codigo == 0) {
                TypedQuery<Cliente> query = manager.createQuery("select distinct c from Cliente c left join fetch c.vendas v", Cliente.class);

                return query.getResultList();
            } else {
                List<Cliente> s = new ArrayList<>();
                Cliente c = manager.find(Cliente.class, codigo);

                if (c != null) {
                    s.add(c);
                }

                return s;
            }
        } finally {
            manager.close();
        }
    }

    public static List<Cliente> listarPorNome(String nome) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery<Cliente> tq = manager.createQuery("select c from Cliente c where c.nome like :nome", Cliente.class);
            tq.setParameter("nome", "%" + nome + "%");
            return tq.getResultList();
        } finally {
            manager.close();
        }
    }

    public static void desativaCliente(Cliente c) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        try {
            tx.begin();

            c.setSituacaoCli(Cliente.SituacaoCli.DESLIGADO);

            manager.merge(c);

            tx.commit();
        } finally {
            manager.close();
        }
    }

    public static void reativaCliente(Cliente c) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        try {
            tx.begin();

            c.setSituacaoCli(Cliente.SituacaoCli.ATIVO);

            manager.merge(c);

            tx.commit();
        } finally {
            manager.close();
        }
    }

    public static List<Cliente> listarPorCodigoEAtivo(int cod) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery tq = manager.createQuery("select c from Cliente c where c.codigo = :codigo and c.situacaoCli = :sit", Cliente.class);
            tq.setParameter("codigo", cod);
            tq.setParameter("sit", Cliente.SituacaoCli.ATIVO);

            return tq.getResultList();

        } finally {
            manager.close();
        }
    }

    public static List<Cliente> listarPorNomeEAtivo(String nome) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery<Cliente> tq = manager.createQuery("select c from Cliente c where c.nome like :nome and c.situacaoCli = :sit", Cliente.class);
            tq.setParameter("nome", "%" + nome + "%");
            tq.setParameter("sit", Cliente.SituacaoCli.ATIVO);
            return tq.getResultList();
        } finally {
            manager.close();
        }
    }

    public static List<Cliente> listarTodosAtivosJDBC() {
        Connection conn = ConnectionFactory.getConnection();
        List<Cliente> c = new ArrayList<>();
        
        try {
            
            PreparedStatement stmt = conn.prepareStatement("select * from Cliente where cliSituacao = 'ATIVO';");
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                Cliente cli = new Cliente();
                
                cli.setCodigo(rs.getInt(1));
                cli.setCpf(rs.getString(2));
                cli.setEmail(rs.getString(3));
                cli.setLogin(rs.getString(4));
                cli.setNome(rs.getString(5));
                cli.setSenha(rs.getString(6));
                
                if (rs.getString(7).equals("ATIVO")){
                    cli.setSituacaoCli(Cliente.SituacaoCli.ATIVO);
                } else {
                    cli.setSituacaoCli(Cliente.SituacaoCli.DESLIGADO);
                }
                
                cli.setTelefone(rs.getString(8));
                
                c.add(cli);
            }
        } catch (SQLException ex) {
            System.out.println("Deu ruim: " + ex);
        }
        return c;
    }

    public static List<Cliente> listarTodosDesligadosJDBC() {
        Connection conn = ConnectionFactory.getConnection();
        List<Cliente> c = new ArrayList<>();
        
        try {
            
            PreparedStatement stmt = conn.prepareStatement("select * from Cliente where cliSituacao = 'DESLIGADO';");
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                Cliente cli = new Cliente();
                
                cli.setCodigo(rs.getInt(1));
                cli.setCpf(rs.getString(2));
                cli.setEmail(rs.getString(3));
                cli.setLogin(rs.getString(4));
                cli.setNome(rs.getString(5));
                cli.setSenha(rs.getString(6));
                
                if (rs.getString(7).equals("ATIVO")){
                    cli.setSituacaoCli(Cliente.SituacaoCli.ATIVO);
                } else {
                    cli.setSituacaoCli(Cliente.SituacaoCli.DESLIGADO);
                }
                
                cli.setTelefone(rs.getString(8));
                
                c.add(cli);
            }
        } catch (SQLException ex) {
            System.out.println("Deu ruim: " + ex);
        }
        return c;
    }

    public static List<Cliente> listarTudoTodosOuPorCodigoJDBC(int codigo) {
        Connection conn = ConnectionFactory.getConnection();
        List<Cliente> c = new ArrayList<>();
        
        try {
            
            PreparedStatement stmt = conn.prepareStatement("select * from Cliente where cliCodigo = ?;");
            stmt.setInt(1, codigo);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                Cliente cli = new Cliente();
                
                cli.setCodigo(rs.getInt(1));
                cli.setCpf(rs.getString(2));
                cli.setEmail(rs.getString(3));
                cli.setLogin(rs.getString(4));
                cli.setNome(rs.getString(5));
                cli.setSenha(rs.getString(6));
                
                if (rs.getString(7).equals("ATIVO")){
                    cli.setSituacaoCli(Cliente.SituacaoCli.ATIVO);
                } else {
                    cli.setSituacaoCli(Cliente.SituacaoCli.DESLIGADO);
                }
                
                cli.setTelefone(rs.getString(8));
                
                c.add(cli);
            }
        } catch (SQLException ex) {
            System.out.println("Deu ruim: " + ex);
        }
        return c;
    }

    public static List<Cliente> listarPorNomeJDBC(String nome) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        List<Cliente> c = new ArrayList<>();
        
        try {
            System.out.println("");
            PreparedStatement stmt = conn.prepareStatement("select * from Cliente where cliNome like '%" + nome + "%';");
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                Cliente cli = new Cliente();
                
                cli.setCodigo(rs.getInt(1));
                cli.setCpf(rs.getString(2));
                cli.setEmail(rs.getString(3));
                cli.setLogin(rs.getString(4));
                cli.setNome(rs.getString(5));
                cli.setSenha(rs.getString(6));
                
                if (rs.getString(7).equals("ATIVO")){
                    cli.setSituacaoCli(Cliente.SituacaoCli.ATIVO);
                } else {
                    cli.setSituacaoCli(Cliente.SituacaoCli.DESLIGADO);
                }
                
                cli.setTelefone(rs.getString(8));
                
                c.add(cli);
            }
        } catch (SQLException ex) {
            //System.out.println("Deu ruim: " + ex);
            throw new SQLException(ex);
        }
        return c;
    }
}
