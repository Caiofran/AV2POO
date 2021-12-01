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

		String sql = "INSERT INTO ENTREGADOR( NOME, TELEFONE, CPF, PLACA, PLACA) VALUES (?, ?, ?, ?, ?)";

		try {
			stmt = con.prepareStatement(sql); // instancia uma instrucao sql
			stmt.setString(1, entregador.getNome()); // primeiro parametro da query
			stmt.setInt(2, entregador.getTelefone());
			stmt.setInt(3, entregador.getCpf());
			stmt.setString(4, entregador.getPlaca());
			stmt.setInt(5, entregador.getHabilitacao());

			stmt.executeUpdate();
			System.out.println("[EntregadorDAO] Entregador cadastrada com sucesso");

		} catch (SQLException e) {
			System.out.println("Erro na tentativa de insercao: " + e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public void delete(Entregador Habilidades) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		String sql = "DELETE FROM db_system.HABILIDADES WHERE CODIGO = ?";

		try {
			stmt = con.prepareStatement(sql); // instancia uma instrucao sql
			stmt.setInt(1, Habilidades.getCodigo()); // primeiro parametro da query

			stmt.executeUpdate();
			System.out.println("[HabilidadesDAO] Ninja se tornou Renegado");

		} catch (SQLException e) {
			System.out.println("Erro na tentativa renegar Ninja: " + e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public void update(Habilidades Habilidades) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		String sql = "UPDATE HABILIDADES SET NOME = ?, PODER = ?, RANKING_HABILIDADE = ?, CONSUMO_CHACKRA = ? WHERE CODIGO = ? ";

		try {
			stmt = con.prepareStatement(sql); // instancia uma instrucao sql
			stmt.setString(1, Habilidades.getNome());
			stmt.setInt(2, Habilidades.getPoder());
			stmt.setString(3, Habilidades.getRankingHabilidade());
			stmt.setInt(4, Habilidades.getConsumoChackra());
			stmt.setInt(5, Habilidades.getCodigo());

			stmt.executeUpdate();
			System.out.println("[HabilidadesDAO] As informações da Habilidades foram alteradas com sucesso!");

		} catch (SQLException e) {
			System.out.println("Erro ao tentar atualizar: " + e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public List<Habilidades> read() {
		List<Habilidades> listaHabilidades = new ArrayList<Habilidades>();

		// ler banco mysql e preencher lista de alunos
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM db_system.HABILIDADES";

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Habilidades habilidades = new Habilidades();
				habilidades.setCodigo(rs.getInt("CODIGO"));
				habilidades.setNome(rs.getString("COMPONENTE"));
				habilidades.setPoder(rs.getInt("CLIENTE"));
				habilidades.setRankingHabilidade(rs.getString("RANKING"));
				habilidades.setConsumoChackra(rs.getInt("DATA_INICIO"));

				listaHabilidades.add(habilidades);
			}

		} catch (SQLException e) {
			System.out.println("<DAO> Erro na base de dados: " + e);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}

		return listaHabilidades;
	}
}
