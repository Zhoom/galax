<%@page import="java.util.ArrayList"%>
<%@page import="modelo.dominio.App"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-BR">
  <head>
    <meta charset="UTF-8"/>
	<link href="main.css" rel="stylesheet" type="text/css"/>
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

    	// Mostra a aba atual, e adiciona a classe "active" ao botÃ£o que abriu a aba
    	document.getElementById(tabName).style.display = "block";
    	evt.currentTarget.className += " active";
	  }
    </script>
  </head>
  <jsp:useBean id="app" scope="request" class="modelo.dominio.App"></jsp:useBean>
  <body ng-app="">
    <jsp:include page="_login.jsp"/>
	<br>
	<span>Informações para registro de App</span>
	<br>
	<br>

	<form action="editarApp" method="post" class="form" id="pub-game-form">
	  <input type=hidden name="app-codigo" class="box-item-form" value="<%=app.getAppIDStr()%>" disabled>
	  <div class="basic-pub-game-info">
	    <div class="item-form">
		  <label for="app-nome" class="text-item-form">Nome:</label>
		  <input type=text name="app-nome" class="box-item-form" value="<%=app.getAppNome()%>" size="40" maxlength="100" required>
	    </div>

		<div class="item-form">
		  <label for="app-desenvolvedor" class="text-item-form">Desenvolvedor:</label>
		  <input type=text name="app-desenvolvedor" class="box-item-form" value="<%=app.getDesenvolvedor()%>" size="40" maxlength="100" required>
	    </div>

		<div class="item-form">
		  <label for="app-preco" class="text-item-form">Preço: $</label>
		  <input type=text name="app-preco" class="box-item-form" value="<%=app.getPrecoStr()%>" size="20" maxlength="20" required>
	    </div>

		<!--
        <div class="item-form">
          <label for="app-dataLancamento" class="text-item-form">Data prevista de lançamento:</label> 
          <input type=date id="app-dataLancamento" class="box-item-form" value="" required>
        </div> -->

	    <div class="item-form">
		  <label for="app-descricao" class="text-item-form">Descrição:</label>
		  <textarea name="app-descricao" class="box-item-form textarea-item-form" maxlength="250" required><%=app.getDescricao()%></textarea>
		</div>

		<div class="item-form">
		  <label for="app-sobre" class="text-item-form">Sobre:</label>
		  <textarea name="app-sobre" class="box-item-form textarea-item-form" required><%=app.getSobreApp()%></textarea>
		</div>
	  </div>
		
	  <div class="tab">
	    <button type="button" class="tablinks" onclick="openTab(event, 'req-min')">Requisito Mínimo</button>
		<button type="button" class="tablinks" onclick="openTab(event, 'req-recomend')">Requisito Recomendado</button>
	  </div>

	  <div id="req-min" class="tabcontent">
	  
	    <div class="item-form">
		  <label for="app-min-req-os" class="text-item-form">Sistema Operacional:</label>
		    <input type=text name="app-min-req-os" class="box-item-form" size="40" maxlength="100" value="fdg" ng-init='minOs="<%=app.getRequisitoMinimo().getSystemOS()%>"' ng-model="minOs" required>
		</div>

		<div class="item-form">
		  <label for="app-min-req-proc" class="text-item-form">Processador:</label>
		  <input type=text name="app-min-req-proc" class="box-item-form" size="40" maxlength="100" ng-init='minProcessor="<%=app.getRequisitoMinimo().getSystemProcessor()%>"' ng-model="minProcessor" required>
		</div>

		<div class="item-form">
		  <label for="app-min-req-mem" class="text-item-form">Memória:</label>
		  <input type=text name="app-min-req-mem" class="box-item-form" size="40" maxlength="100" ng-init='minMemory="<%=app.getRequisitoMinimo().getSystemMemory()%>"' ng-model="minMemory" required>
		</div>

		<div class="item-form">
		  <label for="app-min-req-vidc" class="text-item-form">Placa de Video:</label>
		  <input type=text name="app-min-req-vidc" class="box-item-form" size="40" maxlength="100" ng-init='minVideocard="<%=app.getRequisitoMinimo().getSystemVideoCard()%>"' ng-model="minVideocard" required>
		</div>

		<div class="item-form">
		  <label for="app-min-req-dicx" class="text-item-form">DirectX:</label>
		  <input type=text name="app-min-req-dicx" class="box-item-form" size="40" maxlength="100" ng-init='minDicx="<%=app.getRequisitoMinimo().getSystemDirectX()%>"' ng-model="minDicx" required>
		</div>

		<div class="item-form">
		  <label for="app-min-req-hd" class="text-item-form">Armazenamento:</label>
		  <input type=text name="app-min-req-hd" class="box-item-form" size="40" maxlength="100" ng-init='minHd="<%=app.getRequisitoMinimo().getSystemHD()%>"' ng-model="minHd" required>
		</div>
	  </div>
		
	  <div id="req-recomend" class="tabcontent">
	    <div class="item-form">
		  <label for="app-recomend-req-os" class="text-item-form">Sistema Operacional:</label>
		    <input type=text name="app-recomend-req-os" class="box-item-form" size="40" maxlength="100" ng-init='recomendOs="<%=app.getRequisitoRecomendado().getSystemOS()%>"' ng-model="recomendOs">
		</div>

		<div class="item-form">
		  <label for="app-recomend-req-proc" class="text-item-form">Processador:</label>
		  <input type=text name="app-recomend-req-proc" class="box-item-form" size="40" maxlength="100" ng-init='recomendProcessor="<%=app.getRequisitoRecomendado().getSystemProcessor()%>"' ng-model="recomendProcessor">
		</div>

		<div class="item-form">
		  <label for="app-recomend-req-mem" class="text-item-form">Memória:</label>
		  <input type=text name="app-recomend-req-mem" class="box-item-form" size="40" maxlength="100" ng-init='recomendMemory="<%=app.getRequisitoRecomendado().getSystemMemory()%>"' ng-model="recomendMemory">
		</div>

		<div class="item-form">
		  <label for="app-recomend-req-vidc" class="text-item-form">Placa de Video:</label>
		    <input type=text name="app-recomend-req-vidc" class="box-item-form" size="40" maxlength="100" ng-init='recomendVideocard="<%=app.getRequisitoRecomendado().getSystemVideoCard()%>"' ng-model="recomendVideocard">
		  </div>

		<div class="item-form">
		  <label for="app-recomend-req-dicx" class="text-item-form">DirectX:</label>
		  <input type=text name="app-recomend-req-dicx" class="box-item-form" size="40" maxlength="100" ng-init='recomendDicx="<%=app.getRequisitoRecomendado().getSystemDirectX()%>"' ng-model="recomendDicx">
		</div>

		<div class="item-form">
		  <label for="app-recomend-req-hd" class="text-item-form">Armazenamento:</label>
		  <input type=text name="app-recomend-req-hd" class="box-item-form" size="40" maxlength="100" ng-init='recomendHd="<%=app.getRequisitoRecomendado().getSystemHD()%>"' ng-model="recomendHd">
		</div>
	  </div>
	
	  <div class="game-requirements-prev">
	    <div class="requirements-prev">
		  <p>
		    OS: {{minOs}}<br>
		    Processador: {{minProcessor}}<br>
			Memória: {{minMemory}}<br>
			Placa de Video: {{minVideocard}}<br>
			DirectX: {{minDicx}}<br>
			Armazenamento: {{minHd}}
		  </p>
		</div>
		<div class="requirements-prev">
		  <p>
		    OS: {{recomendOs}}<br>
		    Processador: {{recomendProcessor}}<br>
			Memória: {{recomendMemory}}<br>
			Placa de Video: {{recomendVideocard}}<br>
			DirectX: {{recomendDicx}}<br>
			Armazenamento: {{recomendHd}}
		  </p>
		</div>
	  </div>
		
	  <div class="confirm">
	    <input type="submit" class="button" value="Salvar">
	    <input type="button" class="button" value="Cancelar" onclick="window.location='listarApp'">
	  </div>
	</form>
  </body>
</html>