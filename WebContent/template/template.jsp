<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<html>
	<head>
		<%request.getSession().setAttribute("root", request.getContextPath());%>
		
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Sistema de produtos on-line</title>
		<link rel="stylesheet" type="text/css" href="${root}/css/style_campos.css" />
		<link rel="stylesheet" type="text/css" href="${root}/css/style_formulario.css" />
		<link rel="stylesheet" type="text/css" href="${root}/css/724329.css" />
		<link rel="stylesheet" type="text/css" href="${root}/css/style_botao.css" />
		<link rel="stylesheet" type="text/css" href="${root}/css/style_menu.css" />
		<script type="text/javascript" src="${root}/js/executar.js"></script>
	</head>
	<body>
    <div id="wrapper">
	        <div id="headerwrap">
	        <div id="header">
	            <!-- coloca o tiles que foi configurado -->
		            <tiles:insert name="banner" />
	        </div>
	        </div>
	        
	        <div id="navigationwrap">
		        <div id="navigation">
		        <!-- coloca o tiles que foi configurado -->
		            <tiles:insert name="menu" />
		        </div>
	        </div>
	        
	        <div id="contentwrap">
		        <div id="content">
		         <!-- coloca o tiles que foi configurado -->
		            <tiles:insert name="body" />
		        </div>
	        </div>
	        
	        <div id="footerwrap">
		        <div id="footer">
		             <!-- coloca o tiles que foi configurado -->
		            <tiles:insert name="footer" />
		        </div>
	        </div>
    </div>
</body>
</html>