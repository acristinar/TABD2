package br.unirio.tabd2.webService;

import br.unirio.tabd2.dao.Funcionario;
import br.unirio.tabd2.dao.FuncionarioDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 * @author Amanda
 */
@WebService(serviceName = "FuncionarioService")
public class FuncionarioService {
    
    @WebMethod(operationName = "listarFuncionario")
    public List<Funcionario> listarFuncionario(){
        FuncionarioDAO dao = new FuncionarioDAO();
        List<Funcionario> listaFuncionario = dao.listarFuncionario();
        
        return listaFuncionario;
    }
    
    @WebMethod(operationName = "inserirFuncionario")
    public void inserirFuncionario(@WebParam(name="funcionario") Funcionario funcionario) {
        FuncionarioDAO dao = new FuncionarioDAO();
       
        try {
            dao.incluir(funcionario);
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   @WebMethod(operationName = "consultarFuncionario")
    public Funcionario consultarFuncionario(@WebParam(name="cpf") int cpf){
        FuncionarioDAO dao = new FuncionarioDAO();
        
        Funcionario funcionario = null;
        try {
            funcionario = dao.consultar(cpf);
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return funcionario;
        
    } 
    
    @WebMethod(operationName = "excluirFuncionario")
    public void excluirFuncionario(@WebParam(name="cpf") int cpf) {
        FuncionarioDAO dao =new FuncionarioDAO();
        try {
            dao.excluir(cpf);
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioService.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    @WebMethod(operationName = "alterarFuncionario")
    public void alterarFuncionario(@WebParam(name="funcionario") Funcionario funcionario) {
        FuncionarioDAO dao =new FuncionarioDAO();
        try {
            dao.alterar(funcionario);
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioService.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
