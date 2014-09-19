package br.unirio.tabd2.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


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
    
    public List<Funcionario> listarFuncionario() throws SQLException{
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
        Funcionario funcionario = null;
        
        try{
            abrirConexao();
            String sql = "SELECT * FROM Funcionario";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                funcionario = new Funcionario();
                funcionario.setCpf(rs.getInt("cpf"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setTipo(rs.getString("tipo"));
                listaFuncionario.add(funcionario);
            }
        }catch(Exception e){
            System.out.println("Erro ao abrir conexão: "+ e.getMessage());       
        }finally{
            //adicionar fecharConexao() depois
        }
        
      return listaFuncionario;  
    }
    
}
