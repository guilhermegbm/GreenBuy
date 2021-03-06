/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.SQL;

import Jpa.JpaUtil;
import Modelo.BEAN.Saida;
import java.util.ArrayList;
import java.util.Date;
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
public class SaidaSql {

    public static void insereSaidaEItens(Saida s) throws PersistenceException {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        try {
            tx.begin();

            manager.persist(s);

            tx.commit();
        } finally {
            manager.close();
        }

    }

    public static void editaSaida(Saida s) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        try {
            tx.begin();

            manager.merge(s);

            tx.commit();
        } finally {
            manager.close();
        }

    }

    public static void deletaSaida(Saida s) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        try {
            tx.begin();

            manager.merge(s);

            manager.remove(s);

            tx.commit();
        } finally {
            manager.close();
        }

    }

    public static List<Saida> listarTodos() throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
             TypedQuery<Saida> tq = manager.createQuery("from Saida", Saida.class);
             return tq.getResultList();
        } finally {
            manager.close();
        }

    }

    public static List<Saida> listarSaidaPorCodigo(int codigo) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            List s = new ArrayList<>();
            s.add(manager.find(Saida.class, codigo));
            return s;
        } finally {
            manager.close();
        }
    }

    public static List<Saida> listarTudoTodosOuPorCodigo(int cod) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();
        try {
            if (cod == 0) {
                TypedQuery<Saida> query = manager.createQuery(""
                        + "select distinct s from Saida s left join s.objetos o", Saida.class);
                
                return query.getResultList();
                
            } else {
                TypedQuery<Saida> tq = manager.createQuery("select distinct s from Saida s left join s.objetos o where s.codigo = :cod", Saida.class);
                tq.setParameter("cod", cod);
                return tq.getResultList();
            }
        } finally {
            manager.close();
        }
    }

    public static List<Saida> listarPorDataInicioFim(Date dataInicio, Date dataFim) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();
        
        try {
            TypedQuery<Saida> tq = manager.createQuery("select distinct s from Saida s left join s.objetos o where s.dataHora >= :dataInicio and s.dataHora <= :dataFim", Saida.class);
            tq.setParameter("dataInicio", dataInicio);
            tq.setParameter("dataFim", dataFim);
            return tq.getResultList();
        } finally {
            manager.close();
        }
    }

    public static List<Saida> listarPorDataInicio(Date dataInicio) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();
        
        try {
            TypedQuery<Saida> tq = manager.createQuery("select distinct s from Saida s left join s.objetos o where s.dataHora >= :dataInicio", Saida.class);
            tq.setParameter("dataInicio", dataInicio);
            return tq.getResultList();
        } finally {
            manager.close();
        }
    }

    public static List<Saida> listarPorDataFim(Date dataFim) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();
        
        try {
            TypedQuery<Saida> tq = manager.createQuery("select distinct s from Saida s left join s.objetos o where s.dataHora <= :dataFim", Saida.class);
            tq.setParameter("dataFim", dataFim);
            return tq.getResultList();
        } finally {
            manager.close();
        }
    }
}
