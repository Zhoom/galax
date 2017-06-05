<%@page import="java.util.ArrayList"%>
<%@page import="modelo.dominio.App"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-BR">
  <head>
    <meta charset="UTF-8"/>
	<link href="main.css" rel="stylesheet" type="text/css">
  </head>
  <%
	List<App> lista = (List<App>) request.getAttribute("lista");
	if (lista == null)
	  lista = new ArrayList<App>();
  %>
  <body ng-app="">
    <jsp:include page="_login.jsp"/>
    <a href="home.jsp">Home</a>
    <br>
	Preview temporario
	<br>
    <div class="lista-jogos">
      <% for(App app : lista) { %>
        <a href="buscarApp?app-codigo=<%=app.getAppIDStr()%>" class="info-jogo-lista">
          <img src="C:\Splash\Images\thumb-unknown.png" class="thumb-jogo-t2"/>
          <div class="info-jogo-lista-titulo"><%=app.getAppNome()%></div>
          <div class="info-jogo-lista-os-compativel"></div>
          <div class="info-jogo-lista-preco">R$ <%=app.getPrecoStr()%></div>
        </a>
      <% } %>
    </div>
  </body>
</html>