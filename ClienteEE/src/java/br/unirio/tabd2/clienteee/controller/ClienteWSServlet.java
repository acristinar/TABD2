package br.unirio.tabd2.clienteee.controller;


import br.unirio.tabd2.webservice.Funcionario;
import br.unirio.tabd2.webservice.FuncionarioService_Service;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Amanda
 */
public class ClienteWSServlet extends HttpServlet{
    //@WebServiceRef(wsdlLocation="http://localhost:8080/FuncionarioWS/FuncionarioService?wsdl")
    //FuncionarioService_Service funcionarioService;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
            //List<Funcionario> listaFuncionario = funcionarioService.getFuncionarioServicePort().listarFuncionario();
            List<Funcionario> listaFuncionario = listarFuncionario();
            request.setAttribute("listaFuncionario", listaFuncionario);
            
            request.setAttribute("debug", "caralho");
            
            RequestDispatcher rd = request.getRequestDispatcher("teste.jsp");
            rd.forward(request, response);        
        }catch(Exception e){
            e.getMessage();
        }
    }

    private static java.util.List<br.unirio.tabd2.webservice.Funcionario> listarFuncionario() {
        br.unirio.tabd2.webservice.FuncionarioService_Service service = new br.unirio.tabd2.webservice.FuncionarioService_Service();
        br.unirio.tabd2.webservice.FuncionarioService port = service.getFuncionarioServicePort();
        return port.listarFuncionario();
    }
    
}

