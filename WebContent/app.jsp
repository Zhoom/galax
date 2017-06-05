<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-BR">
  <head>
    <meta charset="UTF-8"/>
	<title>Galax</title>
    <link href="ind.css" rel="stylesheet"/>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
  </head>
  <jsp:useBean id="app" scope="request" class="modelo.dominio.App"></jsp:useBean>
  <body>
    <jsp:include page="_login.jsp"/>
    <main id="pagina-app">
      <section id="pagina-app-top">
		<div class="centralizar-app">
		  <header>
		    <h3><%=app.getAppNome()%></h3>
		  </header>
		  <img src="http://cdn.edgecast.steamstatic.com/steam/apps/438740/header.jpg?t=1495823143" alt="Capa do app" class="thumb-app-t2"/>
		  <div id="thumb-app-t2-filtro"></div>
		  <p id="app-descricao"><%=app.getDescricao()%></p>
		  <div id="app-compatibilidade">TODO: icones de compatibilidade de S.O</div>
		  <form action="comprarApp" method="POST">
		    <input type="hidden" name="app-id" value="<%=app.getAppIDStr()%>">
		    <button id="app-botao-compra">Comprar por R$ <%=app.getPrecoStr()%></button>
		  </form>
	    </div>
	  </section>
		
	  <section id="abas">
	    <div class="centralizar-app">    
	      <a class="botao-aba" href="#app-sobre">Sobre</a>
		  <a class="botao-aba" href="#app-requisitos">Requisitos de Sistema</a>
		</div>
	  </section>
		
      <section id="app-sobre" class="mudar-aba">
		<div class="centralizar-app">
		  <article>
		    <header>
	          <h3>Sobre</h3>
		    </header>
		    <p><%=app.getSobreApp()%></p>
		  </article>
		</div>
	  </section>
		
      <section id="app-requisitos" class="mudar-aba">
        <div class="centralizar-app">
          <div class="app-requisito">
			<h3>Requisito Minimo</h3>
            OS: <%=app.getRequisitoMinimo().getSystemOS()%><br>
            Processador: <%=app.getRequisitoMinimo().getSystemProcessor()%><br>
            Memória: <%=app.getRequisitoMinimo().getSystemMemory()%><br>
            Placa de Vídeo: <%=app.getRequisitoMinimo().getSystemVideoCard()%><br>
            DirectX: <%=app.getRequisitoMinimo().getSystemDirectX()%><br>
            Armazenamento: <%=app.getRequisitoMinimo().getSystemHD()%><br>
	      </div>
		  <div class="app-requisito">
            <h3>Requisito Recomendado</h3>
            OS: <%=app.getRequisitoRecomendado().getSystemOS()%><br>
            Processador: <%=app.getRequisitoRecomendado().getSystemProcessor()%><br>
            Memória: <%=app.getRequisitoRecomendado().getSystemMemory()%><br>
            Placa de Vídeo: <%=app.getRequisitoRecomendado().getSystemVideoCard()%><br>
            DirectX: <%=app.getRequisitoRecomendado().getSystemDirectX()%><br>
            Armazenamento: <%=app.getRequisitoRecomendado().getSystemHD()%><br>
          </div>
		</div>
      </section>
    </main>
  </body>
</html>