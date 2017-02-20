<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Categoria</title>
</head>
<body>
	
	<!-- formulário -->
	<html:form styleId="form_categoria" action="/restrito/categoriaAction">
		<!-- campo para chamar os metodos da action -->
		<html:hidden property="method" value="empty"/>
		
		<div class="principal_formulario">
			<header class="titulo_formulario font_titulo_formulario">
				 <div>
			 		<div class="font_titulo_formulario" style="float: left;">
			 			Categoria
			 		</div>
			 		
			 		  <div style="position: relative; margin-left: 97%">
			 			<a href="#" onclick="javascript:executar('form_categoria','cancelarCadastro')"> 
			 			<img alt="Fechar" src="${root}/imagens/close_16_16.png">
			 			</a>
			 		 </div>
			 	</div>
			</header>
			<!-- CAMPOS JANELA -->
    	 <main class="conteudo_formulario">
			<!-- cabeçalho da janela -->
			
			<div id="linha_001" class="clear_both">
			<!-- determina o conjunto label+campo -->
				<div style="float: left;">
					<div>
						<label>Código:</label>
						<!-- name é o nome que foi dado ao formBean no struts-config -->
						<html:text name="categoriaForm" property="categoria.id" styleClass="campo_formulario_centralizado" style="width:100px;" />
					</div>
				</div>
				
				<!-- determina o conjunto label+campo -->
				<div>
					<div>
						<label>Categoria:</label>
						<!-- name é o nome que foi dado ao formBean no struts-config -->
						<html:text name="categoriaForm" property="categoria.nome" styleClass="campo_formulario_centralizado" style="width:200px;" />
					</div>
				</div>
			</div>
				<div>
				 <div> <html:button styleClass="botao" property="categogiaForm" value="Inserir" onclick="executar('form_categoria','inserir')"  />
				   	   <html:button styleClass="botao" property="categogiaForm" value="Alterar" onclick="executar('form_categoria','alterar')"  />
				   		<html:button styleClass="botao" property="categogiaForm" value="Buscar" onclick="executar('form_categoria','buscar')"  />
				   		<html:button styleClass="botao" property="categogiaForm" value="Excluir" onclick="executar('form_categoria','excluir')"  />
				    </div>
				    
				    <div>
				     <html:button styleClass="botao" property="categogiaForm" value="Gerar relatório" onclick="executar('form_categoria','gerarRelatorio')"  />
				    </div>
				</div>
				
			<!-- campos janela -->
			</main>
		</div>
		
	</html:form>
</body>
</html>