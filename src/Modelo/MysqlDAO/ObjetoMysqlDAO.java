/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.MysqlDAO;

import Modelo.BEAN.ObjetoBEAN;
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
public class ObjetoMysqlDAO {
    private Connection connection;
    
    private PreparedStatement stmt;

    public ObjetoMysqlDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    public ArrayList<ObjetoBEAN> listarTodos() {
        String sql = "select * from Objeto join Classe where obj_clsCodigo = clsCodigo order by objCodigo;";
        ArrayList<ObjetoBEAN> auxAL = new ArrayList<ObjetoBEAN>();
        
        try {
            
            stmt = connection.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                ObjetoBEAN obj = new ObjetoBEAN();
                ClasseObjetoBEAN clsObj = new ClasseObjetoBEAN();
                ClasseObjetoMysqlDAO clsMysql = new ClasseObjetoMysqlDAO();
                
                obj.setCodigo(rs.getInt(1));
                obj.setNome(rs.getString(2));
                obj.setDescricao(rs.getString(3));
                obj.setPrecoVendaBase(rs.getFloat(4));
                obj.setPrecoCompraBase(rs.getFloat(5));
                obj.setUnidade(rs.getString(6));
                obj.setQtdeEstoque(rs.getFloat(7));
                obj.setTipoObj(rs.getInt(8));
                
                clsObj = clsMysql.listarPorCodigo(rs.getInt(10));
                // ou
                //tipoObj.setCodigo(rs.getInt(7));
                //tipoObj.setNome(rs.getString(8));
                
                obj.setClasse(clsObj);
                auxAL.add(obj);
            }
            
            stmt.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return auxAL;
    }

    public ArrayList<ObjetoBEAN> listarPorCodigo(int codigo) {
        String sql = "select * from objeto where objCodigo = ?;";
        ArrayList<ObjetoBEAN> auxAL = new ArrayList<ObjetoBEAN>();
        
        try {
            
            stmt = connection.prepareStatement(sql);
            
            stmt.setInt(1, codigo);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                ObjetoBEAN obj = new ObjetoBEAN();
                ClasseObjetoBEAN clsObj = new ClasseObjetoBEAN();
                ClasseObjetoMysqlDAO clsMysql = new ClasseObjetoMysqlDAO();
                
                obj.setCodigo(rs.getInt(1));
                obj.setNome(rs.getString(2));
                obj.setDescricao(rs.getString(3));
                obj.setPrecoVendaBase(rs.getFloat(4));
                obj.setPrecoCompraBase(rs.getFloat(5));
                obj.setUnidade(rs.getString(6));
                obj.setQtdeEstoque(rs.getFloat(7));
                obj.setTipoObj(rs.getInt(8));
                
                clsObj = clsMysql.listarPorCodigo(rs.getInt(9));
                
                obj.setClasse(clsObj);
                
                auxAL.add(obj);
            }
            
            stmt.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return auxAL;
    }

