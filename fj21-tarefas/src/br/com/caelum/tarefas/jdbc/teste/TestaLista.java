package br.com.caelum.tarefas.jdbc.teste;

import java.text.SimpleDateFormat;
import java.util.List;

import br.com.caelum.tarefas.jdbc.dao.TarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;

public class TestaLista {

	public static void main ( String[] args ) {
		
		TarefaDao dao = new TarefaDao();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Tarefa> tarefas = dao.getLista();
		
		for ( Tarefa tarefa : tarefas ) {
			System.out.println("Descri��o: " + tarefa.getDescricao());
			System.out.println("Finalizacao: " + tarefa.isFinalizado());
			System.out.println("Data Finaliza��o: " + sdf.format(tarefa.getDataFinalizacao().getTime()) + "\n");
			
			
		}
		
		
	}
	
}
