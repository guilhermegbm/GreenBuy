/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.SQL;

import Jpa.JpaUtil;
import Modelo.BEAN.Cargo;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NamedQuery;
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

    public static Set<Cargo> listarTodos() throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            return (Set<Cargo>) manager.createQuery("from Cargo", Cargo.class);
        } finally {
            manager.close();
        }

    }

    public static Set<Cargo> listarTudoTodosOuPorCodigo(int codigo) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            if (codigo == 0) {
                TypedQuery<Cargo> query = manager.createQuery("select c "
                        + "select distinct c from Cargo c left join fetch c.funcionarios f", Cargo.class);

                return (Set<Cargo>) query.getResultList();
            } else {
                Set<Cargo> s = new HashSet<>();
                s.add(manager.find(Cargo.class, codigo));
                return s;
            }
        } finally {
            manager.close();
        }
    }
}
