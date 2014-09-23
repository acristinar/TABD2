<%-- 
    Document   : alterar
    Created on : 22/09/2014, 21:55:21
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
        <form action="/ClienteEE/alterarFuncionario"  method="post">
           
            CPF: <input type="text" name="cpf" value="${funcionario.cpf}"><br>
            Nome: <input type="text" name="nome" value="${funcionario.nome}"><br>
            Tipo: <input type="text" name="tipo" value="${funcionario.tipo}"><br> 

            <input type="submit" value="Alterar">
	</form> 
    </body>
</html>