<%-- 
    Document   : inserirFuncionario
    Created on : 21/09/2014, 15:09:56
    Author     : Leo
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
        <form action="/ClienteEE/cadastrarFuncionario"  method="post">
           
            CPF: <input type="text" name="cpf"> *</br>
            Nome: <input type="text" name="nome"> *</br>
            <br/>
            Tipo: <input type="text" name="tipo"> *<br/> 

            <input type="submit" value="Cadastrar">
	</form> 
    </body>
</html>