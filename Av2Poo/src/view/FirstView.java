package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import java.awt.Panel;
import javax.swing.ImageIcon;
import javax.swing.JSplitPane;
import java.awt.Label;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;

public class FirstView {

	private JFrame frame;
	private JTextField textusuario;
	private JPasswordField textpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstView window = new FirstView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FirstView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 0, 0));
		frame.setBounds( 100, 100, 490, 486);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setSize(500, 500);

		textusuario = new JTextField();
		textusuario.setBounds(267, 216, 166, 28);
		frame.getContentPane().add(textusuario);
		textusuario.setColumns(10);

		JButton btlogin = new JButton("Log In");
		btlogin.setForeground(new Color(255, 255, 255));
		btlogin.setBackground(SystemColor.desktop);
		btlogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		btlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// adicionar acao do botao
				if (checklogin(textusuario.getText(), new String(textpass.getPassword()))) {

					JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
					// cria objeto
					SecondView second = new SecondView();
					second.setVisible(true);
					frame.dispose();
				} else {

					JOptionPane.showMessageDialog(null, "Login não autorizado!");
				}

			}
		});
		btlogin.setBounds(267, 359, 112, 37);
		frame.getContentPane().add(btlogin);

		JLabel lblNewLabel = new JLabel("Usu\u00E1rio:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(267, 201, 89, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Senha:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(267, 277, 69, 23);
		frame.getContentPane().add(lblNewLabel_1);

		textpass = new JPasswordField();
		textpass.setBounds(267, 301, 166, 28);
		frame.getContentPane().add(textpass);

	}

	public boolean checklogin(String login, String senha) {
		return login.equals("admin") && senha.equals("admin");
	}
}