package br.unirio.tabd2.dao;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author Amanda
 */
public class FuncionarioDAO {
    private static String dbURL = "jdbc:postrgresql://localhost:5432/SOA";
    private static Connection conn = null;
    
    private static void abrirConexao(){
        try{
            Class.forName("org.postgresql.Driver").newInstance();
            conn = (Connection) DriverManager.getConnection(dbURL,"amanda","123456");

        }catch(Exception e){
            e.printStackTrace();
        }
    
    }
    
}
