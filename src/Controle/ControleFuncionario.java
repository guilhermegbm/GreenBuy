/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.BEAN.Cargo;
import Modelo.BEAN.Funcionario;
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
    public void cadastrar(Funcionario f) {                
        funcionario.cadastrar(f);
    }
    public ArrayList<Funcionario> listarTodos () {
        return funcionario.listarTodos();
    }
    
    public void editar (Funcionario f){
        funcionario.editar(f);
    }
    
    public ArrayList<Funcionario> listarPorCodigo (int codigo) {
        return funcionario.listarPorCodigo(codigo);
    }
    
    public ArrayList<Funcionario> listarPorNome (String nome) {
        return funcionario.listarPorNome(nome);
    }

    public void deletar(int codigo) {
        funcionario.deletar(codigo);
    }
}
