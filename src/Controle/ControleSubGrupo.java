/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.BEAN.SubGrupo;
import Modelo.SQL.SubGrupoSql;
import java.util.Set;
import javax.persistence.PersistenceException;

/**
 *
 * @author Guilherme
 */
public class ControleSubGrupo {
    
    public static void insereSubGrupo(SubGrupo sg) throws PersistenceException {
        SubGrupoSql.insereSubGrupo(sg);
    }
    
    public static void editaSubGrupo(SubGrupo sg) throws RuntimeException {
        SubGrupoSql.editaSubGrupo(sg);
    }
    
    public static void deletaSubGrupo(SubGrupo sg) throws RuntimeException {
        SubGrupoSql.deletaSubGrupo(sg);
    }
    
    public static Set<SubGrupo> listarTodos() throws RuntimeException {
        return SubGrupoSql.listarTodos();
    }
    
    public static Set<SubGrupo> listarTudoTodosOuPorCodigo(int codigo) throws RuntimeException {
        return SubGrupoSql.listarTudoTodosOuPorCodigo(codigo);
    }
}
