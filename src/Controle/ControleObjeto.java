/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.BEAN.Objeto;
import Modelo.SQL.ObjetoSql;
import java.util.List;
import java.util.Set;
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
}
