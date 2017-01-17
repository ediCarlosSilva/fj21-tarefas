package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import javax.swing.JOptionPane;

import br.com.caelum.jdbc.dao.TarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;

public class TestaInsere {

	public static void main(String[] args) {
		
		Tarefa tarefa = new Tarefa();
		
		tarefa.setDescricao(JOptionPane.showInputDialog("Digite a descriçao."));
//		tarefa.setFinalizado(JOptionPane.showInputDialog("Digite o e-mail."));
		tarefa.setFinalizado(true);
		tarefa.setDataFinalizacao(Calendar.getInstance());
		
		// grave nessa conexão !!!
		TarefaDao dao = new TarefaDao();
		
		// método elegante
		
		dao.adiciona(tarefa);
		
		System.out.println("gravado!");
		
		
		
		
	}
	
}
