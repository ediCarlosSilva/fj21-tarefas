package br.com.caelum.tarefas.jdbc.teste;

import java.text.SimpleDateFormat;
import java.util.List;

import br.com.caelum.tarefas.jdbc.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;

public class TestaLista {

	public static void main ( String[] args ) {
		
		JdbcTarefaDao dao = new JdbcTarefaDao();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Tarefa> tarefas = dao.lista();
		
		for ( Tarefa tarefa : tarefas ) {
			System.out.println("Descrição: " + tarefa.getDescricao());
			System.out.println("Finalizacao: " + tarefa.isFinalizado());
			System.out.println("Data Finalização: " + sdf.format(tarefa.getDataFinalizacao().getTime()) + "\n");
			
			
		}
		
		
	}
	
}
