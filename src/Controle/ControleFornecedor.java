/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.BEAN.FornecedorBEAN;
import Modelo.MysqlDAO.FornecedorMysqlDAO;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author Henrique
 */
public class ControleFornecedor {
    
    ArrayList<FornecedorBEAN> auxAL = new ArrayList<FornecedorBEAN>();
    
    FornecedorMysqlDAO fornDao = new FornecedorMysqlDAO();

    public ArrayList<FornecedorBEAN> listarTodos() {
        auxAL = fornDao.listarTodos();
        return auxAL;
    }
    
    public void cadastrar (FornecedorBEAN forn){
        fornDao.cadastrar(forn);
    }

    public ArrayList<FornecedorBEAN> listarPorCodigo(int codigo) {
        return fornDao.listarPorCodigo(codigo);
    }

    public ArrayList<FornecedorBEAN> listarPorNome(String nome) {
        return fornDao.listarPorNome(nome);
    }

    public ArrayList<FornecedorBEAN> listarPorCNPJ(String cnpj) {
        return fornDao.listarPorCNPJ(cnpj);
    }

    public void editar(FornecedorBEAN forn) {
        fornDao.editar(forn);
    }

    public void deletar(int codigo) {
        fornDao.deletar(codigo);
    }
    
}
