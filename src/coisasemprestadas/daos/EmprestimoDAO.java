package coisasemprestadas.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;

import coisasemprestadas.daos.ConnectionFactory;
import coisasemprestadas.models.Coisas;
import coisasemprestadas.models.Emprestimo;
import coisasemprestadas.models.Usuario;




public class EmprestimoDAO {
	private Connection connection;

	public EmprestimoDAO() {
		connection = ConnectionFactory.getConnection();
	}
	public boolean inserir(Emprestimo emprestimo) {

		String sql = "insert into emprestimo (dataEmp, dataDev, usuario, coisas) " + "values (?, ?, ?, ?);";
	
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			Calendar dataEmprestimo = Calendar.getInstance();
			stmt.setDate(1, new java.sql.Date(dataEmprestimo.getTimeInMillis()));
			stmt.setDate(2, null);
			stmt.setFloat(3, emprestimo.getUsuario().getId());
			stmt.setString(4, emprestimo.getCoisas());
			
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
public boolean QuantidadeEmprestimos(Usuario usuario) {
		
		String sql =  "select * from emprestimo where usuario = ? and dataDev IS NULL;";
		int cont = 0;
		
		try {
			PreparedStatement stmt = connection
					.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			
			cont++;
		}
		
		if (cont >= 3) {
			return false;
		}
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
	}

	return true;

}


public List<Emprestimo> getAcessiveis() {
	List<Emprestimo> emprestimo = new ArrayList<Emprestimo>();
		
		try {
			
		PreparedStatement stmt = this.connection.prepareStatement("select * from emprestimo;");
		ResultSet rs = stmt.executeQuery();

		

		while (rs.next()) {
			Emprestimo emprestim = new Emprestimo();
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("dataEmp"));
			emprestim.setDataEmp(data);
			Usuario usuario = new UsuarioDAO().getById(rs.getLong("usuarioID"));
			Coisas coisas = new CoisasDAO().getCoisasById(rs.getLong("coisasID"));
			emprestim.setUsuario(usuario);
			

			emprestimo.add(emprestim);
		}
		rs.close();

		stmt.close();
	
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return emprestimo;
}


public List<Emprestimo> getAtrasados() {

		List<Emprestimo> emprestimo = new ArrayList<Emprestimo>();

		try {
			
		PreparedStatement stmt = this.connection
				.prepareStatement("select * from emprestimo where dataDev is null and dataEmp < ?;");
		

		Calendar dataEmp = Calendar.getInstance();
		stmt.setDate(1, new Date(dataEmp.getTimeInMillis()-14 * 24 * 60 * 60 * 1000));
		ResultSet rs = stmt.executeQuery();
		
	 while (rs.next()){
		 Emprestimo emprestimo1 = new Emprestimo();
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("dataEmp"));
			emprestimo1.setDataEmp(data);
			Usuario usuario = new UsuarioDAO().getById(rs.getLong("usuario"));
			emprestimo1.setUsuario(usuario);
		
			emprestimo.add(emprestimo1);
	 
	 }

		rs.close();
		stmt.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return emprestimo;
}


	public List<Emprestimo> getLista() {
		List<Emprestimo> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from emprestimo");
			ResultSet rs = stmt.executeQuery();
			Emprestimo emprestimo;
			while (rs.next()) {
				
				emprestimo = new Emprestimo();
				emprestimo.setId(rs.getLong("id"));
				emprestimo.setUsuario(new UsuarioDAO().getById(rs.getLong("usuario")));
				Calendar dataEmprestimo = Calendar.getInstance();
				dataEmprestimo.setTime(rs.getDate("dataEmp"));
				emprestimo.setDataEmp(dataEmprestimo);
				
				if(rs.getDate("dataDev") != null) {
					Calendar dataDevolucao = Calendar.getInstance();
					dataDevolucao.setTime(rs.getDate("dataDev"));
					emprestimo.setDataDev(dataDevolucao);
				}
				
				result.add(emprestimo);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public List<Emprestimo> getListaByUsuario(Usuario usuario) {
		List<Emprestimo> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from emprestimo where usuario=?");
			stmt.setLong(1, usuario.getId());
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				Emprestimo emprestimo = new Emprestimo();
				
				
				
				
				result.add(emprestimo);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean removerByUsuario(Usuario usuario) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from emprestimo where usuario=?");
			
			stmt.setLong(1, usuario.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean devolucao(Emprestimo emprestimo) {
		String sql = "update emprestimo set dataDev=? where id = ?;";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			Calendar dataDevolucao = Calendar.getInstance();
			stmt.setDate(1,  new java.sql.Date(dataDevolucao.getTimeInMillis()));
			stmt.setLong(2, emprestimo.getId());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public Emprestimo getEmprestimoByID(Long id) {
		try {

			Emprestimo emprestimo = null;
			PreparedStatement stmt = this.connection.prepareStatement("select * from emprestimo where id=?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				emprestimo = formacaoEmprestimo(rs);
			}
			rs.close();
			stmt.close();
			return emprestimo;
		} catch (SQLException e) {
			throw new RuntimeException(e);

		}
	}
	private Emprestimo formacaoEmprestimo(ResultSet rs) throws SQLException {
		Emprestimo emprestimo = new Emprestimo();

		Usuario usuario = new UsuarioDAO().getById(rs.getLong("Usuario"));
		emprestimo.setUsuario(usuario);
		

		Calendar data = Calendar.getInstance();
		data.setTime(rs.getDate("dataEmp"));
		emprestimo.setDataEmp(data);
		

		if (rs.getDate("dataDev") != null) {
			data.setTime(rs.getDate("dataDev"));
			emprestimo.setDataDev(data);
		}else {
			emprestimo.setDataDev(null);
		}

		return emprestimo;
		    }

}