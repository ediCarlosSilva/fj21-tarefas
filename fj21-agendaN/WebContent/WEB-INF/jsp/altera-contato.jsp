<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/jquery-ui.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Contato</title>
</head>
<body>

<c:import url="/WEB-INF/jsp/cabecalho.jsp" />

	<h1>Alterra Contatos</h1>
	<hr />
	<form action="mvc?logica=AdicionaAlteraContatoLogic" method="POST">
		Id: <input type="text" name="id" value="${contato.id}" readonly="readonly" /><br />
		Nome: <input type="text" name="nome" value="${contato.nome}" /><br />
		E-mail: <input type="text" name="email" value="${contato.email}" /><br />
		Endereço: <input type="text" name="endereco" value="${contato.endereco }" /><br />
<!-- 		Data Nascimento:  -->
<!-- 			<input type="text" name="dataNascimento" /><br /> -->
		Data Nascimento: <caelum:campoData id="dataNascimento" /><br />
			
<!-- 		<input type="hidden" name="logica" value="GravaContatoLogic" />	 -->
		<input type="submit" value="Gravar" />
	</form>
	
	<c:import url="/WEB-INF/jsp/rodape.jsp" />

</body>
</html>