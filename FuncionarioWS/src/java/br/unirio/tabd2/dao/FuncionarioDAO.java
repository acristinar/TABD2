package br.unirio.tabd2.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Amanda
 */
public class FuncionarioDAO {
    private static String dbURL = "jdbc:postgresql://localhost:5432/postgres";
    private static Connection conn = null;
    
    private static void abrirConexao(){
        try{
            Class.forName("org.postgresql.Driver").newInstance();
            conn = (Connection) DriverManager.getConnection(dbURL,"postgres","1234");

        }catch(Exception e){
            e.printStackTrace();
        }
    
    }
    
    public List<Funcionario> listarFuncionario(){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
        Funcionario funcionario = new Funcionario();
        
        try{
            abrirConexao();
            String sql = "SELECT * FROM funcionario";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                listaFuncionario.add(new Funcionario(rs.getInt("cpf"),rs.getString("nome"),rs.getString("tipo")));
            }
        }catch(Exception e){
            System.out.println("Erro ao abrir conexão: "+ e.getMessage());       
        }finally{
            //adicionar fecharConexao() depois
        }
        
      return listaFuncionario;  
    }
    
}
