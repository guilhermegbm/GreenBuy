/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.BEAN.ClasseObjetoBEAN;
import Modelo.MysqlDAO.ClasseObjetoMysqlDAO;
import java.util.ArrayList;

/**
 *
 * @author Guilherme
 */
public class ControleClasseObjeto {
    ClasseObjetoMysqlDAO classe = new ClasseObjetoMysqlDAO();
    
    public boolean verifNome (String nome){
        ArrayList<ClasseObjetoBEAN> auxAL = new ArrayList<ClasseObjetoBEAN>();
        
        auxAL = classe.listarTodos();
        
        for (ClasseObjetoBEAN c : auxAL) {
            if (nome.equals(c.getNome())){
                return true;
            }
        }
        return false;
    }

    public void cadastrar(String nome) {
        classe.cadastrar(nome);
    }
}
