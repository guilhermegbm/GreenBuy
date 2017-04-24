/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.BEAN.ObjetoBEAN;
import Modelo.MysqlDAO.ObjetoMysqlDAO;
import java.util.ArrayList;

/**
 *
 * @author Henrique
 */
public class ControleObjeto {
    ObjetoMysqlDAO Objeto = new ObjetoMysqlDAO();
    
    public boolean verifCodigo(int codigo){
        ArrayList<ObjetoBEAN> auxAL = Objeto.listarTodos();
        
        for (ObjetoBEAN produto : auxAL) {
            if (codigo == produto.getCodigo()){
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<ObjetoBEAN> listarTodos(){
        ArrayList<ObjetoBEAN> auxAL = Objeto.listarTodos();
        return auxAL;
    }

    public ArrayList<ObjetoBEAN> listarPorCodigo(int codigo) {
        return Objeto.listarPorCodigo(codigo);
    }

    public void cadastrar(ObjetoBEAN prod) {
        Objeto.cadastrar(prod);
    }

    public void deletar(int codigo) {
        Objeto.deletar(codigo);
    }

    public void editar(ObjetoBEAN prod) {
        Objeto.editar(prod);
    }

    public ArrayList<ObjetoBEAN> listarPorNome(String prodN) {
        return Objeto.listarPorNome(prodN);
    }

    public ArrayList<ObjetoBEAN> listarPorValorMenor(float menValor) {
        ArrayList<ObjetoBEAN> auxAL = Objeto.listarPorMenorValor(menValor);
        return auxAL;
    }

    public ArrayList<ObjetoBEAN> listarPorValorMaior(float maiValor) {
        ArrayList<ObjetoBEAN> auxAL = Objeto.listarPorMaiorValor(maiValor);
        return auxAL;
    }

    public boolean verifNome(String nomeP) {
        ArrayList<ObjetoBEAN> auxAL = Objeto.listarTodos();
        
        for (ObjetoBEAN prod : auxAL) {
            if (prod.getNome().equals(nomeP)){
                return true;
            }
        }
        
        return false;
    }
}
