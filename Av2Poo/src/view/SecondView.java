package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import bo.Entregador;
import bo.Restaurante;
import bo.Cliente;
import controller.EntregadorController;
import controller.RestauranteController;
import controller.ClienteController;
import jdbc.ConnectionFactory;
import net.proteanit.sql.DbUtils;

public class SecondView extends JFrame implements ActionListener {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textmat;
	private JTextField textnome;
	private JTextField textEndereco;
	private JTextField textEmail;
	private JTextField textTelefone;
	private JTextField textForma_De_Pagamento;
	private JTextField textcpfsecond;
	private JTextField textnomesecond;
	private JTextField texttelefone;
	private JTextField textplaca;
	private JTextField texthabilitacao;
	private JTextField textcodigo;
	private JTextField textendereco;
	private JTextField texttelefonesecond;
	private JTextField textnomethird;
	private JTextField textculinaria;
	private JTextField texttempo_restaurante;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecondView frame = new SecondView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SecondView() {
		Connection con = ConnectionFactory.getConnection();
		getContentPane().setBackground(new Color(255, 0, 0));
		getContentPane().setLayout(null);
		setSize(1050, 620);
		setLocation(500, 200);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 81, 394, 363);
		getContentPane().add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Cliente", null, panel, null);
		panel.setLayout(null);

		textnome = new JTextField();
		textnome.setBounds(184, 45, 180, 30);
		panel.add(textnome);
		textnome.setColumns(10);

		textEndereco = new JTextField();
		textEndereco.setBounds(184, 86, 180, 30);
		panel.add(textEndereco);
		textEndereco.setColumns(10);

		textTelefone = new JTextField();
		textTelefone.setBounds(184, 129, 180, 30);
		panel.add(textTelefone);
		textTelefone.setColumns(10);

		textEmail = new JTextField();
		textEmail.setBounds(184, 170, 180, 30);
		panel.add(textEmail);
		textEmail.setColumns(10);

		textForma_De_Pagamento = new JTextField();
		textForma_De_Pagamento.setBounds(184, 211, 180, 30);
		panel.add(textForma_De_Pagamento);
		textForma_De_Pagamento.setColumns(10);

		JButton btsend = new JButton("Enviar");
		btsend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente cliente = new Cliente();
				cliente.setNome(textnome.getText());
				cliente.setEndereco(textEndereco.getText());
				cliente.setTelefone(Integer.parseInt(textTelefone.getText()));
				cliente.setEmail(textEmail.getText());
				cliente.setForma_de_pagamento(textForma_De_Pagamento.getText());

