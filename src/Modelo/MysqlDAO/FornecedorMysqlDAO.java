/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.MysqlDAO;

import Modelo.BEAN.FornecedorBEAN;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Henrique
 */
public class FornecedorMysqlDAO {
    
    private Connection connection;
    
    private PreparedStatement stmt;

    public FornecedorMysqlDAO() {
        
        this.connection = ConnectionFactory.getConnection();
        
    }
    

    public ArrayList<FornecedorBEAN> listarTodos() {
        String sql = "select * from fornecedor;";
        ArrayList<FornecedorBEAN> auxAL = new ArrayList<FornecedorBEAN>();
        
        try {
            stmt = connection.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                FornecedorBEAN forn = new FornecedorBEAN();
                
                forn.setCodigo(rs.getInt(1));
                forn.setNome(rs.getString(2));
                forn.setTipo(rs.getInt(3));
                forn.setCpf(rs.getString(4));
                forn.setCnpj(rs.getString(5));
                forn.setTelefone(rs.getString(6));
                
                auxAL.add(forn);
            }
            
            stmt.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return auxAL;
    }

    public ArrayList<FornecedorBEAN> listarPorCodigo(int codigo) {
        String sql = "select * from fornecedor where forCodigo = ?;";
        ArrayList<FornecedorBEAN> auxAL = new ArrayList<FornecedorBEAN>();
        
        try {
            
            stmt = connection.prepareStatement(sql);
            
            stmt.setInt(1, codigo);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                FornecedorBEAN forn = new FornecedorBEAN();
                
                forn.setCodigo(rs.getInt(1));
                forn.setNome(rs.getString(2));
                forn.setTipo(rs.getInt(3));
                forn.setCpf(rs.getString(4));
                forn.setCnpj(rs.getString(5));
                forn.setTelefone(rs.getString(6));
                
                auxAL.add(forn);
            }
            
            stmt.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return auxAL;
    }

    public ArrayList<FornecedorBEAN> listarPorNome(String nome) {
        String sql = "select * from fornecedor where forNome like '%" + nome + "%';";
        ArrayList<FornecedorBEAN> auxAL = new ArrayList<FornecedorBEAN>();
        
        try {
            
            stmt = connection.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                FornecedorBEAN forn = new FornecedorBEAN();
                
                forn.setCodigo(rs.getInt(1));
                forn.setNome(rs.getString(2));
                forn.setTipo(rs.getInt(3));
                forn.setCpf(rs.getString(4));
                forn.setCnpj(rs.getString(5));
                forn.setTelefone(rs.getString(6));
                
                auxAL.add(forn);
            }
            
            stmt.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return auxAL;
    }

    public ArrayList<FornecedorBEAN> listarPorCNPJ(String cnpj) {
        String sql = "select * from fornecedor where forCNPJ = '%" + cnpj + "%';";
        ArrayList<FornecedorBEAN> auxAL = new ArrayList<FornecedorBEAN>();
        
        try {
            
            stmt = connection.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                FornecedorBEAN forn = new FornecedorBEAN();
                
                forn.setCodigo(rs.getInt(1));
                forn.setNome(rs.getString(2));
                forn.setTipo(rs.getInt(3));
                forn.setCpf(rs.getString(4));
                forn.setCnpj(rs.getString(5));
                forn.setTelefone(rs.getString(6));
                
                auxAL.add(forn);
            }
            
            stmt.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return auxAL;
    }

    public void editar(FornecedorBEAN forn) {
        String sql = "update Fornecedor set forNome = ?,forTipo = ?, forCPF= ?, forCNPJ = ?, forTelefone = ? where forCodigo = ?;";
        
        try {
            
            stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, forn.getNome());
            stmt.setInt(2, forn.getTipo());
            stmt.setString(3, forn.getCpf());
            stmt.setString(4, forn.getCnpj());
            stmt.setString(5, forn.getTelefone());
            stmt.setInt(6, forn.getCodigo());
            
            stmt.executeUpdate();
            stmt.close();
            
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void cadastrar(FornecedorBEAN forn) {
        String sql = "insert into Fornecedor (forNome, forTipo, forCPF, forCNPJ, forTelefone) values (?,?,?,?,?);";
        
        try {
            stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, forn.getNome());
            stmt.setInt(2, forn.getTipo());
            stmt.setString(3, forn.getCpf());
            stmt.setString(4, forn.getCnpj());
            stmt.setString(5, forn.getTelefone());
            
            stmt.execute();
            stmt.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void deletar(int codigo) {
        String sql = "delete from fornecedor where forCodigo = ?;";
        
        try {
            stmt = connection.prepareStatement(sql);
            
            stmt.setInt(1, codigo);
            
            int del = stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
