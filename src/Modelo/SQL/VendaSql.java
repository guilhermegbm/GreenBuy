/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.SQL;

import Jpa.JpaUtil;
import Modelo.BEAN.Venda;
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
public class VendaSql {

    public static void insereVendaEItens(Venda v) throws PersistenceException {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        try {
            tx.begin();

            manager.persist(v);

            tx.commit();
        } finally {
            manager.close();
        }

    }

    public static void editaVenda(Venda v) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        try {
            tx.begin();

            manager.merge(v);

            tx.commit();
        } finally {
            manager.close();
        }

    }

    public static void deletaVenda(Venda v) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        try {
            tx.begin();

            manager.merge(v);

            manager.remove(v);

            tx.commit();
        } finally {
            manager.close();
        }

    }

    public static List<Venda> listarTodos() {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery<Venda> tq = manager.createQuery("from Venda", Venda.class);
            return tq.getResultList();
        } finally {
            manager.close();
        }

    }

    public static List<Venda> listarVendaPorCodigo(int codigo) {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            List s = new ArrayList<>();
            s.add(manager.find(Venda.class, codigo));
            return s;
        } finally {
            manager.close();
        }
    }
}
