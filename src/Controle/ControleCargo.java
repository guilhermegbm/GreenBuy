/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.BEAN.Cargo;
import Modelo.SQL.CargoSql;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Guilherme
 */
public class ControleCargo {
    
    public static void insereCargo (Cargo c){
        CargoSql.insereCargo(c);
    }
    
    public static void editaCargo(Cargo c) throws RuntimeException {
        CargoSql.editaCargo(c);
    }
    
    public static void deletaCargo(Cargo c) throws RuntimeException {
        CargoSql.deletaCargo(c);
    }
    
    public static List<Cargo> listarTodos() throws RuntimeException {
        return CargoSql.listarTodos();
    }
    
    public static List<Cargo> listarTudoTodosOuPorCodigo(int codigo) throws RuntimeException {
        return CargoSql.listarTudoTodosOuPorCodigo(codigo);
    }

    public static List<Cargo> listarPorNome(String nome) {
        return CargoSql.listarPorNome(nome);
    }
}
