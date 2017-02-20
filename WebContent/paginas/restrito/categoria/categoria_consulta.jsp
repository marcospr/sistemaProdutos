<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Categoria</title>
</head>
<body>

	<!-- formulário -->
	<html:form styleId="form_categoria" action="/restrito/categoriaAction">
		<!-- campo para chamar os metodos da action -->
		<html:hidden property="method" value="empty" />

		<div class="principal_formulario">
			<header class="titulo_formulario font_titulo_formulario">
				<div>
					<div class="font_titulo_formulario" style="float: left;">
						Categoria</div>

					<div style="position: relative; margin-left: 97%">
						<a href="#"
							onclick="javascript:executar('form_categoria','cancelarCadastro')">
							<img alt="Fechar" src="${root}/imagens/close_16_16.png">
						</a>
					</div>
				</div>
			</header>
			<!-- CAMPOS JANELA -->
			<main class="conteudo_formulario">
			<div id="desktop_linha01" class="clear_both">
				<!-- TABELA DE CONSULTA -->
				<div style="max-width: 98%; overflow: auto; width: 96%; clear: both;" class="boxCinza show floatNone">
					<display:table id="categoriaCorrente" name="requestScope.categoriaCorrente" requestURI="${root}/restrito/categoriaAction.src" partialList="true" pagesize="5" size="${tamanhoTotal}"
						sort="external">

						<display:column property="id" title="Código"
							headerClass="cinquenta" style="text-align:left;" />
						<display:column property="nome" title="Nome" headerClass="duzentosTrinta" style="text-align:left;" />
						<display:column title="Ação" headerClass="quarenta acao centralizada" style="text-align:center;">
							<a href="${root}/restrito/categoriaAction.src?method=selecionar&categoria.id=${categoriaCorrente.id}" title="Selecionar" style="margin: 0px;"> <img src="${root}/imagens/selecionar.png" />
							</a>
						</display:column>
					</display:table>
				</div>
			</div>
			<!-- campos janela -->
			 </main>
		</div>

	</html:form>
</body>
</html>