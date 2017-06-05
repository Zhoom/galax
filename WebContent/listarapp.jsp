<%@page import="java.util.ArrayList"%>
<%@page import="modelo.dominio.App"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-BR">
	<head>
		<meta charset="UTF-8"/>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
		<script>
            function openTab(evt, tabName) {
    			// Declarando as variaveis
    			var i, tabcontent, tablinks;

    			// Pega todos os elementos com class="tabcontent" e esconde eles
    			tabcontent = document.getElementsByClassName("tabcontent");
    			for (i = 0; i < tabcontent.length; i++) {
        			tabcontent[i].style.display = "none";
    			}

    			// Pega todos os elementos com class="tablinks" e remove a classe "active"
    			tablinks = document.getElementsByClassName("tablinks");
    			for (i = 0; i < tablinks.length; i++) {
        			tablinks[i].className = tablinks[i].className.replace(" active", "");
   				}

    			// Adiciona a classe "active" ao botão que abriu a aba e exibe ela
    			document.getElementById(tabName).style.display = "block";
    			evt.currentTarget.className += " active";
			}
        </script>
        <style>
        	table, td{
        		border:1px solid #cfcfd0;
        		color:#cfcfd0;
        	}
        	
        	td{
        		padding:5px;
        	}
        	body{
        		background-color:#222740;
        	}
        	.remove-link-dec{
        		color:#b46262;
        		text-decoration:none;
        	}
        </style>
</head>
<%
	List<App> lista = (List<App>) request.getAttribute("lista");
	if (lista == null)
		lista = new ArrayList<App>();
%>
<body ng-app="">
	<jsp:include page="_login.jsp"/>
	<a href="home.jsp">Home</a>
	<a href="registrarapp.jsp"></a>

	<form action="filtrarApps" method=POST>
		<input type=text name="nome-app">
		<input type="submit">
	</form>
	
	<table>
		<tr>
			<td>Ação</td>
			<td>Id</td>
			<td>Nome</td>
			<td>Desenvolvedor</td>
			<td>Descrição</td>
			<td>Sobre</td>
			<td>OS minimo</td>
			<td>Processador minimo</td>
			<td>Memoria minimo</td>
			<td>Placa de Video minimo</td>
			<td>DirectX minimo</td>
			<td>Armazenamento minimo</td>
			<td>OS recomendado</td>
			<td>Processador recomendado</td>
			<td>Memoria recomendado</td>
			<td>Placa de Video recomendado</td>
			<td>DirectX recomendado</td>
			<td>Armazenamento recomendado</td>
		</tr>

<% for (App app : lista) { %>
		<tr>
			<td>
				<a href="editarApp?app-codigo=<%=app.getAppIDStr()%>" class="remove-link-dec">Editar</a>
				<a href="removerApp?app-codigo=<%=app.getAppIDStr()%>" class="remove-link-dec">Remover</a>
			</td>
			<td><%=app.getAppIDStr()%></td>
			<td><%=app.getAppNome()%></td>
			<td><%=app.getDesenvolvedor()%></td>
			<td><%=app.getDescricao()%></td>
			<td><%=app.getSobreApp()%></td>
			<td><%=app.getRequisitoMinimo().getSystemOS()%></td>
			<td><%=app.getRequisitoMinimo().getSystemProcessor()%></td>
			<td><%=app.getRequisitoMinimo().getSystemMemory()%></td>
			<td><%=app.getRequisitoMinimo().getSystemVideoCard()%></td>
			<td><%=app.getRequisitoMinimo().getSystemDirectX()%></td>
			<td><%=app.getRequisitoMinimo().getSystemHD()%></td>
			
			<td><%=app.getRequisitoRecomendado().getSystemOS()%></td>
			<td><%=app.getRequisitoRecomendado().getSystemProcessor()%></td>
			<td><%=app.getRequisitoRecomendado().getSystemMemory()%></td>
			<td><%=app.getRequisitoRecomendado().getSystemVideoCard()%></td>
			<td><%=app.getRequisitoRecomendado().getSystemDirectX()%></td>
			<td><%=app.getRequisitoRecomendado().getSystemHD()%></td>
		</tr>
<% } %>
	</table>
</body>
</html>