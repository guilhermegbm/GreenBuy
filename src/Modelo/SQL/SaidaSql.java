/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.SQL;

import Jpa.JpaUtil;
import Modelo.BEAN.Saida;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

/**
 *
 * @author Guilherme
 */
public class SaidaSql {

    public static void insereSaidaEItens(Saida s) throws PersistenceException {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        try {
            tx.begin();

            manager.persist(s);

            tx.commit();
        } finally {
            manager.close();
        }

    }

    public static void editaSaida(Saida s) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        try {
            tx.begin();

            manager.merge(s);

            tx.commit();
        } finally {
            manager.close();
        }

    }

    public static void deletaSaida(Saida s) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        try {
            tx.begin();

            manager.merge(s);

            manager.remove(s);

            tx.commit();
        } finally {
            manager.close();
        }

    }

    public Set listarTodos() throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            return (Set<Saida>) manager.createQuery("from Saida", Saida.class);
        } finally {
            manager.close();
        }

    }

    public static Saida listarSaidaPorCodigo(int codigo) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            return manager.find(Saida.class, codigo);
        } finally {
            manager.close();
        }
    }
}
