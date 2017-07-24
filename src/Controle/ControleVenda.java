/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.BEAN.Venda;
import Modelo.SQL.VendaSql;
import java.util.List;
import java.util.Set;
import javax.persistence.PersistenceException;

/**
 *
 * @author Guilherme
 */
public class ControleVenda {
    
    public static void insereVendaEItens(Venda v) throws PersistenceException {
        VendaSql.insereVendaEItens(v);
    }
    
    public static void editaVenda(Venda v) throws RuntimeException {
        VendaSql.editaVenda(v);
    }
    
    public static void deletaVenda(Venda v) throws RuntimeException {
        VendaSql.deletaVenda(v);
    }
    
    public static List<Venda> listarTodos() {
        return VendaSql.listarTodos();
    }
    
    public static List listarVendaPorCodigo(int codigo) {
        return VendaSql.listarVendaPorCodigo(codigo);
    }
}
