<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:useBean id="usuario" scope="session" class="modelo.dominio.Usuario"></jsp:useBean>
  Usuário: <jsp:getProperty property="login" name="usuario"/> -
  <a href="logout">Sair</a>