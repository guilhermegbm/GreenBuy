/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.SQL;

import Jpa.JpaUtil;
import Modelo.BEAN.Grupo;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

/**
 *
 * @author Guilherme
 */
public class GrupoSql {

    public static void insereGrupo(Grupo g) throws PersistenceException {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        try {
            tx.begin();

            manager.persist(g);

            tx.commit();
        } finally {
            manager.close();
        }

    }

    public static void editaGrupo(Grupo g) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        try {
            tx.begin();

            manager.merge(g);

            tx.commit();
        } finally {
            manager.close();
        }

    }

    public static void deletaGrupo(Grupo g) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        try {
            tx.begin();

            manager.merge(g);

            manager.remove(g);

            tx.commit();
        } finally {
            manager.close();
        }

    }

    public static Set<Grupo> listarTodos() throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            return (Set<Grupo>) manager.createQuery("from Grupo", Grupo.class);
        } finally {
            manager.close();
        }

    }

    public static Set<Grupo> listarTudoTodosOuPorCodigo(int codigo) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            if (codigo == 0) {

                TypedQuery<Grupo> query = manager.createQuery("select g "
                        + "select distinct g from Grupo g left join fetch g.subGrupos", Grupo.class);

                return (Set<Grupo>) query.getResultList();
            } else {
                Set<Grupo> s = new HashSet();
                s.add(manager.find(Grupo.class, codigo));
                return s;
            }
        } finally {
            manager.close();
        }
    }
}
