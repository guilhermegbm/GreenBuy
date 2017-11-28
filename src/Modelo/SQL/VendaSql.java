/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.SQL;

import Jpa.JpaUtil;
import Modelo.BEAN.Venda;
import java.util.ArrayList;
import java.util.Date;
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

    public static List<Venda> listarTodos() throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery<Venda> tq = manager.createQuery("from Venda", Venda.class);
            return tq.getResultList();
        } finally {
            manager.close();
        }
    }

    public static List<Venda> listarVendaPorCodigo(int codigo) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            List s = new ArrayList<>();
            s.add(manager.find(Venda.class, codigo));
            return s;
        } finally {
            manager.close();
        }
    }

    public static List<Venda> listarPorSituacao(Venda.Situacao sit) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery tq = manager.createQuery("select distinct v from Venda v left join fetch v.funcionario left join v.cliente c where v.situacao = :sit", Venda.class);
            tq.setParameter("sit", sit);
            return tq.getResultList();
        } finally {
            manager.close();
        }
    }

    public static List<Venda> listarTudoTodosOuPorCodigo(int cod) {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            if (cod == 0) {
                TypedQuery<Venda> query = manager.createQuery(""
                        + "select distinct v from Venda v left join fetch v.funcionario left join v.cliente c", Venda.class);
                
                return query.getResultList();
                
            } else {
                TypedQuery<Venda> tq = manager.createQuery("select distinct v from Venda v left join fetch v.funcionario left join v.cliente c where v.codigo = :cod", Venda.class);
                tq.setParameter("cod", cod);
                return tq.getResultList();
            }
        } finally {
            manager.close();
        }
    }

    public static List<Venda> listarPorDataInicioFim(Date dataInicio, Date dataFim) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();
        
        try {
            TypedQuery tq = manager.createQuery("select distinct v from Venda v left join fetch v.funcionario left join v.cliente c where v.dataHora >= :dataInicio and v.dataHora <= :dataFim", Venda.class);
            tq.setParameter("dataInicio", dataInicio);
            tq.setParameter("dataFim", dataFim);
            return tq.getResultList();
        } finally {
            manager.close();
        }
    }

    public static List<Venda> listarPorDataInicio(Date dataInicio) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();
        
        try {
            TypedQuery tq = manager.createQuery("select distinct v from Venda v left join fetch v.funcionario left join v.cliente c where v.dataHora >= :dataInicio", Venda.class);
            tq.setParameter("dataInicio", dataInicio);
            return tq.getResultList();
        } finally {
            manager.close();
        }
    }

    public static List<Venda> listarPorDataFim(Date dataFim) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();
        
        try {
            TypedQuery tq = manager.createQuery("select distinct v from Venda v left join fetch v.funcionario left join v.cliente c where v.dataHora <= :dataFim", Venda.class);
            tq.setParameter("dataFim", dataFim);
            return tq.getResultList();
        } finally {
            manager.close();
        }
    }

}