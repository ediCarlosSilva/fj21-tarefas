package br.com.caelum.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class RemoveContatoLogic implements Logica {

	public String executa( HttpServletRequest req,
			HttpServletResponse res ) throws Exception {
		
		long id = Long.parseLong(req.getParameter("id"));
		
		Contato contato = new Contato();
		contato.setId(id);
		
//		ContatoDao dao = new ContatoDao();
		
		// busca a requisção pendurada na requisição
		Connection connection = (Connection) req.getAttribute("conexao");
		
		// passando a conexão no construtor
		ContatoDao dao = new ContatoDao(connection);
		
		dao.remove(contato);
		
		System.out.println("Excluindo contato...");
		
		
		return "mvc?logica=ListaContatosLogic";
	}
	
}
