package coisasemprestadas.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import coisasemprestadas.daos.ConnectionFactory;
import coisasemprestadas.models.Usuario;

public class UsuarioDAO {

	private Connection connection;

	public UsuarioDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean inserir(Usuario usuario) {

		String sql = "insert into usuario (nome, email, endereco, senha) values (?, ?, ?, ? );";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getEndereco());
			stmt.setString(4, usuario.getSenha());

		

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean atualisar(Usuario usuario) {

		String sql = "update usuario set nome=?, email=?, endereco=?, senha=?";
	
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getEndereco());
			stmt.setString(4, usuario.getSenha());
			
			stmt.setLong(6, usuario.getId());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}

		return true;
	}
	public List<Usuario> getLista() {
		List<Usuario> result = new ArrayList<>();

		try {
			PreparedStatement stmt = connection.prepareStatement("select * from usuario");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				Usuario usuario = new Usuario();
				usuario.setId(rs.getLong("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setEndereco(rs.getString("endereco"));
				usuario.setSenha(rs.getString("senha"));

				// adicionando o objeto � lista
				result.add(usuario);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	
	public Usuario getUsuarioById(long id) {
		Usuario usuario = new Usuario();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from usuario where id=?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				usuario.setId(rs.getLong("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setEndereco(rs.getString("endereco"));
				usuario.setSenha(rs.getString("senha"));
				
}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}

	public boolean alterar(Usuario usuario) {
		String sql = "update usuario set nome=?, email=?, endereco=?, senha=? where id=?;";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getEndereco());
			stmt.setString(4, usuario.getSenha());
			stmt.setLong(5, usuario.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	public boolean remover(Usuario usuario) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from usuario where id=?;");
			stmt.setLong(1, usuario.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public List<Usuario> getUsuario() {
		List<Usuario> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from usuario;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				Usuario usuario = new Usuario();
				usuario.setId(rs.getLong("id"));
				usuario.setEmail(rs.getString("nome"));
				usuario.setEndereco(rs.getString("endereco"));
				usuario.setSenha(rs.getString("senha"));
				
			
				result.add(usuario);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public Usuario getById(long l) {
		Usuario result = null;

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from usuario where id = ?;");
			stmt.setLong(1, l);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				// criando o objeto Usuario
				result = new Usuario();
				result.setId(rs.getLong("id"));
				result.setNome(rs.getString("nome"));
				result.setEmail(rs.getString("email"));
				result.setEndereco(rs.getString("endereco"));
				result.setSenha(rs.getString("senha"));

				
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	

}