				ClienteController clienteInsert = new ClienteController();
				clienteInsert.create(cliente);
			}
		});
		btsend.setBounds(298, 267, 66, 23);
		panel.add(btsend);

		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 50, 106, 14);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Endereço:");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 94, 67, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Telefone:");
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_2.setBounds(10, 135, 67, 14);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_3.setBounds(10, 176, 67, 14);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Forma de Pagamento:");
		lblNewLabel_4.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_4.setBounds(10, 217, 164, 24);
		panel.add(lblNewLabel_4);

		JButton btndelete = new JButton("Delete");
		btndelete.setBounds(184, 301, 76, 23);
		panel.add(btndelete);
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente();
				cliente.setNome(textnome.getText());

				ClienteController clienteDelete = new ClienteController();
				clienteDelete.delete(cliente);
			}
		});

		JButton btnupdate = new JButton("Update");
		btnupdate.setBounds(184, 267, 77, 23);
		panel.add(btnupdate);
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente();
				cliente.setNome(textnome.getText());
				cliente.setEndereco(textEndereco.getText());
				cliente.setTelefone(Integer.parseInt(textTelefone.getText()));
				cliente.setEmail(textEmail.getText());
				cliente.setForma_de_pagamento(textForma_De_Pagamento.getText());

				ClienteController clienteUpdate = new ClienteController();
				clienteUpdate.update(cliente);
			}
		});

		JButton btnselectcliente = new JButton("Select");
		btnselectcliente.addActionListener(this);
		btnselectcliente.setBounds(288, 301, 78, 23);
		panel.add(btnselectcliente);

		JPanel panelentregador = new JPanel();
		tabbedPane.addTab("Entregador", null, panelentregador, null);
		panelentregador.setLayout(null);

		textcpfsecond = new JTextField();
		textcpfsecond.setBounds(205, 45, 159, 30);
		panelentregador.add(textcpfsecond);
		textcpfsecond.setColumns(10);

		textnomesecond = new JTextField();
		textnomesecond.setBounds(205, 86, 159, 30);
		panelentregador.add(textnomesecond);
		textnomesecond.setColumns(10);

		texttelefone = new JTextField();
		texttelefone.setToolTipText("");
		texttelefone.setBounds(205, 127, 159, 30);
		panelentregador.add(texttelefone);
		texttelefone.setColumns(10);

		textplaca = new JTextField();
		textplaca.setBounds(205, 168, 159, 30);
		panelentregador.add(textplaca);
		textplaca.setColumns(10);

		texthabilitacao = new JTextField();
		texthabilitacao.setBounds(205, 214, 159, 30);
		panelentregador.add(texthabilitacao);
		texthabilitacao.setColumns(10);

		JButton btsend2 = new JButton("Enviar");
		btsend2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Entregador entregador = new Entregador();
				entregador.setCpf(Integer.parseInt(textcpfsecond.getText()));
				entregador.setNome(textnomesecond.getText());
				entregador.setTelefone(texttelefone.getText());
				entregador.setPlaca(textplaca.getText());
				entregador.setHabilitacao(texthabilitacao.getText());

				EntregadorController entregadorInsert = new EntregadorController();
				entregadorInsert.create(entregador);
			}
		});
		btsend2.setBounds(292, 264, 72, 23);
		panelentregador.add(btsend2);

		JLabel lblNewLabel_5 = new JLabel("CPF:");
		lblNewLabel_5.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_5.setBounds(10, 46, 89, 22);
		panelentregador.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Nome:");
		lblNewLabel_6.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_6.setBounds(10, 94, 89, 14);
		panelentregador.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Telefone:");
		lblNewLabel_7.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_7.setBounds(10, 135, 72, 14);
		panelentregador.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Placa:");
		lblNewLabel_8.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_8.setBounds(10, 176, 89, 14);
		panelentregador.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Habilitação:");
		lblNewLabel_9.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_9.setBounds(10, 222, 197, 14);
		panelentregador.add(lblNewLabel_9);

		JButton btnupdateentregador = new JButton("Update");
		btnupdateentregador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Entregador entregador = new Entregador();
				entregador.setCpf(Integer.parseInt(textcpfsecond.getText()));
				entregador.setNome(textnomesecond.getText());
				entregador.setTelefone(texttelefone.getText());
				entregador.setPlaca(textplaca.getText());
				entregador.setHabilitacao(texthabilitacao.getText());

				EntregadorController entregadorUpdate = new EntregadorController();
				entregadorUpdate.update(entregador);
			}
		});
		btnupdateentregador.setBounds(203, 264, 79, 23);
		panelentregador.add(btnupdateentregador);

		JButton btndeleteentregador = new JButton("Delete");
		btndeleteentregador.setBounds(205, 301, 77, 23);
		panelentregador.add(btndeleteentregador);

		btndeleteentregador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Entregador entregador = new Entregador();
				entregador.setCpf(Integer.parseInt(textcpfsecond.getText()));;
				// entregador.setNome(textculinaria.getText());

				EntregadorController entregadorDelete = new EntregadorController();
				entregadorDelete.delete(entregador);
			}
		});

		JButton btnselectentregador = new JButton("Select");
		btnselectentregador.setBounds(292, 301, 72, 23);
		panelentregador.add(btnselectentregador);

		JPanel panelrestaurante = new JPanel();
		tabbedPane.addTab("Restaurante", null, panelrestaurante, null);
		panelrestaurante.setLayout(null);

		textcodigo = new JTextField();
		textcodigo.setBounds(205, 21, 159, 30);
		panelrestaurante.add(textcodigo);
		textcodigo.setColumns(10);

		textendereco = new JTextField();
		textendereco.setBounds(205, 62, 159, 30);
		panelrestaurante.add(textendereco);
		textendereco.setColumns(10);

		texttelefonesecond = new JTextField();
		texttelefonesecond.setBounds(205, 103, 159, 30);
		panelrestaurante.add(texttelefonesecond);
		texttelefonesecond.setColumns(10);

		textnomethird = new JTextField();
		textnomethird.setBounds(205, 144, 159, 30);
		panelrestaurante.add(textnomethird);
		textnomethird.setColumns(10);

		textculinaria = new JTextField();
		textculinaria.setBounds(205, 185, 159, 30);
		panelrestaurante.add(textculinaria);
		textculinaria.setColumns(10);

		JButton btsend3 = new JButton("Enviar");
		btsend3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Restaurante restaurante = new Restaurante();
				restaurante.setCodigo(Integer.parseInt(textcodigo.getText()));
				restaurante.setEndereco(textendereco.getText());
				restaurante.setTelefone(texttelefonesecond.getText());
				restaurante.setNome(textnomethird.getText());//textnomethird
				restaurante.setCulinaria(textculinaria.getText());

				RestauranteController restauranteInsert = new RestauranteController();
				restauranteInsert.create(restaurante);
			}
		});
		btsend3.setBounds(292, 267, 72, 23);
		panelrestaurante.add(btsend3);

		JLabel lblNewLabel_10 = new JLabel("Codigo:");
		lblNewLabel_10.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_10.setBounds(10, 22, 159, 22);
		panelrestaurante.add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("Endereço:");
		lblNewLabel_11.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_11.setBounds(10, 63, 46, 22);
		panelrestaurante.add(lblNewLabel_11);

		JLabel lblNewLabel_12 = new JLabel("Telefone:");
		lblNewLabel_12.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_12.setBounds(10, 104, 98, 22);
		panelrestaurante.add(lblNewLabel_12);

		JLabel lblNewLabel_13 = new JLabel("Culinaria:");
		lblNewLabel_13.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_13.setBounds(10, 145, 89, 22);
		panelrestaurante.add(lblNewLabel_13);

		JLabel lblNewLabel_14 = new JLabel("Nome:");
		lblNewLabel_14.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_14.setBounds(10, 186, 159, 22);
		panelrestaurante.add(lblNewLabel_14);

		JButton btnupdaterestaurante = new JButton("Update");
		btnupdaterestaurante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Restaurante restaurante = new Restaurante();
				restaurante.setCodigo(Integer.parseInt(textcodigo.getText()));
				restaurante.setEndereco(textendereco.getText());
				restaurante.setTelefone(texttelefonesecond.getText());
				restaurante.setNome(textculinaria.getText());

				RestauranteController restauranteUpdate = new RestauranteController();
				restauranteUpdate.update(restaurante);
			}
		});
		btnupdaterestaurante.setBounds(205, 267, 78, 23);
		panelrestaurante.add(btnupdaterestaurante);

		JButton btndeleterestaurante = new JButton("Delete");
		btndeleterestaurante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Restaurante restaurante = new Restaurante();
				restaurante.setCodigo(Integer.parseInt(textcodigo.getText()));
				restaurante.setNome(textculinaria.getText());

				RestauranteController restauranteDelete = new RestauranteController();
				restauranteDelete.delete(restaurante);
			}
		});
		btndeleterestaurante.setBounds(205, 301, 78, 23);
		panelrestaurante.add(btndeleterestaurante);

		JButton btnselectrestaurante = new JButton("Select");
		btnselectrestaurante.setBounds(292, 301, 72, 23);
		panelrestaurante.add(btnselectrestaurante);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(479, 100, 536, 344);
		getContentPane().add(scrollPane);

		btnselectcliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "SELECT * FROM bancoprog.CLIENTE";
					PreparedStatement pst = con.prepareStatement(query);
					ResultSet result = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(result));

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnselectentregador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "SELECT * FROM bancoprog.ENTREGADOR";
					PreparedStatement pst = con.prepareStatement(query);
					ResultSet result = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(result));

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		btnselectrestaurante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "SELECT * FROM bancoprog.RESTAURANTE";
					PreparedStatement pst = con.prepareStatement(query);
					ResultSet result = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(result));

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		table = new JTable();
		scrollPane.setViewportView(table);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}