package model;

import bo.Missao;
import jdbc.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

public class MissaoDAO {
	public void create(Missao missao) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		String sql = "INSERT INTO MISSAO(CODIGO, COMPONENTE, TIPO, CLIENTE, RANKING, DATA_INICIO, DATA_FIM) VALUES (?, ?, ?, ?, ?, SYSDATE(), SYSDATE())";

		try {
			stmt = con.prepareStatement(sql); // instancia uma instrucao sql
			stmt.setInt(1, missao.getCodigo()); // primeiro parametro da query
			stmt.setString(2, missao.getComponente());
			stmt.setString(3, missao.getTipo());
			stmt.setString(4, missao.getCliente());
			stmt.setString(5, missao.getRanking());

			stmt.executeUpdate();
			System.out.println("[MissaoDAO] Missao cadastrada com sucesso");

		} catch (SQLException e) {
			System.out.println("Erro na tentativa de insercao: " + e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public void delete(Missao missao) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		String sql = "DELETE FROM db_system.MISSAO WHERE CODIGO = ?";

		try {
			stmt = con.prepareStatement(sql); // instancia uma instrucao sql
			stmt.setInt(1, missao.getCodigo()); // primeiro parametro da query

			stmt.executeUpdate();
			System.out.println("[MissaoDAO] Missao apagada");

		} catch (SQLException e) {
			System.out.println("Erro na tentativa de apagar: " + e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public void update(Missao missao) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		String sql = "UPDATE MISSAO SET CODIGO = ?, COMPONENTE = ?, TIPO = ?, CLIENTE = ?, RANKING = ? WHERE CODIGO = ? ";

		try {
			stmt = con.prepareStatement(sql); // instancia uma instrucao sql
			stmt.setInt(1, missao.getCodigo()); // primeiro parametro da query
			stmt.setString(2, missao.getComponente());
			stmt.setString(3, missao.getTipo());
			stmt.setString(4, missao.getCliente());
			stmt.setString(5, missao.getRanking());

			stmt.executeUpdate();
			System.out.println("[MissaoDAO] As informações do missao foram alteradas com sucesso!");

		} catch (SQLException e) {
			System.out.println("Erro ao tentar atualizar: " + e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public List<Missao> read() {
		List<Missao> listaMissao = new ArrayList<Missao>();

		// ler banco mysql e preencher lista de alunos
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM db_system.MISSAO";

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Missao missao = new Missao();
				missao.setCodigo(rs.getInt("CODIGO"));
				missao.setComponente(rs.getString("COMPONENTE"));
				missao.setTipo(rs.getString("TIPO"));
				missao.setCliente(rs.getString("CLIENTE"));
				missao.setRanking(rs.getString("RANKING"));

				listaMissao.add(missao);
			}

		} catch (SQLException e) {
			System.out.println("<DAO> Erro na base de dados: " + e);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}

		return listaMissao;
	}
}