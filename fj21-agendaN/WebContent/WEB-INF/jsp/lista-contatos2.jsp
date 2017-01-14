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

	<c:import url="cabecalho2.jsp" />

<!-- cria o DAO -->
<jsp:useBean id="dao" class="br.com.caelum.jdbc.dao.ContatoDao" />

<table border="1" align="center">
	<!-- percorre contatos montando as linhas da tabela -->
	
	<tr align="center">
		<td><strong>Nome</strong></td>
		<td><strong> e-mail </strong> </td>
		<td><strong> Endereço </strong> </td>
		<td><strong> Data de Nascimento </strong> </td>
		
	</tr>
	
	<c:forEach var="contato" items="${dao.lista}" varStatus="id" >
		
		<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }">
			<td>${contato.nome}</td>
			<td>
<%-- 				<c:if test="${not empty contato.email}"> --%>
<%-- 					<a href="mailto:${contato.email}">${contato.email}</a> --%>
<%-- 				</c:if> --%>
				
<%-- 				<c:if test="${empty contato.email }"> --%>
<!-- 					E-mail não informado. -->
<%-- 				</c:if> --%>

				
				<c:choose>
					<c:when test="${not empty contato.email }">
						<a href="mailto:${contato.email }">${contato.email }</a>
					</c:when>
					<c:otherwise>
						<strong>E-mail não informado</strong>
					</c:otherwise>
				</c:choose>
				
			</td>
			<td>${contato.endereco } </td>
<%-- 			<td>${contato.dataNascimento.time } </td> --%>
			<td align="center"> <fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" /> </td>
		</tr>
		
	</c:forEach>


</table>

	<c:import url="rodape.jsp" />
	
</body>
</html>