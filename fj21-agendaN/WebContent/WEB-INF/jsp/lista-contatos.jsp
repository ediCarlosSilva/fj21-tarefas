<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<c:import url="cabecalho.jsp" />
	

	
	<!--  cria o DAO -->
<%-- 	<jsp:useBean id="dao" class="br.com.caelum.jdbc.dao.ContatoDao" /> --%>
	
	<table border = "1" align="center">
		
		<tr>
			<td><strong>Id</strong></td>
			<td><strong>Nome</strong></td>
			<td><strong>E-mail</strong></td>
			<td><strong>Endereço</strong></td>
			<td><strong>data de Nascimento</strong></td>
			
		</tr>
		<!--  percorre contatos montando as linhas da tabela -->
<%-- 		<c:forEach var="contato" items="${dao.lista}" varStatus="id"> --%>
		<c:forEach var="contato" items="${contatos}" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }">
				<td>${id.count}</td>
				<td>${contato.nome}</td>
				
				<td>
<%-- 					<c:if test="${not empty contato.email}"> --%>
<%-- 					<a href="mailto:${contato.email}">${contato.email}</a> --%>
<%-- 					</c:if> --%>
					
<%-- 					<c:if test="${empty contato.email }"> --%>
<!-- 						E-mail não informado -->
<%-- 					</c:if> --%>
					
					<c:choose>
						<c:when test="${not empty contato.email}">
							<a href="mailto:${contato.email}">${contato.email}</a>
						</c:when>
						<c:otherwise>
							E-mail não informado
						</c:otherwise>
					
					</c:choose>
				</td>
				
				<td>${contato.endereco}</td>
<%-- 				<td>${contato.dataNascimento.time}</td> --%>
				<td>
					<fmt:formatDate value="${contato.dataNascimento.time}"
					pattern="dd/MM/yyyy" />
				</td>
				
				<td>
					<a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a>
				</td>
				
				<td>
					<a href="mvc?logica=AlteraContatoLogic&id=${contato.id }">Alterar</a>
				</td>
				
			</tr>
		</c:forEach>
		

	</table>

			<a href="mvc?logica=AdicionaFormularioLogic">Adicionar Contato</a><br />
	
	<c:import url="rodape.jsp" />
	
</body>
</html>