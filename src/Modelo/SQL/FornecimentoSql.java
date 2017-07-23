/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.SQL;

import Jpa.JpaUtil;
import Modelo.BEAN.Fornecimento;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

/**
 *
 * @author Guilherme
 */
public class FornecimentoSql {

    public static void insereFornecimentoEItens(Fornecimento f) throws PersistenceException {
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

    public static void editaFornecimento(Fornecimento f) throws RuntimeException {
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

    public static void deletaFornecimento(Fornecimento f) throws RuntimeException {
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

    public static Set<Fornecimento> listarTodos() throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            return (Set<Fornecimento>) manager.createQuery("from Fornecimento", Fornecimento.class);
        } finally {
            manager.close();
        }

    }

    public static Set<Fornecimento> listarFornecimentoPorCodigo(int codigo) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            Set<Fornecimento> s = new HashSet<>();
            s.add(manager.find(Fornecimento.class, codigo));
            return s;
        } finally {
            manager.close();
        }
    }
}
