/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.SQL;

import Jpa.JpaUtil;
import Modelo.BEAN.Objeto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

/**
 *
 * @author Guilherme
 */
public class ObjetoSql {

    public static void insereObjeto(Objeto o) throws PersistenceException {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        try {
            tx.begin();

            manager.persist(o);

            tx.commit();
        } finally {
            manager.close();
        }

    }

    public static void editaObjeto(Objeto o) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        try {
            tx.begin();

            manager.merge(o);

            tx.commit();
        } finally {
            manager.close();
        }

    }

    public static void deletaObjeto(Objeto o) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        try {
            tx.begin();

            Objeto obj = manager.merge(o);

            manager.remove(obj);

            tx.commit();
        } finally {
            manager.close();
        }

    }

    public static List<Objeto> listarTodos() throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery<Objeto> tq = manager.createQuery("from Objeto", Objeto.class);
            return tq.getResultList();
        } finally {
            manager.close();
        }

    }

    public static List<Objeto> listarObjetoPorCodigo(int codigo) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            List s = new ArrayList<>();
            Objeto o = manager.find(Objeto.class, codigo);

            if (o != null) {
                s.add(o);
            }

            return s;
        } finally {
            manager.close();
        }
    }

    public static List<Objeto> listarPorNome(String nome) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery<Objeto> tq = manager.createQuery("select o from Objeto o where o.nome like :nome", Objeto.class);
            tq.setParameter("nome", "%" + nome + "%");
            return tq.getResultList();
        } finally {
            manager.close();
        }
    }

    public static List<Objeto> listarPorValorVendaMenor(float valor) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery<Objeto> tq = manager.createQuery("select o from Objeto o where o.precoVendaBase >= :valor", Objeto.class);
            tq.setParameter("valor", valor);
            return tq.getResultList();
        } finally {
            manager.close();
        }
    }

    public static List<Objeto> listarPorValorVendaMaior(float valor) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery<Objeto> tq = manager.createQuery("select o from Objeto o where o.precoVendaBase <= :valor", Objeto.class);
            tq.setParameter("valor", valor);
            return tq.getResultList();
        } finally {
            manager.close();
        }
    }

    public static List<Objeto> listarPorValorCompraMenor(float valor) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery<Objeto> tq = manager.createQuery("select o from Objeto o where o.precoCompraBase >= :valor", Objeto.class);
            tq.setParameter("valor", valor);
            return tq.getResultList();
        } finally {
            manager.close();
        }
    }

    public static List<Objeto> listarPorValorCompraMaior(float valor) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery<Objeto> tq = manager.createQuery("select o from Objeto o where o.precoCompraBase <= :valor", Objeto.class);
            tq.setParameter("valor", valor);
            return tq.getResultList();
        } finally {
            manager.close();
        }
    }

    public static List<Objeto> listarTodosAtivos() throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery<Objeto> tq = manager.createQuery("select o from Objeto o where o.situacaoObj = :situacao", Objeto.class);
            tq.setParameter("situacao", Objeto.SituacaoObj.ATIVO);
            return tq.getResultList();
        } finally {
            manager.close();
        }
    }

    public static List<Objeto> listarTodosProdutos() throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery<Objeto> tq = manager.createQuery("select o from Objeto o where o.tipoObj = :tipo", Objeto.class);
            tq.setParameter("tipo", Objeto.TipoObjeto.PRODUTO);
            return tq.getResultList();
        } finally {
            manager.close();
        }
    }

    public static List<Objeto> listarTodosMercadorias() throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery<Objeto> tq = manager.createQuery("select o from Objeto o where o.tipoObj = :tipo", Objeto.class);
            tq.setParameter("tipo", Objeto.TipoObjeto.MERCADORIA);
            return tq.getResultList();
        } finally {
            manager.close();
        }
    }

    public static List<Objeto> listarTodosInativos() throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery<Objeto> tq = manager.createQuery("select o from Objeto o where o.situacaoObj = :situacao", Objeto.class);
            tq.setParameter("situacao", Objeto.SituacaoObj.INATIVO);
            return tq.getResultList();
        } finally {
            manager.close();
        }
    }

    public static void inativaObjeto(Objeto o) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        try {
            tx.begin();

            o.setSituacaoObj(Objeto.SituacaoObj.INATIVO);

            manager.merge(o);

            tx.commit();
        } finally {
            manager.close();
        }
    }

    public static void reativaObjeto(Objeto o) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        try {
            tx.begin();

            o.setSituacaoObj(Objeto.SituacaoObj.ATIVO);

            manager.merge(o);

            tx.commit();
        } finally {
            manager.close();
        }
    }

    public static List<Objeto> listarTodosMercadoriasEAtivos() throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery<Objeto> tq = manager.createQuery("select o from Objeto o where o.tipoObj = :tipo and"
                    + " o.situacaoObj = :situacao", Objeto.class);
            tq.setParameter("tipo", Objeto.TipoObjeto.MERCADORIA);
            tq.setParameter("situacao", Objeto.SituacaoObj.ATIVO);
            return tq.getResultList();
        } finally {
            manager.close();
        }
    }
    
    public static List<Objeto> listarTodosMercadoriasEInativos() throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery<Objeto> tq = manager.createQuery("select o from Objeto o where o.tipoObj = :tipo and"
                    + " o.situacaoObj = :situacao", Objeto.class);
            tq.setParameter("tipo", Objeto.TipoObjeto.MERCADORIA);
            tq.setParameter("situacao", Objeto.SituacaoObj.INATIVO);
            return tq.getResultList();
        } finally {
            manager.close();
        }
    }

    public static List<Objeto> listarMercadoriaPorCodigo(int cod) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery<Objeto> tq = manager.createQuery("select o from Objeto o where o.codigo = :codigo and"
                    + " o.tipoObj = :tipo", Objeto.class);
            tq.setParameter("codigo", cod);
            tq.setParameter("tipo", Objeto.TipoObjeto.MERCADORIA);
            return tq.getResultList();
        } finally {
            manager.close();
        }
    }

    public static List<Objeto> listarMercadoriaPorNome(String nome) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery<Objeto> tq = manager.createQuery("select o from Objeto o where o.nome like :nome and"
                    + " o.tipoObj = :tipo", Objeto.class);
            tq.setParameter("nome", "%" + nome + "%");
            tq.setParameter("tipo", Objeto.TipoObjeto.MERCADORIA);
            return tq.getResultList();
        } finally {
            manager.close();
        }
    }

    public static List<Objeto> listarMercadoriaPorValorCompraMenor(float valor) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery<Objeto> tq = manager.createQuery("select o from Objeto o where o.precoCompraBase >= :valor and"
                    + " o.tipoObj = :tipo", Objeto.class);
            tq.setParameter("valor", valor);
            tq.setParameter("tipo", Objeto.TipoObjeto.MERCADORIA);
            return tq.getResultList();
        } finally {
            manager.close();
        }
    }

    public static List<Objeto> listarMercadoriaPorValorCompraMaior(float valor) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery<Objeto> tq = manager.createQuery("select o from Objeto o where o.precoCompraBase <= :valor and"
                    + " o.tipoObj = :tipo", Objeto.class);
            tq.setParameter("valor", valor);
            tq.setParameter("tipo", Objeto.TipoObjeto.MERCADORIA);
            return tq.getResultList();
        } finally {
            manager.close();
        }
    }

    public static List<Objeto> listarTodosProdutosAtivos() throws RuntimeException{
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery<Objeto> tq = manager.createQuery("select o from Objeto o where o.tipoObj = :tipo and"
                    + " o.situacaoObj = :situacao", Objeto.class);
            tq.setParameter("tipo", Objeto.TipoObjeto.PRODUTO);
            tq.setParameter("situacao", Objeto.SituacaoObj.ATIVO);
            return tq.getResultList();
        } finally {
            manager.close();
        }
    }

    public static List<Objeto> listarObjetoPorCodigoEAtivo(int cod) throws RuntimeException{
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery<Objeto> tq = manager.createQuery("select o from Objeto o where o.codigo = :codigo and"
                    + " o.situacaoObj = :situacao", Objeto.class);
            tq.setParameter("codigo", cod);
            tq.setParameter("situacao", Objeto.SituacaoObj.ATIVO);
            return tq.getResultList();
        } finally {
            manager.close();
        }
    }

    public static List<Objeto> listarPorNomeEAtivo(String nome)throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery<Objeto> tq = manager.createQuery("select o from Objeto o where o.nome like :nome and"
                    + " o.situacaoObj = :situacao", Objeto.class);
            tq.setParameter("nome", "%" + nome + "%");
            tq.setParameter("situacao", Objeto.SituacaoObj.ATIVO);
            return tq.getResultList();
        } finally {
            manager.close();
        }
    }

    public static List<Objeto> listarPorValorVendaMaiorEAtivo(float valor) throws RuntimeException{
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery<Objeto> tq = manager.createQuery("select o from Objeto o where o.precoVendaBase <= :valor and"
                    + " o.situacaoObj = :situacao", Objeto.class);
            tq.setParameter("valor", valor);
            tq.setParameter("situacao", Objeto.SituacaoObj.ATIVO);
            return tq.getResultList();
        } finally {
            manager.close();
        }
    }

    public static List<Objeto> listarPorValorVendaMenorEAtivo(float valor)throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery<Objeto> tq = manager.createQuery("select o from Objeto o where o.precoVendaBase >= :valor and"
                    + " o.situacaoObj = :situacao", Objeto.class);
            tq.setParameter("valor", valor);
            tq.setParameter("situacao", Objeto.SituacaoObj.ATIVO);
            return tq.getResultList();
        } finally {
            manager.close();
        }
    }
}
