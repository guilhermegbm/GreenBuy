/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.SQL;

import Jpa.JpaUtil;
import Modelo.BEAN.Cargo;
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

            manager.merge(c);

            manager.remove(c);

            tx.commit();
        } finally {
            manager.close();
        }

    }

    public static List<Cargo> listarTodos() throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery<Cargo> tq = manager.createQuery("from Cargo", Cargo.class);
            return tq.getResultList();
        } finally {
            manager.close();
        }

    }

    public static List<Cargo> listarTudoTodosOuPorCodigo(int codigo) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            if (codigo == 0) {
                TypedQuery<Cargo> query = manager.createQuery("select c "
                        + "select distinct c from Cargo c left join fetch c.funcionarios f", Cargo.class);

                return query.getResultList();
            } else {
                List<Cargo> s = new ArrayList<>();
                s.add(manager.find(Cargo.class, codigo));
                return s;
            }
        } finally {
            manager.close();
        }
    }
}
