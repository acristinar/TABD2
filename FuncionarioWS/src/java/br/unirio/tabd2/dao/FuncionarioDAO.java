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
    private static String dbURL = "jdbc:postgresql://localhost:5432/SOA";
    private static Connection conn = null;
    
    private static void abrirConexao(){
        try{
            Class.forName("org.postgresql.Driver").newInstance();
            conn = (Connection) DriverManager.getConnection(dbURL,"postgres","123456");
        }catch(Exception e){
            e.printStackTrace();
        }
    
    }
    
    public List<Funcionario> listarFuncionario(){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
        Funcionario funcionario = null;
        
        try{
            abrirConexao();
            String sql = "SELECT * FROM funcionario";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
            //funcionario = new Funcionario(111111,"Amanda","pessoa");
            //listaFuncionario.add(funcionario);
            //funcionario = new Funcionario(222222,"Daniel","pessoa");
            //listaFuncionario.add(funcionario);
            //funcionario = new Funcionario(666666,"Eddie","zumbi");
                listaFuncionario.add(new Funcionario(rs.getInt("cpf"),rs.getString("nome"),rs.getString("tipo")));
            }
        }catch(Exception e){
            System.out.println("Erro ao abrir conexão: "+ e.getMessage());       
        }finally{
            //adicionar fecharConexao() depois
        }
        
      return listaFuncionario;  
    }
    
    public void incluir(Funcionario funcionario )throws SQLException {
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try{
            abrirConexao();
            String sql="insert into funcionario values("+funcionario.getCpf()+",'"+funcionario.getNome()+"','"+funcionario.getTipo()+"')";
            stmt=conn.prepareStatement(sql);
            rs=stmt.executeQuery();
            
        }catch(SQLException e){
            System.out.println("Erro na inserção "+e.getMessage());
        }finally{
            conn.close();
        }
    }
        
    public Funcionario consultar(int cpf) throws SQLException{
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Funcionario funcionario = null;
        
        try{
            abrirConexao();
            String sql = "SELECT * FROM funcionario WHERE cpf = ? ";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, cpf);
            rs = stmt.executeQuery();
            while(rs.next()){
                funcionario = new Funcionario();
                funcionario.setCpf(rs.getInt("cpf"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setTipo(rs.getString("tipo"));
            }
        }catch(SQLException e){
            System.out.println("Erro na consulta "+e.getMessage());
        }finally{
            conn.close();
        }
    
        return funcionario;
    }
    
    public void excluir(int cpf )throws SQLException {
        PreparedStatement stmt=null;
        ResultSet rs = null;
        try{
            abrirConexao();
            String sql="delete from funcionario where cpf="+cpf+";"; 
            stmt=conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
        }catch(SQLException e){
            System.out.println("Erro na deleção "+e.getMessage());
        }finally{
            conn.close();
        }
        
    }
    
    
}
