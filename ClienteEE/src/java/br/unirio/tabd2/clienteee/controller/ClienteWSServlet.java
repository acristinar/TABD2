package br.unirio.tabd2.clienteee.controller;


import br.unirio.tabd2.webservice.Funcionario;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listar(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	cadastrar(request,response);
    }
    
    protected void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
            List<Funcionario> listaFuncionario = listarFuncionario();
            request.setAttribute("listaFuncionario", listaFuncionario);
            
            
            RequestDispatcher rd = request.getRequestDispatcher("funcionario.jsp");
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
    
    protected void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = (String) request.getParameter("nome");
        Integer cpf = Integer.valueOf(request.getParameter("cpf"));
        String tipo = (String) request.getParameter("tipo"); 
        Funcionario funcionario = new Funcionario();
        funcionario.setCpf(cpf);
        funcionario.setNome(nome);
        funcionario.setTipo(tipo);
        try{
            inserirFuncionario(funcionario);
            request.setAttribute("funcionario", funcionario);		
            RequestDispatcher rd = request.getRequestDispatcher("funcionario.jsp");
            rd.forward(request, response);

        }catch (Exception e) {
            response.sendRedirect(" " + e.getMessage());
        }
        
        
    }
    
    private static void inserirFuncionario(br.unirio.tabd2.webservice.Funcionario funcionario) {
        br.unirio.tabd2.webservice.FuncionarioService_Service service = new br.unirio.tabd2.webservice.FuncionarioService_Service();
        br.unirio.tabd2.webservice.FuncionarioService port = service.getFuncionarioServicePort();
        port.inserirFuncionario(funcionario);
    }
}

