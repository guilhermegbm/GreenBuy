/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.SQL;

import Jpa.JpaUtil;
import Modelo.BEAN.Fornecedor;
import java.sql.SQLException;
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
public class FornecedorSql {

    public static void insereFornecedor(Fornecedor f) throws PersistenceException {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        try {
            tx.begin();

            manager.persist(f);

            tx.commit();
        } finally {
            manager.close();
        }

    }

    public static void editaFornecedor(Fornecedor f) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        try {
            tx.begin();

            manager.merge(f);

            tx.commit();
        } finally {
            manager.close();
        }

    }

    public static void deletaFornecedor(Fornecedor f) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        try {
            tx.begin();

            manager.merge(f);

            manager.remove(f);

            tx.commit();
        } finally {
            manager.close();
        }

    }

    public static Set<Fornecedor> listarTodos() throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            return (Set<Fornecedor>) manager.createQuery("from Fornecedor", Fornecedor.class);
        } finally {
            manager.close();
        }

    }

    public static Set<Fornecedor> listarTudoTodosOuPorCodigo(int codigo) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            if (codigo == 0) {

                TypedQuery<Fornecedor> query = manager.createQuery("select f "
                        + "select distinct f from Fornecedor f left join fetch f.fornecimentos fo", Fornecedor.class);

                return (Set<Fornecedor>) query.getResultList();
            } else {
                Set<Fornecedor> s = new HashSet<>();
                s.add(manager.find(Fornecedor.class, codigo));
                return s;
            }
        } finally {
            manager.close();
        }
    }

}
