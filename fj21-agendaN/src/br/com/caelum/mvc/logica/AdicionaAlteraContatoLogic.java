package br.com.caelum.mvc.logica;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class AdicionaAlteraContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
	
		PrintWriter out = res.getWriter();
		
		Contato contato = new Contato();
		ContatoDao dao = new ContatoDao();
		
		Long idNumero = null;
		String id = req.getParameter("id");
		if(id != null){
		idNumero = Long.parseLong(id);
		}
		
		String nome = req.getParameter("nome");
		String endereco = req.getParameter("endereco");
		String email = req.getParameter("email");
		String dataEmTexto = req.getParameter("dataNascimento");
		Calendar dataNascimento = null;
		
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
				
		} catch ( java.text.ParseException e ) {
			out.println("erro na conversão de data" + e);
			return "mvc?logica=ListaContatosLogic"; // para a execução do método
				}
		
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(dataNascimento);
		
		if ( id != null) {
			contato.setId(idNumero);
			dao.altera(contato);
		} else {
			dao.adiciona(contato);
		}
		
		return "mvc?logica=ListaContatosLogic";
	}
	
}
