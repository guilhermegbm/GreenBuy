/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.SQL;

import Jpa.JpaUtil;
import Modelo.BEAN.Fornecedor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
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

            Fornecedor forn = manager.merge(f);

            manager.remove(forn);

            tx.commit();
        } finally {
            manager.close();
        }

    }

    public static List<Fornecedor> listarTodos() throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery tq = manager.createQuery("from Fornecedor", Fornecedor.class);
            return tq.getResultList();
        } finally {
            manager.close();
        }

    }

    public static List<Fornecedor> listarTodosAtivos() {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery tq = manager.createQuery("select f from Fornecedor f where f.situacaoFor = :sit", Fornecedor.class);
            tq.setParameter("sit", Fornecedor.SituacaoFor.ATIVO);
            return tq.getResultList();
        } finally {
            manager.close();
        }
    }

    public static List<Fornecedor> listarTodosInativos() {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery tq = manager.createQuery("select f from Fornecedor f where f.situacaoFor = :sit", Fornecedor.class);
            tq.setParameter("sit", Fornecedor.SituacaoFor.INATIVO);
            return tq.getResultList();
        } finally {
            manager.close();
        }
    }

    public static List<Fornecedor> listarTudoTodosOuPorCodigo(int codigo) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            if (codigo == 0) {

                TypedQuery<Fornecedor> query = manager.createQuery("select f "
                        + "select distinct f from Fornecedor f left join fetch f.fornecimentos fo", Fornecedor.class);

                return query.getResultList();
            } else {
                List<Fornecedor> s = new ArrayList<>();
                Fornecedor f = manager.find(Fornecedor.class, codigo);

                if (f != null) {
                    s.add(f);
                }

                return s;
            }
        } finally {
            manager.close();
        }
    }

    public static List<Fornecedor> listarApenasEmpresas() throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery tq = manager.createQuery("select f from Fornecedor f where f.tipoFornecedor = :tipo", Fornecedor.class);
            tq.setParameter("tipo", Fornecedor.TipoFornecedor.EMPRESA);
            return tq.getResultList();
        } finally {
            manager.close();
        }
    }

    public static List<Fornecedor> listarApenasPessoas() throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery tq = manager.createQuery("select f from Fornecedor f where f.tipoFornecedor = :tipo", Fornecedor.class);
            tq.setParameter("tipo", Fornecedor.TipoFornecedor.PESSOA);
            return tq.getResultList();
        } finally {
            manager.close();
        }
    }

    public static List<Fornecedor> listarPorNome(String nome) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery<Fornecedor> tq = manager.createQuery("select f from Fornecedor f where f.nome like :nome", Fornecedor.class);
            tq.setParameter("nome", "%" + nome + "%");
            return tq.getResultList();
        } finally {
            manager.close();
        }
    }

    public static List<Fornecedor> listarPorCNPJ(String cnpj) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery<Fornecedor> tq = manager.createQuery("select f from Fornecedor f where f.cnpj like :cnpj", Fornecedor.class);
            tq.setParameter("cnpj", "%" + cnpj + "%");
            return tq.getResultList();
        } finally {
            manager.close();
        }
    }

    public static List<Fornecedor> listarPorCPF(String cpf) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery<Fornecedor> tq = manager.createQuery("select f from Fornecedor f where f.cpf like :cpf", Fornecedor.class);
            tq.setParameter("cpf", "%" + cpf + "%");
            return tq.getResultList();
        } finally {
            manager.close();
        }
    }

    public static void inativaFornecedor(Fornecedor f) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        try {
            tx.begin();

            f.setSituacaoFor(Fornecedor.SituacaoFor.INATIVO);

            manager.merge(f);

            tx.commit();
        } finally {
            manager.close();
        }
    }

    public static void reativaFornecedor(Fornecedor f) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        try {
            tx.begin();

            f.setSituacaoFor(Fornecedor.SituacaoFor.ATIVO);

            manager.merge(f);

            tx.commit();
        } finally {
            manager.close();
        }
    }

    public static List<Fornecedor> listarPorNomeEAtivo(String nome) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery<Fornecedor> tq = manager.createQuery("select f from Fornecedor f where f.nome like :nome "
                    + "and f.situacaoFor = :sit", Fornecedor.class);
            tq.setParameter("nome", "%" + nome + "%");
            tq.setParameter("sit", Fornecedor.SituacaoFor.ATIVO);
            return tq.getResultList();
        } finally {
            manager.close();
        }
    }

    public static List<Fornecedor> listarPorCodigoEAtivo(int cod) throws RuntimeException {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            TypedQuery<Fornecedor> tq = manager.createQuery("select f from Fornecedor f where f.codigo = :codigo "
                    + "and f.situacaoFor = :sit", Fornecedor.class);
            tq.setParameter("codigo", cod);
            tq.setParameter("sit", Fornecedor.SituacaoFor.ATIVO);
            return tq.getResultList();
        } finally {
            manager.close();
        }
    }
}
