/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.BEAN.Fornecimento;
import Modelo.SQL.FornecimentoSql;
import java.util.List;
import java.util.Set;
import javax.persistence.PersistenceException;

/**
 *
 * @author Guilherme
 */
public class ControleFornecimento {
    
    public static void insereFornecimentoEItens(Fornecimento f) throws PersistenceException {
        FornecimentoSql.insereFornecimentoEItens(f);
    }
    
    public static void editaFornecimento(Fornecimento f) throws RuntimeException {
        FornecimentoSql.editaFornecimento(f);
    }
    
    public static void deletaFornecimento(Fornecimento f) throws RuntimeException {
        FornecimentoSql.deletaFornecimento(f);
    }
    
    public static List<Fornecimento> listarTodos() throws RuntimeException {
        return FornecimentoSql.listarTodos();
    }
    
    public static List<Fornecimento> listarFornecimentoPorCodigo(int codigo) throws RuntimeException {
        return FornecimentoSql.listarFornecimentoPorCodigo(codigo);
    }
}
