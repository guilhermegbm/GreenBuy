/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.SQL;

import Jpa.JpaUtil;
import Modelo.BEAN.SubGrupo;
import java.util.ArrayList;
import java.util.List;
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

            SubGrupo sub = manager.merge(sg);

            manager.remove(sub);

            tx.commit();
        } finally {
            manager.close();
        }

    }

    public static List<SubGrupo> listarTodos() throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery<SubGrupo> tq = manager.createQuery("from SubGrupo", SubGrupo.class);
            return tq.getResultList();
        } finally {
            manager.close();
        }

    }

    public static List<SubGrupo> listarTudoTodosOuPorCodigo(int codigo) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            if (codigo == 0) {
                TypedQuery<SubGrupo> query = manager.createQuery("select distinct sg from "
                        + "SubGrupo sg left join fetch sg.grupo g left join fetch sg.objetos", SubGrupo.class);

                return query.getResultList();
            } else {
                List<SubGrupo> s = new ArrayList<>();
                SubGrupo sg = manager.find(SubGrupo.class, codigo);

                if (sg != null) {
                    s.add(sg);
                }

                return s;
            }
        } finally {
            manager.close();
        }
    }

    public static List<SubGrupo> listarPorNome(String nome) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery<SubGrupo> tq = manager.createQuery("select sg from SubGrupo sg where sg.nome like :nome", SubGrupo.class);
            tq.setParameter("nome", "%" + nome + "%");
            return tq.getResultList();
        } finally {
            manager.close();
        }
    }
}
