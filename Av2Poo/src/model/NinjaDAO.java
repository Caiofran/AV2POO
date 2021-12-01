package model;

import bo.Ninja;
import jdbc.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NinjaDAO {
	public void create(Ninja ninja) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		String sql = "INSERT INTO NINJA(MATRICULA, NOME, IDADE, RANKING, TIPO_SANGUINEO) VALUES (?, ?, ?, ?, ?)";

		try {
			stmt = con.prepareStatement(sql); // instancia uma instrucao sql
			stmt.setInt(1, ninja.getMatricula()); // primeiro parametro da query
			stmt.setString(2, ninja.getNome());
			stmt.setInt(3, ninja.getIdade());
			stmt.setString(4, ninja.getRanking());
			stmt.setString(5, ninja.getTipoSanguineo());

			stmt.executeUpdate();
			System.out.println("[NinjaDAO] Ninja cadastrado com sucesso");

		} catch (SQLException e) {
			System.out.println("Erro ao tentar inserir informações: " + e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public void delete(Ninja ninja) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		String sql = "DELETE FROM db_system.NINJA WHERE MATRICULA = ?";

		try {
			stmt = con.prepareStatement(sql); // instancia uma instrucao sql
			stmt.setInt(1, ninja.getMatricula()); // primeiro parametro da query

			stmt.executeUpdate();
			System.out.println("[NinjaDAO] Ninja se tornou Renegado");

		} catch (SQLException e) {
			System.out.println("Erro na tentativa renegar Ninja: " + e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public void update(Ninja ninja) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		String sql = "UPDATE ALUNO SET MATRICULA = ?, NOME = ?, IDADE = ?, RANKING = ?, TIPO_SANGUINEO = ? WHERE MATRICULA = ? ";

		try {
			stmt = con.prepareStatement(sql); // instancia uma instrucao sql
			stmt.setInt(1, ninja.getMatricula()); // primeiro parametro da query
			stmt.setString(2, ninja.getNome());
			stmt.setInt(3, ninja.getIdade());
			stmt.setString(4, ninja.getRanking());
			stmt.setString(5, ninja.getTipoSanguineo());

			stmt.executeUpdate();
			System.out.println("[NinjaDAO] As informações do ninja foram alteradas com sucesso!");

		} catch (SQLException e) {
			System.out.println("Erro ao tentar atualizar: " + e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public List<Ninja> read() {
		List<Ninja> listaNinja = new ArrayList<Ninja>();

		// ler banco mysql e preencher lista de alunos
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT MATRICULA, NOME, IDADE, RANKING, TIPO_SANGUINEO FROM db_system.NINJA";

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Ninja ninja = new Ninja();
				ninja.setMatricula(rs.getInt("MATRICULA"));
				ninja.setNome(rs.getString("NOME"));
				ninja.setIdade(rs.getInt("IDADE"));
				ninja.setRanking(rs.getString("RANKING"));
				ninja.setTipoSanguineo(rs.getString("TIPO_SANGUINEO"));

				listaNinja.add(ninja);
			}

		} catch (SQLException e) {
			System.out.println("<DAO> Erro na base de dados: " + e);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}

		return listaNinja;
	}
}