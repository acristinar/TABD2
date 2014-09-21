
package br.unirio.tabd2.webService;

import br.unirio.tabd2.dao.Funcionario;
import br.unirio.tabd2.dao.FuncionarioDAO;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Amanda
 */
@WebService(serviceName = "FuncionarioService")
public class FuncionarioService {
    
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "listarFuncionario")
    public List<Funcionario> listarFuncionario(){
        FuncionarioDAO dao = new FuncionarioDAO();
        List<Funcionario> listaFuncionario = dao.listarFuncionario();
        
        return listaFuncionario;
    
    }
    
    
}
