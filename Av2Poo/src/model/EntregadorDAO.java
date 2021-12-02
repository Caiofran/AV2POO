package model;

import bo.Entregador;
import jdbc.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

public class EntregadorDAO {
	public void create(Entregador entregador) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		String sql = "INSERT INTO ENTREGADOR( CPF, NOME, TELEFONE,  PLACA, HABILITACAO) VALUES (?, ?, ?, ?, ?)";

		try {
			stmt = con.prepareStatement(sql); // instancia uma instrucao sql
			stmt.setInt(1, entregador.getCpf()); // primeiro parametro da query
			stmt.setString(2, entregador.getNome());
			stmt.setString(3, entregador.getTelefone());
			stmt.setString(4, entregador.getPlaca());
			stmt.setString(5, entregador.getHabilitacao());

			stmt.executeUpdate();
			System.out.println("[EntregadorDAO] Entregador cadastrada com sucesso");

		} catch (SQLException e) {
			System.out.println("Erro na tentativa de insercao: " + e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public void delete(Entregador Entregador) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		String sql = "DELETE FROM db_system.ENTREGADOR WHERE CPF = ?";

		try {
			stmt = con.prepareStatement(sql); // instancia uma instrucao sql
			stmt.setInt(3, Entregador.getCpf()); // primeiro parametro da query

			stmt.executeUpdate();
			System.out.println("[EntregadorDAO] Entregador foi embora");

		} catch (SQLException e) {
			System.out.println("Erro na tentativa entregador ir: " + e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public void update(Entregador Entregador) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		String sql = "UPDATE ENTREGADOR SET NOME = ?, TELEFONE = ?, HABILITACAO = ?, PLACA = ? WHERE CPF = ? ";

		try {
			stmt = con.prepareStatement(sql); // instancia uma instrucao sql
			stmt.setInt(1, Entregador.getCpf()); 
			stmt.setString(2, Entregador.getNome());
			stmt.setString(3, Entregador.getTelefone());
			stmt.setString(4, Entregador.getPlaca());
			stmt.setString(5, Entregador.getHabilitacao());
			stmt.executeUpdate();
			
			System.out.println("[EntregadorDAO] As informações do Entregador foram alteradas com sucesso!");

		} catch (SQLException e) {
			System.out.println("Erro ao tentar atualizar: " + e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public List<Entregador> read() {
		List<Entregador> listaEntregador = new ArrayList<Entregador>();

		// ler banco mysql e preencher lista de alunos
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM db_system.ENTREGADOR";

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Entregador entregador = new Entregador();
				entregador.setCpf(rs.getInt("CPF"));
				entregador.setNome(rs.getString("NOME"));
				entregador.setTelefone(rs.getString("TELEFONE"));
				entregador.setPlaca(rs.getString("PLACA"));
				entregador.setHabilitacao(rs.getString("HABILITACAO"));

				listaEntregador.add(entregador);
			}

		} catch (SQLException e) {
			System.out.println("<DAO> Erro na base de dados: " + e);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}

		return listaEntregador;
	}
}
