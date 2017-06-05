<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-BR">
  <head>
    <meta charset="UTF-8"/>
    <title>Home</title>
    <style>
	  .a{
	    display:block;
	  }
    </style>
  </head>
  
  <body class="a">
  <%
  
  %>
    <jsp:include page="_login.jsp"/>
    <span class="title">Preview temporario</span>
	<br><br>
	<a href="registrarapp.jsp" class="a">Registrar um App</a>
	<a href="listarApp" class="a">Listar Apps</a>
	<a href="loja" class="a">Loja</a>
	<a href="login.jsp" class="a">Login</a>
  </body>
</html>