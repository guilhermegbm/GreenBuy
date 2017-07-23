/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.SQL;

import Jpa.JpaUtil;
import Modelo.BEAN.Objeto;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

/**
 *
 * @author Guilherme
 */
public class ObjetoSql {

    public static void insereObjeto(Objeto o) throws PersistenceException {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        try {

        } finally {

        }
        tx.begin();

        manager.persist(o);

        tx.commit();
        manager.close();
    }

    public static void editaObjeto(Objeto o) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        try {
            tx.begin();

            manager.merge(o);

            tx.commit();
        } finally {
            manager.close();
        }

    }

    public static void deletaObjeto(Objeto o) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        try {
            tx.begin();

            manager.merge(o);

            manager.remove(o);

            tx.commit();
        } finally {
            manager.close();
        }

    }

    public Set<Objeto> listarTodos() throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            return (Set<Objeto>) manager.createQuery("from Objeto", Objeto.class);
        } finally {
            manager.close();
        }

    }

    public static Set<Objeto> listarObjetoPorCodigo(int codigo) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            Set s = new HashSet();
            s.add(manager.find(Objeto.class, codigo));
            return s;
        } finally {
            manager.close();
        }
    }
}
