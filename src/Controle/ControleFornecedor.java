/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.BEAN.Fornecedor;
import Modelo.SQL.FornecedorSql;
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
    
    public Set<Fornecedor> listarTodos() throws RuntimeException {
        return FornecedorSql.listarTodos();
    }
    
    public static Set<Fornecedor> listarTudoTodosOuPorCodigo(int codigo) throws RuntimeException {
        return FornecedorSql.listarTudoTodosOuPorCodigo(codigo);
    }
}