    public void cadastrar(ObjetoBEAN objeto) {
        String sql = "insert into objeto (objNome, objDescricao, objPrecoVendaBase,"
                + " objPrecoCompraBase, objUnidade, objQtdeEstoque, objTipo, obj_clsCodigo) values (?,?,?,?,?,?,?,?);";
        
        try {
            stmt = connection.prepareStatement(sql);
            
            stmt.setString(1,objeto.getNome());
            stmt.setString(2,objeto.getDescricao());
            stmt.setFloat(3,objeto.getPrecoVendaBase());
            stmt.setFloat(4, objeto.getPrecoCompraBase());
            stmt.setString(5,objeto.getUnidade());
            stmt.setFloat(6, objeto.getQtdeEstoque());
            stmt.setInt(7, objeto.getTipoObj());
            stmt.setInt(8,objeto.getClasse().getCodigo());
            
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletar(int codigo) {
        String sql = "delete from objeto where objCodigo = ?;";
        
        try {
            stmt = connection.prepareStatement(sql);
            
            stmt.setInt(1, codigo);
            
            int del = stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void editar(ObjetoBEAN obj) {
        String sql = "update objeto set objNome = ?, objDescricao = ?, objPrecoVendaBase = ?, "
                + "objPrecoCompraBase = ?, objUnidade = ?, objQtdeEstoque = ?, objTipo = ?, obj_clsCodigo = ?"
                + " where objCodigo = ?;";
        
        try {
            stmt = connection.prepareStatement(sql);
            
            stmt.setString(1,obj.getNome());
            stmt.setString(2,obj.getDescricao());
            stmt.setFloat(3,obj.getPrecoVendaBase());
            stmt.setFloat(4, obj.getPrecoCompraBase());
            stmt.setString(5,obj.getUnidade());
            stmt.setFloat(6, obj.getQtdeEstoque());
            stmt.setInt(7, obj.getTipoObj());
            stmt.setInt(8,obj.getClasse().getCodigo());
            stmt.setInt(9, obj.getCodigo());
            
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public ArrayList<ObjetoBEAN> listarPorNome(String objN) {
        String sql = "select * from objeto where objNome like '%" + objN + "%';";
        ArrayList<ObjetoBEAN> auxAL = new ArrayList<ObjetoBEAN>();
        
        try {
            
            stmt = connection.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                ObjetoBEAN obj = new ObjetoBEAN();
                ClasseObjetoBEAN clsObj = new ClasseObjetoBEAN();
                ClasseObjetoMysqlDAO clsMysql = new ClasseObjetoMysqlDAO();
                
                obj.setCodigo(rs.getInt(1));
                obj.setNome(rs.getString(2));
                obj.setDescricao(rs.getString(3));
                obj.setPrecoVendaBase(rs.getFloat(4));
                obj.setPrecoCompraBase(rs.getFloat(5));
                obj.setUnidade(rs.getString(6));
                obj.setQtdeEstoque(rs.getFloat(7));
                obj.setTipoObj(rs.getInt(8));
                
                clsObj = clsMysql.listarPorCodigo(rs.getInt(9));
                
                obj.setClasse(clsObj);
                
                auxAL.add(obj);
            }
            
            stmt.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return auxAL;
    }
    
    
    public ArrayList<ObjetoBEAN> listarPorMenorValor(float menValor){
        String sql = "select * from objeto where objPrecoVendaBase > ?;";
        ArrayList<ObjetoBEAN> auxAL = new ArrayList<ObjetoBEAN>();
        
        try {
            stmt = connection.prepareStatement(sql);
            
            stmt.setFloat(1, menValor);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {                
                ObjetoBEAN obj = new ObjetoBEAN();
                ClasseObjetoBEAN clsObj = new ClasseObjetoBEAN();
                ClasseObjetoMysqlDAO clsMysql = new ClasseObjetoMysqlDAO();
                
                obj.setCodigo(rs.getInt(1));
                obj.setNome(rs.getString(2));
                obj.setDescricao(rs.getString(3));
                obj.setPrecoVendaBase(rs.getFloat(4));
                obj.setPrecoCompraBase(rs.getFloat(5));
                obj.setUnidade(rs.getString(6));
                obj.setQtdeEstoque(rs.getFloat(7));
                obj.setTipoObj(rs.getInt(8));
                
                clsObj = clsMysql.listarPorCodigo(rs.getInt(9));
                
                obj.setClasse(clsObj);
                
                auxAL.add(obj);
            }
            
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        
        return auxAL;
    }

    public ArrayList<ObjetoBEAN> listarPorMaiorValor(float maiValor) {
        String sql = "select * from objeto where objPrecoVendaBase < ?;";
        ArrayList<ObjetoBEAN> auxAL = new ArrayList<ObjetoBEAN>();
        
        try {
            stmt = connection.prepareStatement(sql);
            
            stmt.setFloat(1, maiValor);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {                
                ObjetoBEAN obj = new ObjetoBEAN();
                ClasseObjetoBEAN clsObj = new ClasseObjetoBEAN();
                ClasseObjetoMysqlDAO clsMysql = new ClasseObjetoMysqlDAO();
                
                obj.setCodigo(rs.getInt(1));
                obj.setNome(rs.getString(2));
                obj.setDescricao(rs.getString(3));
                obj.setPrecoVendaBase(rs.getFloat(4));
                obj.setPrecoCompraBase(rs.getFloat(5));
                obj.setUnidade(rs.getString(6));
                obj.setQtdeEstoque(rs.getFloat(7));
                obj.setTipoObj(rs.getInt(8));
                
                clsObj = clsMysql.listarPorCodigo(rs.getInt(9));
                
                obj.setClasse(clsObj);
                
                auxAL.add(obj);
            }
            
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        
        return auxAL;
    }
    
}
