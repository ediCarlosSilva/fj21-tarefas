package br.com.caelum.tarefas.jdbc.teste;

import java.util.Calendar;

import javax.swing.JOptionPane;

import br.com.caelum.tarefas.jdbc.dao.TarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;

public class TestaInsere {

	public static void main(String[] args) {
		
		Tarefa tarefa = new Tarefa();
		
		tarefa.setDescricao(JOptionPane.showInputDialog("Digite a descri�ao."));
		
		// grave nessa conex�o !!!
		TarefaDao dao = new TarefaDao();
		
		// m�todo adiciona da classe TarefaDao
		
		dao.adiciona(tarefa);
		
		System.out.println("gravado!");
		
		
		
		
	}
	
}
