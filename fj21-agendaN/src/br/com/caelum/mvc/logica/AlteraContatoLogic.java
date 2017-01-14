package br.com.caelum.mvc.logica;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class AlteraContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		Contato contato = new Contato();
		long id = Long.parseLong(req.getParameter("id"));
		String nome;
		String email;
		String endereco;
		Calendar dataNascimento = null;
		
		List<Contato> contatos = new ContatoDao().getLista();
		
		for ( Contato c : contatos ) {
			
			if ( c.getId() == id ) {
				
				nome = c.getNome();
				endereco = c.getEndereco();
				email = c.getEmail();
				dataNascimento = c.getDataNascimento();
				
				contato.setId(id);
				contato.setNome(nome);
				contato.setEmail(email);
				contato.setEndereco(endereco);
				contato.setDataNascimento(dataNascimento);
			}
			
		}
		
		
//		String nome = req.getParameter("nome");
//		String email = req.getParameter("email");
//		String endereco = req.getParameter("endereco");
//		String dataEmTexto = req.getParameter("dataNascimento");
//		Calendar dataNascimento = null;
		
//		try {
//			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
//			dataNascimento = Calendar.getInstance();
//			dataNascimento.setTime(date);
//			
//		} catch ( java.text.ParseException e ) {
//			out.println("erro na conversão de data" + e);
//			return "mvc?logica=ListaContatosLogic"; // para a execução do método
//		}
		
		
		req.setAttribute("contato", contato);
		
		
		
		return "/WEB-INF/jsp/altera-contato.jsp";
	}
	
}
