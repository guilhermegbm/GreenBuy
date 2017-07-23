/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.SQL;

import Jpa.JpaUtil;
import Modelo.BEAN.Funcionario;
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
public class FuncionarioSql {

    public static void insereFuncionario(Funcionario f) throws PersistenceException {
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

    public static void editaFuncionario(Funcionario f) throws RuntimeException {
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

    public static void deletaFuncionario(Funcionario f) throws RuntimeException {
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

    public Set<Funcionario> listarTodos() throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            return (Set<Funcionario>) manager.createQuery("from Funcionario", Funcionario.class);
        } finally {
            manager.close();
        }

    }

    public static Set<Funcionario> listarTudoTodosOuPorCodigo(int codigo) {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            if (codigo == 0) {
                TypedQuery<Funcionario> query = manager.createQuery("select f "
                        + "select distinct f from Funcionario f left join fetch f.vendas v", Funcionario.class);

                return (Set<Funcionario>) query.getResultList();
            } else {
                Set<Funcionario> s = new HashSet();
                s.add(manager.find(Funcionario.class, codigo));
                return s;
            }
        } finally {
            manager.close();
        }
    }
}
