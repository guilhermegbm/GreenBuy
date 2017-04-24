package Modelo.MysqlDAO;

import Modelo.BEAN.ClienteBEAN;
import Modelo.MysqlDAO.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.xml.transform.Source;

public class ClienteMysqlDAO {
    //armazena o obj de conexão com o BD mySql
    private Connection connection;
    //obj stmt que executa as consultas no BD
    private PreparedStatement stmt;
    
    public ClienteMysqlDAO() {
       //inicializa a conexão com o BD
        this.connection =  ConnectionFactory.getConnection();    
    }

    public void cadastrar(ClienteBEAN c) {
        //muda os campos de acordo com o seu banco de dados
        String sql = "Insert INTO Cliente (cliNome, cliLogin, cliSenha, cliEmail, cliTelefone) VALUES (?,?,?,?,?)";
        
        try{
            //prepared statement para inserção
            stmt = connection.prepareStatement(sql);
            
            //seta os valores
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getLogin());
            stmt.setString(3, c.getSenha());
            stmt.setString(4, c.getEmail());
            stmt.setString(5, c.getTelefone());
            
            //executa
            stmt.execute();
            stmt.close();
            
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public ArrayList<ClienteBEAN> listarTodos() {
        String sql = "select * from cliente;";
        ArrayList<ClienteBEAN> clienteAL = new ArrayList<ClienteBEAN>();
        try{
            stmt = connection.prepareStatement(sql);
            
            //executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no arrayList
            while (rs.next()){
                ClienteBEAN c = new ClienteBEAN();
                c.setCodigo(rs.getInt(1));
                c.setNome(rs.getString(2));
                c.setLogin(rs.getString(3));
                c.setSenha(rs.getString(4));
                c.setEmail(rs.getString(5));
                c.setTelefone(rs.getString(6));
                //adiciona os dados no array
                clienteAL.add(c);
            }
            stmt.close();
        }catch (SQLException e ){
            throw new RuntimeException(e);
        }
        return clienteAL;
    } 

    public ArrayList<ClienteBEAN> localizarCodigo(int codigo) {
        String sql = "select * from cliente where cliCodigo = ?;";
        
        ArrayList<ClienteBEAN> cliAL = new ArrayList<ClienteBEAN>();
        
        try{
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, codigo);
            //executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no arrayList
            while (rs.next()){
                ClienteBEAN c = new ClienteBEAN();
                
                c.setCodigo(rs.getInt(1));
                c.setNome(rs.getString(2));
                c.setLogin(rs.getString(3));
                c.setSenha(rs.getString(4));
                c.setEmail(rs.getString(5));
                c.setTelefone(rs.getString(6));
                
                cliAL.add(c);
            }
            stmt.close();
        }catch (SQLException e ){
            throw new RuntimeException(e);
        }
        return cliAL;
    }
    public ArrayList<ClienteBEAN> localizarNome(String nome) {
        String sql = "select * from cliente where cliNome like  '%" + nome +"%';";
        ArrayList<ClienteBEAN> auxAL = new ArrayList<ClienteBEAN>();
        
        try{
            stmt = connection.prepareStatement(sql);
            //executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no arrayList
            while (rs.next()){
                ClienteBEAN c = new ClienteBEAN();
                c.setCodigo(rs.getInt(1));
                c.setNome(rs.getString(2));
                c.setEmail(rs.getString(3));
                c.setTelefone(rs.getString(4));
                c.setLogin(rs.getString(5));
                c.setSenha(rs.getString(6));
                
                auxAL.add(c);
                
            }
            stmt.close();
        }catch (SQLException e ){
            throw new RuntimeException(e);
        }
        return auxAL;
    }

    public boolean editar(ClienteBEAN c) {
        String sql = "update cliente set cliNome = ?, cliLogin = ?, cliSenha = ?, cliEmail=?, cliTelefone = ? where cliCodigo = ?;";
        
        try{
            //prepared statement para inserção
            stmt = connection.prepareStatement(sql);
            
            //seta os valores
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getLogin());
            stmt.setString(3, c.getSenha());
            stmt.setString(4, c.getEmail());
            stmt.setString(5, c.getTelefone());
            stmt.setInt(6, c.getCodigo());
            
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

    public boolean remover(int codigo) {
        String sql = "delete from cliente where cliCodigo = ?";
        
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
