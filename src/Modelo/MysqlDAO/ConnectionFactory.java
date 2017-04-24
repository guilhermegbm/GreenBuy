package Modelo.MysqlDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * fabrica de conexão - padrão factory
 */
public class ConnectionFactory {
    
    //singleton
    private static ConnectionFactory instance = new ConnectionFactory();
    
    /*constantes (static final) - esses valores nunca muda ao longo da execução
    do programa*/
    public static final String URL = "jdbc:mysql://localhost:3306/bdGreenBuyNaoOficial"; //caminho para o BD
    public static final String USER = "root"; //nome do usuario
    public static final String PASSWORD = ""; //senha
    public static final String DRIVER_CLASS = "org.gjt.mm.mysql.Driver"; //nome do driver
    
   //construtor privado - padrão singleton - garantir unica 
   // instancia para todo o aplicativo
    
    //public static void main(String[] args) {
    //    try {
    //        new ConnectionFactory();
    //        System.out.println("Conectado com sucesso!!");
    //    } catch (Exception e) {
    //        System.out.println("erro na conexão!" + e);
    //    }
    //}
    
    
    private ConnectionFactory() {
        try {
            //registra o driver - para isso funcionar deve adicionar o driver do BD
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
     
    private Connection createConnection() {
        Connection connection = null;
        /* sempre que for trabalhar com BD deve-se colocar os comandos
        dentro de uma instrução try-catch
        */
        try {
            //realiza a conexao com o BD MySQL
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Banco de dados conectato com sucesso");
        } catch (SQLException e) {
            //se algo der errado vem para a instrução catch e da erro
            System.out.println("ERRO: Erro na conexão com o banco de dados:");
            System.out.println(e);
        }
        return connection;
    }   
        
    //método publico que retorna a conexao unica do BD 
    public static Connection getConnection() {
        return instance.createConnection();
    }
    
}
