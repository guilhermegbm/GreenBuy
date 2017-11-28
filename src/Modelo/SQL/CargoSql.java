/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.SQL;

import Jpa.JpaUtil;
import Modelo.BEAN.Cargo;
import Modelo.BEAN.Funcionario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Guilherme
 */
public class CargoSql {

    public static void insereCargo(Cargo c) throws PersistenceException {
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

    public static void editaCargo(Cargo c) throws RuntimeException {
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

    public static void deletaCargo(Cargo c) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        try {
            tx.begin();

            Cargo cargo = manager.merge(c);

            manager.remove(cargo);

            tx.commit();
        } finally {
            manager.close();
        }

    }

    public static List<Cargo> listarTodos() throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();
        
        List<Cargo> cargos =  new ArrayList<Cargo>();
        try {
            //TypedQuery<Cargo> tq = manager.createQuery("from Cargo", Cargo.class);
            Query query = manager.createQuery("from Cargo"); 
            cargos = query.getResultList();
            
            //return query.getResultList();
            return cargos;
        } finally {
            manager.close();
        }

    }

    public static List<Cargo> listarTudoTodosOuPorCodigo(int codigo) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            if (codigo == 0) {
                TypedQuery<Cargo> query = manager.createQuery("select distinct c from Cargo c left join fetch c.funcionarios f", Cargo.class);
                
                return query.getResultList();
                
            } else {
                List<Cargo> s = new ArrayList<>();
                Cargo c = manager.find(Cargo.class, codigo);
                
                if (c != null){
                    s.add(c);
                }
                
                return s;
            }
        } finally {
            manager.close();
        }
    }

    public static Long calculaFuncionariosAtivosNesteCargo(int codigo) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            Query tq = manager.createQuery("select count(f) from Cargo c left join c.funcionarios f "
                    + "where f.situacaoFun = :sit and c.codigo = :cod group by c.codigo");
            tq.setParameter("cod", codigo);
            tq.setParameter("sit", Funcionario.SituacaoFun.ATIVO);
            List<Long> l = tq.getResultList();
            
            for (Long lon : l) {
                return lon;
            }
            
            return 0L;
        } finally {
            manager.close();
        }
    }

    public static List<Cargo> listarPorNome(String nome) throws RuntimeException{
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery<Cargo> tq = manager.createQuery("select c from Cargo c where c.nome like :nome", Cargo.class);
            tq.setParameter("nome", "%" + nome + "%");
            return tq.getResultList();
        } finally {
            manager.close();
        }
    }
}
