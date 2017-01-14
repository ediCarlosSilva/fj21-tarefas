package br.com.caelum.mvc.logica;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class GravaContatoLogic implements Logica {

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
		
//		long id = Long.parseLong(req.getParameter("id"));
		String nome;
		String email;
		String endereco;
		String dataEmTexto;
		Calendar dataNascimento = null;
			
				nome = req.getParameter("nome");
				endereco = req.getParameter("endereco");
				email = req.getParameter("email");
				dataEmTexto = req.getParameter("dataNascimento");
				
				try {
					Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
					dataNascimento = Calendar.getInstance();
					dataNascimento.setTime(date);
						
				} catch ( java.text.ParseException e ) {
					out.println("erro na conversão de data" + e);
					return "mvc?logica=ListaContatosLogic"; // para a execução do método
						}
				
				contato.setId(idNumero);
				contato.setNome(nome);
				contato.setEmail(email);
				contato.setEndereco(endereco);
				contato.setDataNascimento(dataNascimento);
				
				dao.altera(contato);

return"mvc?logica=ListaContatosLogic";}

}
