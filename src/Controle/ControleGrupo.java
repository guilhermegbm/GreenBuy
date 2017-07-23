/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.BEAN.Grupo;
import Modelo.SQL.GrupoSql;
import java.util.Set;
import javax.persistence.PersistenceException;


/**
 *
 * @author Guilherme
 */
public class ControleGrupo {
     
    public static void insereGrupo(Grupo g) throws PersistenceException {
        GrupoSql.insereGrupo(g);
    }
    
    public static void editaGrupo(Grupo g) throws RuntimeException {
        GrupoSql.editaGrupo(g);
    }
    
    public static void deletaGrupo(Grupo g) throws RuntimeException {
        GrupoSql.deletaGrupo(g);
    }
    
    public Set<Grupo> listarTodos() throws RuntimeException {
        return GrupoSql.listarTodos();
    }
    
    public static Set<Grupo> listarTudoTodosOuPorCodigo(int codigo) throws RuntimeException {
        return GrupoSql.listarTudoTodosOuPorCodigo(codigo);
    }
}
