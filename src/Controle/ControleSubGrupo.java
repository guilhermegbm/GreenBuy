/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.BEAN.SubGrupo;
import Modelo.SQL.SubGrupoSql;
import java.util.List;
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

    public static List<SubGrupo> listarTodos() throws RuntimeException {
        return SubGrupoSql.listarTodos();
    }

    public static List<SubGrupo> listarTudoTodosOuPorCodigo(int codigo) throws RuntimeException {
        return SubGrupoSql.listarTudoTodosOuPorCodigo(codigo);
    }

    public static List<SubGrupo> listarPorNome(String nome) throws RuntimeException {
        return SubGrupoSql.listarPorNome(nome);
    }

    public static boolean verifNome(String nome) {
        List<SubGrupo> l = SubGrupoSql.listarTodos();
        
        for (SubGrupo sg : l) {
            if (sg.getNome().equals(nome)){
                return true;
            }
        }
        return false;
    }
}
