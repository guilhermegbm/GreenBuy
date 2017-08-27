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

    public static List<Objeto> listarTodosMercadorias() throws RuntimeException {
        return ObjetoSql.listarTodosMercadorias();
    }

    public static List<Objeto> listarTodosInativos() throws RuntimeException {
        return ObjetoSql.listarTodosInativos();
    }

    public static void inativaObjeto(Objeto o) throws RuntimeException {
        ObjetoSql.inativaObjeto(o);
    }

    public static void reativaObjeto(Objeto o) throws RuntimeException {
        ObjetoSql.reativaObjeto(o);
    }

    //Os métodos seguintes são usados majoritariamente pelo FRMFornecimento
    public static List<Objeto> listarTodosMercadoriasEAtivos() throws RuntimeException {
        return ObjetoSql.listarTodosMercadoriasEAtivos();
    }
    
    public static List<Objeto> listarTodosMercadoriasEInativos() throws RuntimeException {
        return ObjetoSql.listarTodosMercadoriasEInativos();
    }

    public static List<Objeto> listarMercadoriaPorCodigo(int cod) throws RuntimeException {
        return ObjetoSql.listarMercadoriaPorCodigo(cod);
    }

    public static List<Objeto> listarMercadoriaPorNome(String nome) throws RuntimeException {
        return ObjetoSql.listarMercadoriaPorNome(nome);
    }

    public static List<Objeto> listarMercadoriaPorValorCompraMenor(float valor) throws RuntimeException {
        return ObjetoSql.listarMercadoriaPorValorCompraMenor(valor);
    }

    public static List<Objeto> listarMercadoriaPorValorCompraMaior(float valor) throws RuntimeException {
        return ObjetoSql.listarMercadoriaPorValorCompraMaior(valor);
    }

    //Os métodos seguintes são usados majoritariamente pelo FRMVenda
    public static List<Objeto> listarTodosProdutosAtivos()throws RuntimeException {
        return ObjetoSql.listarTodosProdutosAtivos();
    }

    public static List<Objeto> listarObjetoPorCodigoEAtivo(int cod) throws RuntimeException{
        return ObjetoSql.listarObjetoPorCodigoEAtivo(cod);
    }

    public static List<Objeto> listarPorNomeEAtivo(String nome)throws RuntimeException {
        return ObjetoSql.listarPorNomeEAtivo(nome);
    }

    public static List<Objeto> listarPorValorVendaMaiorEAtivo(float valor)throws RuntimeException {
        return ObjetoSql.listarPorValorVendaMaiorEAtivo(valor);
    }

    public static List<Objeto> listarPorValorVendaMenorEAtivo(float valor)throws RuntimeException {
        return ObjetoSql.listarPorValorVendaMenorEAtivo(valor);
    }
    //
    
    public static void retiraDoEstoque(List<Objeto> objetosRetirados) throws RuntimeException{
        ObjetoSql.retiraDoEstoque(objetosRetirados);
    }
}
