package model;

import bo.Restaurante;
import jdbc.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

public class RestauranteDAO {
	public void create(Restaurante restaurante) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		String sql = "INSERT INTO RESTAURANTE(CODIGO, NOME, ENDERECO, TELEFONE, CULINARIA) VALUES (?, ?, ?, ?, ?)";

		try {
			stmt = con.prepareStatement(sql); // instancia uma instrucao sql
			stmt.setInt(1, restaurante.getCodigo()); // primeiro parametro da query
			stmt.setString(2, restaurante.getNome());
			stmt.setString(3, restaurante.getEndereco());
			stmt.setString(4, restaurante.getTelefone());
			stmt.setString(5, restaurante.getCulinaria());

			stmt.executeUpdate();
			System.out.println("[RestauranteDAO] Restaurante cadastrado com sucesso");

		} catch (SQLException e) {
			System.out.println("Erro na tentativa de insercao: " + e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public void delete(Restaurante restaurante) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		String sql = "DELETE FROM bancoprog.RESTAURANTE WHERE CODIGO = ?";

		try {
			stmt = con.prepareStatement(sql); // instancia uma instrucao sql
			stmt.setInt(1, restaurante.getCodigo()); // primeiro parametro da query

			stmt.executeUpdate();
			System.out.println("[RestauranteDAO] Restaurante apagado");

		} catch (SQLException e) {
			System.out.println("Erro na tentativa de apagar: " + e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public void update(Restaurante restaurante) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		String sql = "UPDATE RESTAURANTE SET NOME = ?, ENDERECO = ?, TELEFONE = ?, CULINARIA = ? WHERE CODIGO = ?";

		try {
			stmt = con.prepareStatement(sql); // instancia uma instrucao sql
			stmt.setString(1, restaurante.getNome());// primeiro parametro da query
			stmt.setString(2, restaurante.getEndereco());
			stmt.setString(3, restaurante.getTelefone());
			stmt.setString(4, restaurante.getCulinaria());
			stmt.setInt(5, restaurante.getCodigo());

			stmt.executeUpdate();
			System.out.println("[RestauranteDAO] As informações do restaurante foram alteradas com sucesso!");

		} catch (SQLException e) {
			System.out.println("Erro ao tentar atualizar: " + e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public List<Restaurante> read() {
		List<Restaurante> listaRestaurante = new ArrayList<Restaurante>();

		// ler banco mysql e preencher lista de alunos
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM bancoprog.RESTAURANTE";

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Restaurante restaurante = new Restaurante();
				restaurante.setCodigo(rs.getInt("CODIGO"));
				restaurante.setNome(rs.getString("NOME"));
				restaurante.setEndereco(rs.getString("ENDERECO"));
				restaurante.setTelefone(rs.getString("TELEFONE"));
				restaurante.setCulinaria(rs.getString("CULINARIA"));

				listaRestaurante.add(restaurante);
			}

		} catch (SQLException e) {
			System.out.println("<DAO> Erro na base de dados: " + e);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}

		return listaRestaurante;
	}
}