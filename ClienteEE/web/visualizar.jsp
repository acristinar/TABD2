<%-- 
    Document   : visualizar
    Created on : 22/09/2014, 16:20:02
    Author     : Amanda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tl" %>
        <title>Funcionário Web Service</title>
    </head>
    <body>
        <h1 id="title">Funcionário</h1>
	
        CPF: ${funcionario.cpf}
        <br>
        
	Nome: ${funcionario.nome}
	<br>
	       
        Tipo: ${funcionario.tipo} 
	<br>
	
    </body>
</html>
