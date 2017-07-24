/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.BEAN.Cliente;
import Modelo.SQL.ClienteSql;
import java.util.List;
import java.util.Set;
import javax.persistence.PersistenceException;

/**
 *
 * @author Guilherme
 */
public class ControleCliente {
    
    public static void insereCliente(Cliente c) throws PersistenceException {
        ClienteSql.insereCliente(c);
    }
    
    public static void editaCliente(Cliente c) throws RuntimeException {
        ClienteSql.editaCliente(c);
    }
    
    public static void deletaCliente(Cliente c) throws RuntimeException {
        ClienteSql.deletaCliente(c);
    }
    
    public static List<Cliente> listarTodos() throws RuntimeException {
        return ClienteSql.listarTodos();
    }
    
    public static List<Cliente> listarTudoTodosOuPorCodigo(int codigo) throws RuntimeException {
        return ClienteSql.listarTudoTodosOuPorCodigo(codigo);
    }
}
