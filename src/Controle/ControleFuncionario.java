/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.BEAN.Funcionario;
import Modelo.SQL.FuncionarioSql;
import java.util.Set;
import javax.persistence.PersistenceException;


/**
 *
 * @author Guilherme
 */
public class ControleFuncionario {
    
    public static void insereFuncionario(Funcionario f) throws PersistenceException {
        FuncionarioSql.insereFuncionario(f);
    }
    
    public static void editaFuncionario(Funcionario f) throws RuntimeException {
        FuncionarioSql.editaFuncionario(f);
    }
    
    public static void deletaFuncionario(Funcionario f) throws RuntimeException {
        FuncionarioSql.deletaFuncionario(f);
    }
    
    public static Set<Funcionario> listarTodos() throws RuntimeException {
        return FuncionarioSql.listarTodos();
    }
    
    public static Set<Funcionario> listarTudoTodosOuPorCodigo(int codigo) {
        return FuncionarioSql.listarTudoTodosOuPorCodigo(codigo);
    }
}
