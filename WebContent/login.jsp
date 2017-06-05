<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-BR">
  <head>
    <meta charset="UTF-8"/>
	<title>Login</title>
  </head>

  <body>
    <jsp:include page="_login.jsp"/>
    <%List<String> erros = (List<String>) request.getAttribute("erros");
  
  	if (erros != null){
  	  for (String erro : erros){%>
  	    <%=erro%>
  	  <%}
  	}%>
  	  	
	<form action="abrirSessao" method="POST">
	  <table border="0" cellspacing="0" cellpadding="4">
	    <tr>
		  <td>Login:</td>
		  <td><input type="text" name="login-usuario" value="" size="20" maxlength="100"/></td>
		</tr>
	    <tr>
		  <td>Senha:</td>
		  <td><input type="password" name="senha-usuario" value="" size="20" maxlength="100"/></td>
		</tr>
		<tr>
		  <td></td>
		  <td><input type="submit" name="enviar" value="Enviar"/></td>
		  <td><input type="button" class="button" value="Registrar" onclick="window.location='registrarusr.jsp'"/></td>
		  <td><input type="button" class="button" value="Cancelar" onclick="window.location='home.jsp'"/></td>
		</tr>
	  </table>
	</form>
  </body>
</html>