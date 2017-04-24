/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.BEAN.ClienteBEAN;
import Modelo.MysqlDAO.ClienteMysqlDAO;
import java.util.ArrayList;

/**
 *
 * @author Isabella
 */
public class ControleCliente {
    ClienteMysqlDAO objClienteDAO = new ClienteMysqlDAO();
    /*pra chamar o metodo cadatrar que está em modlo:
    
    */
    public void cadastrar(ClienteBEAN cliente) {                
        objClienteDAO.cadastrar(cliente);
    }
    public ArrayList<ClienteBEAN> listarALL () {
        return objClienteDAO.listarTodos();
    }
    public void remover (int cliCodigo) {
        objClienteDAO.remover(cliCodigo);
    }

    public ArrayList<ClienteBEAN> listarPorCodigo(int cod) {
        return objClienteDAO.localizarCodigo(cod);
    }
    
    public ArrayList<ClienteBEAN> listarPorNome(String nome) {
        return objClienteDAO.localizarNome(nome);
    }

    public void editar(ClienteBEAN cli) {
        objClienteDAO.editar(cli);
    }
}
