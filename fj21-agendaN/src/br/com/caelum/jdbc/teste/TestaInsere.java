package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import javax.swing.JOptionPane;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaInsere {

	public static void main(String[] args) {
		
		Contato contato = new Contato();
		
		contato.setNome(JOptionPane.showInputDialog("Digite o nome."));
		contato.setEmail(JOptionPane.showInputDialog("Digite o e-mail."));
		contato.setEndereco(JOptionPane.showInputDialog("Digite o endere�o."));
		contato.setDataNascimento(Calendar.getInstance());
		
		// grave nessa conex�o !!!
		ContatoDao dao = new ContatoDao();
		
		// m�todo elegante
		
		dao.adiciona(contato);
		
		System.out.println("gravado!");
		
		
		
		
	}
	
}
