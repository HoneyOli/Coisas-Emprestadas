package coisasemprestadas.daos;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coisasemprestadas.daos.ConnectionFactory;
import coisasemprestadas.models.Coisas;

public class CoisasDAO {
	private Connection connection;

	public CoisasDAO() {
		connection = ConnectionFactory.getConnection();
	}
	
	public boolean inserir(Coisas coisas) {

		String sql = "insert into coisas (usuario,nome, descricao) " + "values (?, ?, ?);";
	
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, coisas.getUsuario());
			stmt.setString(2, coisas.getNome());
			stmt.setString(3, coisas.getDescricao());
			
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	public  List<Coisas> getLista() {
		List<Coisas> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from coisas");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				Coisas coisas = new Coisas();
				coisas.setId(rs.getLong("id"));
				coisas.setUsuario(rs.getString("usuario"));
				coisas.setNome(rs.getString("nome"));
				coisas.setDescricao(rs.getString("descricao"));
				

				
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Coisas getCoisasById(long id) {
		Coisas coisas = new Coisas();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from coisas where id=?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				coisas.setId(rs.getLong("id"));
				coisas.setUsuario(rs.getString("usuario"));
				coisas.setNome(rs.getString("nome"));
				coisas.setDescricao(rs.getString("descricao"));
			
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return coisas;
	}
	public boolean atualisar (Coisas coisas) {
		String sql = "update coisas set usuario=?, nome=?, "
					+ "descricao=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, coisas.getUsuario());
			stmt.setString(2, coisas.getNome());
			stmt.setString(3, coisas.getDescricao());
			stmt.setLong(4, coisas.getId());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean remover(Coisas coisas) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from coisas where id=?");
			stmt.setLong(1, coisas.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public Coisas getCoisasByNome(String nome) {
		Coisas result = null;

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from coisas where nome = ?;");
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				result = new Coisas();
				result.setId(rs.getLong("id"));
				result.setUsuario(rs.getString("usuario"));
				result.setNome(rs.getString("nome"));
				result.setDescricao(rs.getString("descricao"));
				
				
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
}
}
