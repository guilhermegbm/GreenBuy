/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.BEAN.Objeto;
import Modelo.MysqlDAO.ObjetoMysqlDAO;
import java.util.ArrayList;

/**
 *
 * @author Henrique
 */
public class ControleObjeto {
    ObjetoMysqlDAO Objeto = new ObjetoMysqlDAO();
    
    public boolean verifCodigo(int codigo){
        ArrayList<Objeto> auxAL = Objeto.listarTodos();
        
        for (Objeto produto : auxAL) {
            if (codigo == produto.getCodigo()){
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Objeto> listarTodos(){
        ArrayList<Objeto> auxAL = Objeto.listarTodos();
        return auxAL;
    }

    public ArrayList<Objeto> listarPorCodigo(int codigo) {
        return Objeto.listarPorCodigo(codigo);
    }

    public void cadastrar(Objeto prod) {
        Objeto.cadastrar(prod);
    }

    public void deletar(int codigo) {
        Objeto.deletar(codigo);
    }

    public void editar(Objeto prod) {
        Objeto.editar(prod);
    }

    public ArrayList<Objeto> listarPorNome(String prodN) {
        return Objeto.listarPorNome(prodN);
    }

    public ArrayList<Objeto> listarPorValorMenor(float menValor) {
        ArrayList<Objeto> auxAL = Objeto.listarPorMenorValor(menValor);
        return auxAL;
    }

    public ArrayList<Objeto> listarPorValorMaior(float maiValor) {
        ArrayList<Objeto> auxAL = Objeto.listarPorMaiorValor(maiValor);
        return auxAL;
    }

    public boolean verifNome(String nomeP) {
        ArrayList<Objeto> auxAL = Objeto.listarTodos();
        
        for (Objeto prod : auxAL) {
            if (prod.getNome().equals(nomeP)){
                return true;
            }
        }
        
        return false;
    }
}
