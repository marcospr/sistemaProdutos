<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Produto</title>
<link href="${root}/css/style_campos.css" type="text/css">
<link href="${root}/css/style_formulario.css" type="text/css">
<style>
#linha_001{
	background:#D8980E;
}
</style>
</head>
<body>

	<!-- formulário -->
	<html:form styleId="form_produto" action="/restrito/produtoAction"  method="post" enctype="multipart/form-data">
		<!-- campo para chamar os metodos da action -->
		<html:hidden property="method" value="empty" />

		<div class="principal_formulario">
			<header class="titulo_formulario font_titulo_formulario">
				<div>
					<div class="font_titulo_formulario" style="float: left;">
						Produto</div>

					<div style="position: relative; margin-left: 97%">
						<a href="#"
							onclick="javascript:executar('form_produto','cancelarCadastro')">
							<img alt="Fechar" src="${root}/imagens/close_16_16.png">
						</a>
					</div>
				</div>
			</header>
			<!-- cabeçalho da janela -->

			<div id="linha_001" class="clear_both">
				<!-- determina o conjunto label+campo -->
				<div style="float: left;">
					<div>
						<label>Código:</label>
						<!-- name é o nome que foi dado ao formBean no struts-config -->
						<html:text name="produtoForm" property="produto.id"
							styleClass="campo_formulario_centralizado" style="width:100px;" />
					</div>
				</div>

				<div class="clear_both">
					<!-- determina o conjunto label+campo -->
					<div>
						<div>
						<label>Categoria:</label>
							<html:select name="produtoForm" property="produto.categoria.id" styleClass="campo_formulario" style="width: 170px;">
              <html:optionsCollection name="produtoForm" property="comboCategoria" label="label" value="value" />
           </html:select>
						</div>
					</div>

				</div>

			</div>

			<div>
				<!-- determina o conjunto label+campo -->
				<div id="linha_002" class="clear_both">
					<div>
						<label>Produto:</label>
						<!-- name é o nome que foi dado ao formBean no struts-config -->
						<html:text name="produtoForm" property="produto.nome"
							styleClass="campo_formulario_centralizado" style="width:250px;" />
					</div>

					<div>
						<label>Preço:</label>
						<!-- name é o nome que foi dado ao formBean no struts-config -->
						<html:text name="produtoForm" property="produto.preco"
							styleClass="campo_formulario_centralizado" style="width:250px;" />
					</div>
				</div>
				
				<div>
					<label>Data cadastro:</label>
					<!-- name é o nome que foi dado ao formBean no struts-config -->
					<html:text name="produtoForm" property="produto.dataCadastro"
						styleClass="campo_formulario_centralizado" style="width:250px;" />
				</div>
				
				<div>
					<label>Imagem:</label>
		<span class="btn btn-success fileinput-button"> 
         <i class="icon-plus icon-black"></i> 
         <html:file styleClass="campo_formulario" name="produtoForm" property="file" style="width: 443px;" onchange="javascript:executar('form_produto','upload');"/>
        </span>
				</div>
				
				<div>
				 <div><html:button styleId="btn_cadastrar" property="produtoForm" value="enviar" /></div>
				</div>
			</div>
			
			<div>
				 <div> <html:button styleClass="botao" property="produtoForm" value="Inserir" onclick="executar('form_produto','inserir')"  />
				   	   <html:button styleClass="botao" property="produtoForm" value="Alterar" onclick="executar('form_produto','alterar')"  />
				   		<html:button styleClass="botao" property="produtoForm" value="Buscar" onclick="executar('form_produto','buscar')"  />
				   		<html:button styleClass="botao" property="produtoForm" value="Excluir" onclick="executar('form_produto','excluir')"  />
				    </div>
				    
				    <div>
				     <html:button styleClass="botao" property="categoriaForm" value="Gerar relatório" onclick="executar('form_produto','gerarRelatorio')"  />
				    </div>
				</div>
		</div>
		<!-- campos janela -->
		
	</html:form>
</body>
</html>