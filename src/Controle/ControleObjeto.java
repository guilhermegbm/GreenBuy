/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.BEAN.Objeto;
import Modelo.SQL.ObjetoSql;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author Guilherme
 */
public class ControleObjeto {

    public static void insereObjeto(Objeto o) throws PersistenceException {
        ObjetoSql.insereObjeto(o);
    }

    public static void editaObjeto(Objeto o) throws RuntimeException {
        ObjetoSql.editaObjeto(o);
    }

    public static void deletaObjeto(Objeto o) throws RuntimeException {
        ObjetoSql.deletaObjeto(o);
    }

    public static List<Objeto> listarTodos() throws RuntimeException {
        return ObjetoSql.listarTodos();
    }

    public static List<Objeto> listarObjetoPorCodigo(int codigo) throws RuntimeException {
        return ObjetoSql.listarObjetoPorCodigo(codigo);
    }

    public static List<Objeto> listarPorNome(String nome) throws RuntimeException {
        return ObjetoSql.listarPorNome(nome);
    }

    public static List<Objeto> listarPorValorVendaMenor(float valor) throws RuntimeException {
        return ObjetoSql.listarPorValorVendaMenor(valor);
    }

    public static List<Objeto> listarPorValorVendaMaior(float valor) throws RuntimeException {
        return ObjetoSql.listarPorValorVendaMaior(valor);
    }

    public static List<Objeto> listarPorValorCompraMenor(float valor) throws RuntimeException {
        return ObjetoSql.listarPorValorCompraMenor(valor);
    }

    public static List<Objeto> listarPorValorCompraMaior(float valor) throws RuntimeException {
        return ObjetoSql.listarPorValorCompraMaior(valor);
    }

    public static List<Objeto> listarTodosAtivos() throws RuntimeException {
        return ObjetoSql.listarTodosAtivos();
    }

    public static List<Objeto> listarTodosProdutos() throws RuntimeException {
        return ObjetoSql.listarTodosProdutos();
    }

    public static List<Objeto> listarTodosMercadorias()throws RuntimeException  {
        return ObjetoSql.listarTodosMercadorias();
    }

    public static List<Objeto> listarTodosInativos()throws RuntimeException  {
        return ObjetoSql.listarTodosInativos();
    }
    
    public static void inativaObjeto(Objeto o) throws RuntimeException{
        ObjetoSql.inativaObjeto(o);
    }
    
    public static void reativaObjeto(Objeto o) throws RuntimeException{
        ObjetoSql.reativaObjeto(o);
    }
}
