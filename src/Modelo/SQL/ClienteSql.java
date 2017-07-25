/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.SQL;

import Jpa.JpaUtil;
import Modelo.BEAN.Cliente;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

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

    public static void desativaCliente(Cliente c) throws RuntimeException{
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        try {
            tx.begin();
            
            c.setSituacaoCli(Cliente.SituacaoCli.DESLIGADO);
            
            System.out.println("Código: " + c.getCodigo() + " Nome: " + c.getNome() + " Situação: " + c.getSituacaoCli());

            manager.merge(c);

            tx.commit();
        } finally {
            manager.close();
        }
    }

    public static void reativaCliente(Cliente c) throws RuntimeException{
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        try {
            tx.begin();
            
            c.setSituacaoCli(Cliente.SituacaoCli.ATIVO);
            
            System.out.println("Código: " + c.getCodigo() + " Nome: " + c.getNome() + " Situação: " + c.getSituacaoCli());

            manager.merge(c);

            tx.commit();
        } finally {
            manager.close();
        }
    }
}
