/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.MysqlDAO;

import Controle.ControleFuncionario;
import Modelo.BEAN.CargoBEAN;
import Modelo.BEAN.FuncionarioBEAN;
import Modelo.MysqlDAO.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Isabella
 */
public class FuncionarioMysqlDAO {
    private Connection connection;
    
    private PreparedStatement stmt;

    public FuncionarioMysqlDAO() {
        this.connection = ConnectionFactory.getConnection();
    }
    
    public void cadastrar(FuncionarioBEAN f) {
        //muda os campos de acordo com o seu banco de dados
        String sql = "Insert INTO funcionario (funNome, funCPF, funSalario, funlogin, funSenha, funTelefone, fun_carCodigo) VALUES (?,?,?,?,?,?,?);";
        
        try{
            //prepared statement para inserção
            stmt = connection.prepareStatement(sql);
            
            //seta os valore
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getCpf());
            stmt.setFloat(3, f.getSalario());
            stmt.setString(4, f.getLogin());
            stmt.setString(5, f.getSenha());
            stmt.setString(6, f.getTelefone());
            stmt.setInt(7, f.getCargo().getCodigo());
            
            //executa
            stmt.execute();
            stmt.close();
            
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public ArrayList<FuncionarioBEAN> listarTodos() {
        String sql = "select * from funcionario join cargo where fun_carCodigo = carCodigo order by funCodigo;";
        ArrayList<FuncionarioBEAN> funcAL = new ArrayList<>();
        try{
            stmt = connection.prepareStatement(sql);
            
            //executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no arrayList
            while (rs.next()){
                FuncionarioBEAN f = new FuncionarioBEAN();
                CargoBEAN c = new CargoBEAN();
                
                f.setCodigo(rs.getInt(1));
                f.setNome(rs.getString(2));
                f.setCpf(rs.getString(3));
                f.setSalario(rs.getFloat(4));
                f.setLogin(rs.getString(5));
                f.setSenha(rs.getString(6));
                f.setTelefone(rs.getString(7));
                
                c.setCodigo(rs.getInt(9));
                c.setNome(rs.getString(10));
                
                f.setCargo(c);
                
                //adiciona os dados no array
                funcAL.add(f);
            }
            stmt.close();
        }catch (SQLException e ){
            throw new RuntimeException(e);
        }
        return funcAL;
    } 

    public ArrayList<FuncionarioBEAN> listarPorCodigo(int codigo) {
        ArrayList<FuncionarioBEAN> auxAL = new ArrayList<FuncionarioBEAN>();
        String sql = "select * from funcionario join cargo where fun_carCodigo = carCodigo and funCodigo = ?;";
        
        try{
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, codigo);
            //executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no arrayList
            while (rs.next()){
                
                FuncionarioBEAN f = new FuncionarioBEAN();
                CargoBEAN c = new CargoBEAN();
                
                f.setCodigo(rs.getInt(1));
                f.setNome(rs.getString(2));
                f.setCpf(rs.getString(3));
                f.setSalario(rs.getFloat(4));
                f.setLogin(rs.getString(5));
                f.setSenha(rs.getString(6));
                f.setTelefone(rs.getString(7));
                
                c.setCodigo(rs.getInt(9));
                c.setNome(rs.getString(10));
                
                f.setCargo(c);
                
                //adiciona os dados no array
                auxAL.add(f);
                
            }
            stmt.close();
        }catch (SQLException e ){
            throw new RuntimeException(e);
        }
        return auxAL;
    }
    public ArrayList<FuncionarioBEAN> listarPorNome(String funN) {
        String sql = "select * from funcionario join cargo where fun_carCodigo = carCodigo and funNome like '%" + funN + "%';";
        ArrayList<FuncionarioBEAN> funcAL = new ArrayList<FuncionarioBEAN>();
        
        try{
            stmt = connection.prepareStatement(sql);
            //executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no arrayList
            while (rs.next()){
                FuncionarioBEAN f = new FuncionarioBEAN();
                CargoBEAN c = new CargoBEAN();
                
                f.setCodigo(rs.getInt(1));
                f.setNome(rs.getString(2));
                f.setCpf(rs.getString(3));
                f.setSalario(rs.getFloat(4));
                f.setLogin(rs.getString(5));
                f.setSenha(rs.getString(6));
                f.setTelefone(rs.getString(7));
                
                c.setCodigo(rs.getInt(9));
                c.setNome(rs.getString(10));
                
                f.setCargo(c);
                
                //adiciona os dados no array
                funcAL.add(f);
                
            }
            stmt.close();
        }catch (SQLException e ){
            throw new RuntimeException(e);
        }
        return funcAL;
    }

    public boolean editar(FuncionarioBEAN f) {
        String sql = "update funcionario set funNome = ?,funCPF = ?, funSalario = ?, funLogin = ?, funSenha = ?, funTelefone = ?, fun_carCodigo = ? where funCodigo = ?;";
        
        try{
            //prepared statement para inserção
            stmt = connection.prepareStatement(sql);
            
            //seta os valores
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getCpf());
            stmt.setFloat(3, f.getSalario());
            stmt.setString(4, f.getLogin());
            stmt.setString(5, f.getSenha());
            stmt.setString(6, f.getTelefone());
            stmt.setInt(7, f.getCargo().getCodigo());
            stmt.setInt(8, f.getCodigo());
            
            //executa
            int linhasAtualizadas = stmt.executeUpdate();
            stmt.close();
            if (linhasAtualizadas > 0){
                System.out.println("Foram alterados " + linhasAtualizadas + " resgistros");
            }
            return true;
            
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean deletar(int codigo) {
        String sql = "delete from funcionario where funCodigo = ?";
        
        try{
            //prepared statement para inserção
            stmt = connection.prepareStatement(sql);
            
            //seta os valores
            stmt.setInt(1, codigo);
            
            //executa
            stmt.execute();
            stmt.close();
            return true;
            
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
