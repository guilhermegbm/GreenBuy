/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.SQL;

import JasperSoft.ConnectionFactory;
import Jpa.JpaUtil;
import Modelo.BEAN.Cargo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Guilherme
 */
public class CargoTeste {
    private Connection connection;
    private PreparedStatement stmt;

    public CargoTeste() {
        this.connection = ConnectionFactory.getConnection();
    }
    
    
    
    public void adiciona (Cargo c){
        String sql = "insert into cargo (carNome) values (?)";
        
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, c.getNome());
            
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void deleta (int cod){
        String sql = "delete from cargo where carCodigo = ?";
        
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, cod);
            
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<Cargo> lista (){
        String sql = "select * from cargo;";
        ArrayList<Cargo> carAL = new ArrayList<Cargo>();
        try {
            // prepared statement para inserção
            stmt = connection.prepareStatement(sql);

            // executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                Cargo c = new Cargo();
                c.setCodigo(rs.getInt(1));
                c.setNome(rs.getString(2));
                carAL.add(c);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return carAL;
    }
    
    public List<Cargo> listaHib (){
        EntityManager manager = JpaUtil.getEntityManager();
        
        //List<Cargo> cargos =  new ArrayList<Cargo>();
        try {
            TypedQuery<Cargo> tq = manager.createQuery("from Cargo", Cargo.class);
            //Query query = manager.createQuery("from Cargo"); 
            //cargos = query.getResultList();
         
            return tq.getResultList();
        } finally {
            manager.close();
            //JpaUtil.close();
        }
    }
}
