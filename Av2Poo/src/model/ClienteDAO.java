package model;

import bo.Cliente;
import jdbc.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
	public void create(Cliente cliente) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		String sql = "INSERT INTO CLIENTE(NOME, ENDERECO, TELEFONE, EMAIL, FORMA_DE_PAGAMENTO) VALUES (?, ?, ?, ?, ?)";

		try {
			stmt = con.prepareStatement(sql); // instancia uma instrucao sql
			stmt.setString(1, cliente.getNome()); // primeiro parametro da query
			stmt.setString(2, cliente.getEndereco());
			stmt.setInt(3, cliente.getTelefone());
			stmt.setString(4, cliente.getEmail());
			stmt.setString(5, cliente.getForma_de_pagamento());

			stmt.executeUpdate();
			System.out.println("[ClienteDAO] Cliente cadastrado com sucesso");

		} catch (SQLException e) {
			System.out.println("Erro ao tentar inserir informações: " + e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public void delete(Cliente cliente) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		String sql = "DELETE FROM bancoprog.CLIENTE WHERE NOME = ?";

		try {
			stmt = con.prepareStatement(sql); // instancia uma instrucao sql
			stmt.setString(1, cliente.getNome()); // primeiro parametro da query

			stmt.executeUpdate();
			System.out.println("[ClienteDAO] Cliente deletado");

		} catch (SQLException e) {
			System.out.println("Erro na tentativa renegar Cliente: " + e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public void update(Cliente cliente) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		String sql = "UPDATE CLIENTE SET ENDERECO = ?, TELEFONE = ?, EMAIL = ?, FORMA_DE_PAGAMENTO = ? WHERE NOME = ? ";

		try {
			stmt = con.prepareStatement(sql); // instancia uma instrucao sql
			stmt.setString(1, cliente.getNome()); // primeiro parametro da query
			stmt.setString(2, cliente.getEndereco());
			stmt.setInt(3, cliente.getTelefone());
			stmt.setString(4, cliente.getEmail());
			stmt.setString(5, cliente.getForma_de_pagamento());

			stmt.executeUpdate();
			System.out.println("[ClienteDAO] As informações do cliente foram alteradas com sucesso!");

		} catch (SQLException e) {
			System.out.println("Erro ao tentar atualizar: " + e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public List<Cliente> read() {
		List<Cliente> listaClientes = new ArrayList<Cliente>();

		// ler banco mysql e preencher lista
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		//NOME, ENDERECO, TELEFONE, EMAIL, FORMA_DE_PAGAMENTO
		String sql = "SELECT * FROM bancoprog.CLIENTE";

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setNome(rs.getString("NOME"));
				cliente.setEndereco(rs.getString("ENDERECO"));
				cliente.setTelefone(rs.getInt("TELEFONE"));
				cliente.setEmail(rs.getString("EMAIL"));
				cliente.setForma_de_pagamento(rs.getString("FORMA_DE_PAGAMENTO"));

				listaClientes.add(cliente);
			}

		} catch (SQLException e) {
			System.out.println("<DAO> Erro na base de dados: " + e);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}

		return listaClientes;
	}
}