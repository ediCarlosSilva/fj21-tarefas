<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="resources/css/jquery.css" rel="stylesheet">
<script src="resources/js/jquery.js"></script>
<script src="resources/js/jquery-ui.js"></script>
<!-- <link type="text/css" href="resources/css/tarefas.css" rel="stylesheet"> -->
</head>
<body>

	<h3>Alterar tarefa - ${tarefa.id }</h3>
	<form action="alteraTarefa" method="post">
		
		<input type="hidden" name="id" value="${tarefa.id }" />
		
		Descrição: <br />
		<textarea name="descricao" cols="100" rows="5">
			${tarefa.descricao}
		</textarea>
		<br />
		
		Finalizado? <input type="checkbox" name="finalizado" 
			value="true" ${tarefa.finalizado ? 'checked' : '' }/> <br />
		
		<fmt:formatDate value="${tarefa.dataFinalizacao.time}" 
		pattern="dd/MM/yyyy" var="data" />
		Data de finalizacao: <caelum:campoData id="dataFinalizacao" value="${data }" /> 
		
		<br />
		
		<input type="submit" value="Alterar">
		
	</form>

</body>
</html>