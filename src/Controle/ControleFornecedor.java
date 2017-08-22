/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.BEAN.Fornecedor;
import Modelo.SQL.FornecedorSql;
import java.util.List;
import java.util.Set;
import javax.persistence.PersistenceException;

/**
 *
 * @author Guilherme
 */
public class ControleFornecedor {
    
    public static void insereFornecedor(Fornecedor f) throws PersistenceException {
        FornecedorSql.insereFornecedor(f);
    }
    
    public static void editaFornecedor(Fornecedor f) throws RuntimeException {
        FornecedorSql.editaFornecedor(f);
    }
    
    public static void deletaFornecedor(Fornecedor f) throws RuntimeException {
        FornecedorSql.deletaFornecedor(f);
    }
    
    public static List<Fornecedor> listarTodos() throws RuntimeException {
        return FornecedorSql.listarTodos();
    }
    
    public static List<Fornecedor> listarTudoTodosOuPorCodigo(int codigo) throws RuntimeException {
        return FornecedorSql.listarTudoTodosOuPorCodigo(codigo);
    }

    public static List<Fornecedor> listarTodosAtivos() throws RuntimeException {
        return FornecedorSql.listarTodosAtivos();
    }
    
    public static List<Fornecedor> listarTodosInativos() throws RuntimeException {
        return FornecedorSql.listarTodosInativos();
    }

    public static List<Fornecedor> listarApenasPessoas() throws RuntimeException {
        return FornecedorSql.listarApenasPessoas();
    }

    public static List<Fornecedor> listarApenasEmpresas() throws RuntimeException {
        return FornecedorSql.listarApenasEmpresas();
    }

    public static List<Fornecedor> listarPorNome(String nome) throws RuntimeException {
        return FornecedorSql.listarPorNome(nome);
    }

    public static List<Fornecedor> listarPorCNPJ(String cnpj) throws RuntimeException {
        return FornecedorSql.listarPorCNPJ(cnpj);
    }

    public static List<Fornecedor> listarPorCPF(String cpf) throws RuntimeException {
        return FornecedorSql.listarPorCPF(cpf);
    }
    
    public static void inativaFornecedor (Fornecedor f) throws RuntimeException {
        FornecedorSql.inativaFornecedor(f);
    }
    
    public static void reativaFornecedor (Fornecedor f) throws RuntimeException {
        FornecedorSql.reativaFornecedor(f);
    }

    public static List<Fornecedor> listarPorNomeEAtivo(String nome)throws RuntimeException {
        return FornecedorSql.listarPorNomeEAtivo(nome);
    }

    public static List<Fornecedor> listarPorCodigoEAtivo(int cod)throws RuntimeException {
        return FornecedorSql.listarPorCodigoEAtivo(cod);
    }
}
