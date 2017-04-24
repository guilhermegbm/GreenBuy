/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.BEAN.CargoBEAN;
import Modelo.MysqlDAO.CargoMysqlDAO;
import java.util.ArrayList;

/**
 *
 * @author Isabella
 */
public class ControleCargo {
    CargoMysqlDAO cargo = new CargoMysqlDAO();
    
    public ArrayList<CargoBEAN> listarTodos (){
        return cargo.listarTodos();
    }
}
