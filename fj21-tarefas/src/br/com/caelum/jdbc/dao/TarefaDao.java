package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.*;
import br.com.caelum.tarefas.modelo.Tarefa;

public class TarefaDao {

	// a conexão com o banco de dados
	private Connection connection;

	public TarefaDao ( Connection connection ) {
		this.connection = connection;
	}
	
	
	public TarefaDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Tarefa tarefa) {

		String sql = "insert into tarefas " + "(descricao, finalizacao, dataFinalizacao)" + " values (?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setString(1, tarefa.getDescricao());
			stmt.setBoolean(2, tarefa.isFinalizado());
			stmt.setDate(3, new Date(tarefa.getDataFinalizacao().getTimeInMillis()));

			// executa
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<Tarefa> getLista() {

		try {

			List<Tarefa> tarefas = new ArrayList<Tarefa>();
			PreparedStatement stmt = this.connection.prepareStatement("Select * from tarefas");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				// criando o objeto contato
				Tarefa tarefa = new Tarefa();
				tarefa.setId(rs.getLong("id"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setFinalizado(rs.getBoolean("finalizacao"));
				
				// montando a data através do calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataFinalizacao"));
				tarefa.setDataFinalizacao(data);

				// adiciona o objeto à lista
				tarefas.add(tarefa);

			}
			rs.close();
			stmt.close();
			return tarefas;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void remove(Tarefa tarefa) {

		try {

			PreparedStatement stmt = connection.prepareStatement("delete from tarefas where id=?");

			stmt.setLong(1, tarefa.getId());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
public void altera ( Tarefa tarefa ) {
		
		String sql = "update tarefas set descricao = ?, finalizacao = ?, " +
		" dataFinalizacao = ? where id = ?";
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, tarefa.getDescricao());
			stmt.setBoolean(2, tarefa.isFinalizado());
			stmt.setDate(3, new Date(tarefa.getDataFinalizacao().getTimeInMillis()));
			stmt.setLong(4, tarefa.getId());
			stmt.execute();
			stmt.close();
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
