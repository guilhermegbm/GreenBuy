/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.MysqlDAO;

import Modelo.BEAN.CargoBEAN;
import Modelo.MysqlDAO.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Isabella
 */
public class CargoMysqlDAO {
    private Connection connection;
    private PreparedStatement stmt;

    public CargoMysqlDAO() {
        this.connection = ConnectionFactory.getConnection();
    }
    
    public ArrayList<CargoBEAN> listarTodos(){
        String sql = "select * from cargo";
        ArrayList<CargoBEAN> auxAL = new ArrayList<CargoBEAN>();
        
        try {
            stmt = connection.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                CargoBEAN c = new CargoBEAN();
                
                c.setCodigo(rs.getInt(1));
                c.setNome(rs.getString(2));
                
                auxAL.add(c);
            }
            stmt.close();
            
            return auxAL;
            
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }
    
}
