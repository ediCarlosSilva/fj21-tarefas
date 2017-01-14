<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ page import="java.util.*,
		br.com.caelum.jdbc.dao.*,
		br.com.caelum.jdbc.modelo.*,
		java.text.SimpleDateFormat"
 %>
 
 <table>
 	<%
 		ContatoDao dao = new ContatoDao();
 		List<Contato> contatos = dao.getLista();
 		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
 	%>
 	
 	<tr>
 			<td>Nome</td>
 			<td>E-mail</td>
 			<td>Endereco</td>
 			<td>Data de Nascimento</td>
 		</tr>
 		
 	<%
 		for ( Contato contato : contatos ) {
 	%>
 	
 		<tr>
 			<td><%=contato.getNome() %></td>
 			<td><%=contato.getEmail() %></td>
 			<td><%=contato.getEndereco() %></td>
			<% String dataFormatada = sdf.format(contato.getDataNascimento().getTime());  %>
 			<td><% out.println(dataFormatada); %></td>
 		</tr>
 	<%
 		}
 	%>
 	
 </table>
</body>
</html>