<%-- 
    Document   : consultar
    Created on : 22/09/2014, 14:59:34
    Author     : Amanda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tl" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Funcionario - Web Service</title>
    </head>
    <body>
        <h1>Consultar Funcionário</h1>
	
        <form action="/ClienteEE/visualizarFuncionario" method="GET">
            <label>CPF:</label>
            <input type="text" name="cpf" /><br>
            <input type="submit" value="Consulta">
        </form>
	
	
    </body>
</html>
