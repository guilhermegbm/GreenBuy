/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.BEAN.Funcionario;
import Modelo.SQL.FuncionarioSql;
import java.util.ArrayList;
import java.util.List;
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
    
    public static List<Funcionario> listarTodos() throws RuntimeException {
        return FuncionarioSql.listarTodos();
    }
    
    public static List<Funcionario> listarTudoTodosOuPorCodigo(int codigo) throws RuntimeException{
        return FuncionarioSql.listarTudoTodosOuPorCodigo(codigo);
    }

    public static boolean verificaLogin(String usuario) throws RuntimeException{
        List<String> s = FuncionarioSql.listarTodosLogins();
        
        for (String str : s) {
            if (usuario.equals(str)){
                return true;
            }
        }
        return false;
    }

    public static Funcionario verificaSenha(String login, String senha) {
        List<Funcionario> f = FuncionarioSql.listarTodos();
        
        for (Funcionario fun : f) {
            if ((fun.getLogin().equals(login)) && (fun.getSenha().equals(senha))){
                return fun;
            }
        }
        return null;
    }

    public static List<Funcionario> listarTodosAtivos() throws RuntimeException{
        return FuncionarioSql.listarTodosAtivos();
    }

    public static List<Funcionario> listarTodosDespedidos() throws RuntimeException{
        return FuncionarioSql.listarTodosDespedidos();
    }

    public static List<Funcionario> listarPorNome(String nome) throws RuntimeException{
        return FuncionarioSql.listarPorNome(nome);
    }

    public static boolean verificaFuncionarioLogado() {
        Funcionario f = FuncionarioSql.getFunLogado();
        return f.isAdministrador();
    }

    public static void setFuncionarioLogado(Funcionario f) {
        FuncionarioSql.setFunLogado(f);
    }
    
    public static Funcionario getFuncionarioLogado (){
        return FuncionarioSql.getFunLogado();
    }
    
    public static void despedeFuncionario(Funcionario f) throws RuntimeException{
        FuncionarioSql.despedeFuncionario(f);
    }
    
    public static void recontrataFuncionario(Funcionario f) throws RuntimeException{
        FuncionarioSql.recontrataFuncionario(f);
    }

    public static void iniciaConexao() throws RuntimeException{
        FuncionarioSql.iniciaConexao();
    }
}
