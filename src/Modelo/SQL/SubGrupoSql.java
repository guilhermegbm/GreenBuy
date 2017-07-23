/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.SQL;

import Jpa.JpaUtil;
import Modelo.BEAN.SubGrupo;
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
public class SubGrupoSql {

    public static void insereSubGrupo(SubGrupo sg) throws PersistenceException {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        try {
            tx.begin();

            manager.persist(sg);

            tx.commit();
        } finally {
            manager.close();
        }

    }

    public static void editaSubGrupo(SubGrupo sg) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        try {
            tx.begin();

            manager.merge(sg);

            tx.commit();
        } finally {
            manager.close();
        }

    }

    public static void deletaSubGrupo(SubGrupo sg) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        try {
            tx.begin();

            manager.merge(sg);

            manager.remove(sg);

            tx.commit();
        } finally {
            manager.close();
        }

    }

    public static Set<SubGrupo> listarTodos() throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            return (Set<SubGrupo>) manager.createQuery("from SubGrupo", SubGrupo.class);
        } finally {
            manager.close();
        }

    }

    public static Set<SubGrupo> listarTudoTodosOuPorCodigo(int codigo) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            if (codigo == 0) {
                TypedQuery<SubGrupo> query = manager.createQuery("select distinct s from "
                        + "SubGrupo left join fetch s.grupo g left join fetch s.objetos", SubGrupo.class);

                return (Set<SubGrupo>) query.getResultList();
            } else {
                Set<SubGrupo> s = new HashSet<>();
                s.add(manager.find(SubGrupo.class, codigo));
                return s;
            }
        } finally {
            manager.close();
        }
    }
}
