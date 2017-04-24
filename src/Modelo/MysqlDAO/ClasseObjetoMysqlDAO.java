/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.MysqlDAO;

import Modelo.BEAN.ClasseObjetoBEAN;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Henrique
 */
public class ClasseObjetoMysqlDAO {
    
    private Connection connection;
    
    private PreparedStatement stmt;

    public ClasseObjetoMysqlDAO() {
        this.connection = ConnectionFactory.getConnection();
    }
    
    

    public ClasseObjetoBEAN listarPorCodigo(int codigo) {
        
        ArrayList<ClasseObjetoBEAN> auxAL = this.listarTodos();
        
        for (ClasseObjetoBEAN tipoC : auxAL) {
            if(codigo == tipoC.getCodigo()){
                return tipoC;
            }
        }
        return null;
    }

    public ArrayList<ClasseObjetoBEAN> listarTodos() {
        ArrayList<ClasseObjetoBEAN> auxAL = new ArrayList<ClasseObjetoBEAN>();
        String sql = "select * from Classe";
        
        try {
            stmt = connection.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                ClasseObjetoBEAN tipoC = new ClasseObjetoBEAN();
                
                tipoC.setCodigo(rs.getInt(1));
                tipoC.setNome(rs.getString(2));
                
                auxAL.add(tipoC);
            }
            stmt.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return auxAL;
    }

    public void cadastrar(String nome) {
        String sql = "insert into Classe (clsNome) values (?);";
        
        try {
            stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, nome);
            
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    
    
}