/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.SQL;

import Jpa.JpaUtil;
import Modelo.BEAN.Objeto;
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
public class ObjetoSql {

    public static void insereObjeto(Objeto o) throws PersistenceException {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        try {
            tx.begin();

            manager.persist(o);

            tx.commit();
        } finally {
            manager.close();
        }

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

    public static List<Objeto> listarTodos() throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery<Objeto> tq = manager.createQuery("from Objeto", Objeto.class);
            return tq.getResultList();
        } finally {
            manager.close();
        }

    }

    public static List<Objeto> listarObjetoPorCodigo(int codigo) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            List s = new ArrayList<>();
            s.add(manager.find(Objeto.class, codigo));
            return s;
        } finally {
            manager.close();
        }
    }
}
