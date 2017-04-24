/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.BEAN.CargoBEAN;
import Modelo.BEAN.FuncionarioBEAN;
import Modelo.MysqlDAO.FuncionarioMysqlDAO;
import java.util.ArrayList;

/**
 *
 * @author Isabella
 */
public class ControleFuncionario {
   FuncionarioMysqlDAO funcionario = new FuncionarioMysqlDAO();
    
    /*pra chamar o metodo cadatrar que está em modlo:
    
    */
    public void cadastrar(FuncionarioBEAN f) {                
        funcionario.cadastrar(f);
    }
    public ArrayList<FuncionarioBEAN> listarTodos () {
        return funcionario.listarTodos();
    }
    
    public void editar (FuncionarioBEAN f){
        funcionario.editar(f);
    }
    
    public ArrayList<FuncionarioBEAN> listarPorCodigo (int codigo) {
        return funcionario.listarPorCodigo(codigo);
    }
    
    public ArrayList<FuncionarioBEAN> listarPorNome (String nome) {
        return funcionario.listarPorNome(nome);
    }

    public void deletar(int codigo) {
        funcionario.deletar(codigo);
    }
}
