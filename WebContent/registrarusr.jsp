<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="pt-BR">
  <head>
    <meta charset="UTF-8"/>
    <title>Registrar Usuario</title>
  </head>
  <body>
    <jsp:include page="_login.jsp"/>
    <%
      List<String> erros = (List<String>) request.getAttribute("erros");
      if (erros != null){
  	    for (String erro : erros){%>
  	      <%=erro%>
  	    <%}
    }%>
  	  	
	<form action="registrarUsuario" method="POST">
	  Usuario<br>
	  <input type="text" name="login-usuario"/><br><br>
	  Senha<br>
	  <input type="password" name="senha-usuario"/><br><br>
	  E-mail<br>
	  <input type="mail" name="email-usuario"/><br><br>
	  <input type="submit" value="Registrar"/>
	  <input type="button" class="button" value="Cancelar" onclick="window.location='home.jsp'"/>
	</form>
  </body>
</html>