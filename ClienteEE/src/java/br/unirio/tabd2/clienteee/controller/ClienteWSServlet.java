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
    
    //distribui todas as chamadas GET
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try{
            if (action.equals("/funcionario")){ 
                listar(request, response);
            }else if(action.equals("/consultarFuncionario")){ 
                consultar(request, response);
            }
            else if(action.equals("/visualizarFuncionario")){ 
                visualizar(request, response);
            }
            else if(action.equals("/excluirFuncionario")){ 
                excluir(request, response);
            }
            else if(action.equals("/alterarFuncionario")){ 
                alterar(request, response);
            }
            else if(action.equals("/cadastrarFuncionario")){ 
                cadastrar(request, response);
            }
        }catch(Exception e){
            response.sendRedirect(" " + e.getMessage());
        }
        
    }
    
    //distribui todas as chamadas POST, copia a switch de cima ...
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String action = request.getServletPath();
        try{
            if (action.equals("/inserirFuncionario")){ 
                inserir(request, response);
            }else if(action.equals("/alterarFuncionario")){ 
                alterar(request, response);
            }
        }catch(Exception e){
            response.sendRedirect(" " + e.getMessage());
        }
    }
    
    protected void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
            List<Funcionario> listaFuncionario = listarFuncionario();
            request.setAttribute("listaFuncionario", listaFuncionario);
            
            
            RequestDispatcher rd = request.getRequestDispatcher("funcionario.jsp");
            rd.forward(request, response);        
        }catch(Exception e){
            response.sendRedirect(" " + e.getMessage());
        }
    }

    private static java.util.List<br.unirio.tabd2.webservice.Funcionario> listarFuncionario() {
        br.unirio.tabd2.webservice.FuncionarioService_Service service = new br.unirio.tabd2.webservice.FuncionarioService_Service();
        br.unirio.tabd2.webservice.FuncionarioService port = service.getFuncionarioServicePort();
        return port.listarFuncionario();
    }
    
    protected void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
            RequestDispatcher rd = request.getRequestDispatcher("inserir.jsp"); 
            rd.forward(request, response);       
            
        }
        catch(Exception e){
            response.sendRedirect(" " + e.getMessage());
        }
    
    }
    
    protected void inserir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
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
    
    protected void consultar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
            RequestDispatcher rd = request.getRequestDispatcher("consultar.jsp"); 
            rd.forward(request, response);       
            
        }
        catch(Exception e){
            response.sendRedirect(" " + e.getMessage());
        }
    
    }

    protected void visualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        int cpf = Integer.valueOf(request.getParameter("cpf"));
        try{
            Funcionario funcionario = consultarFuncionario(cpf);
            
            request.setAttribute("funcionario", funcionario);
            
            
            RequestDispatcher rd = request.getRequestDispatcher("visualizar.jsp"); 
            rd.forward(request, response);       
            
        }
        catch(Exception e){
            response.sendRedirect(" " + e.getMessage());
        } 
    
    }
    
    private static Funcionario consultarFuncionario(int cpf) {
        br.unirio.tabd2.webservice.FuncionarioService_Service service = new br.unirio.tabd2.webservice.FuncionarioService_Service();
        br.unirio.tabd2.webservice.FuncionarioService port = service.getFuncionarioServicePort();
        return port.consultarFuncionario(cpf);
    }
    
    protected void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cpf = Integer.valueOf(request.getParameter("cpf"));
        
        try{
            excluirFuncionario(cpf);
            	
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);

        }catch (Exception e) {
            response.sendRedirect(" " + e.getMessage());
        }
    }

    private static void excluirFuncionario(int cpf) {
        br.unirio.tabd2.webservice.FuncionarioService_Service service = new br.unirio.tabd2.webservice.FuncionarioService_Service();
        br.unirio.tabd2.webservice.FuncionarioService port = service.getFuncionarioServicePort();
        port.excluirFuncionario(cpf);
    }
    
    /*
    protected void antesAlterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cpf = Integer.valueOf(request.getParameter("cpf"));
        String nome=(String) request.getParameter("nome");
        String tipo= (String) request.getParameter("tipo");
        Funcionario funcionario=new Funcionario();
        funcionario.setCpf(cpf);
        funcionario.setNome(nome);
        funcionario.setTipo(tipo);
        try{
            request.setAttribute("funcionario", funcionario);
            	
            RequestDispatcher rd = request.getRequestDispatcher("alterar.jsp");
            rd.forward(request, response);

        }catch (Exception e) {
            response.sendRedirect(" " + e.getMessage());
        }
    }
    */
    
    protected void alterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cpf = Integer.valueOf(request.getParameter("cpf"));
        
        if((request.getParameter("nome") != null) && (request.getParameter("tipo") != null)){
            String nome=(String) request.getParameter("nome");
            String tipo= (String) request.getParameter("tipo");
        
            Funcionario funcionario=new Funcionario();
            funcionario.setCpf(cpf);
            funcionario.setNome(nome);
            funcionario.setTipo(tipo);
            try{
                alterarFuncionario(funcionario);

                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);

            }catch (Exception e) {
                response.sendRedirect(" " + e.getMessage()); 
            }
        }
        else{
            try{
                Funcionario funcionario = consultarFuncionario(cpf);
                request.setAttribute("funcionario", funcionario);

                RequestDispatcher rd = request.getRequestDispatcher("alterar.jsp"); 
                rd.forward(request, response);       
            }
            catch(Exception e){
                response.sendRedirect(" " + e.getMessage());
            }
        }
        
    }

    private static void alterarFuncionario(br.unirio.tabd2.webservice.Funcionario funcionario) {
        br.unirio.tabd2.webservice.FuncionarioService_Service service = new br.unirio.tabd2.webservice.FuncionarioService_Service();
        br.unirio.tabd2.webservice.FuncionarioService port = service.getFuncionarioServicePort();
        port.alterarFuncionario(funcionario);
    }
    
    
    
}

