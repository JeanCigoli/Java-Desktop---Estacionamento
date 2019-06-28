package br.senai.sp.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.senai.sp.dao.UsuarioDAO;
import br.senai.sp.model.Estacionamento;
import br.senai.sp.model.Usuario;
import br.senai.sp.util.Data;

public class FrmLogin extends JFrame {

	public Color azulEscuro = new Color(3, 72, 99);
	public Color branco = new Color(255, 255, 255);
	
	private JTextField txtUsuario;
	private JPasswordField txtSenha;
	private Usuario user;
	
	public FrmLogin() {
		
		this.setTitle("Login");
		setSize(400, 400);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		this.setLocationRelativeTo(null);
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setLayout(null);
		panelTitulo.setBackground(azulEscuro);
		panelTitulo.setBounds(0, 0, 400, 100);
		
		Font titulo = new Font("Arial" , Font.BOLD , 32);
		Font texto = new Font("Arial" , Font.BOLD , 16);
		
		JLabel lblTitulo = new JLabel("Parking Center");
		lblTitulo.setFont(titulo);
		lblTitulo.setBounds(80, 25, 400, 50);
		lblTitulo.setForeground(branco);
		
		panelTitulo.add(lblTitulo);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(null);
		panelPrincipal.setBackground(branco);
		panelPrincipal.setBounds(0, 101, 400, 300);
		
		JLabel lblUsuario = new JLabel("Usuário: ");
		lblUsuario.setFont(texto);
		lblUsuario.setBounds(70, 15, 100, 30);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(145, 15, 150, 30);
		
		JLabel lblSenha = new JLabel("Senha: ");
		lblSenha.setFont(texto);
		lblSenha.setBounds(70, 70, 100, 30);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(145, 70, 150, 30);
		
		JButton btLogin = new JButton("Login");
		btLogin.setFont(texto);
		btLogin.setBounds(90, 130, 200, 50);
		
		panelPrincipal.add(btLogin);
		panelPrincipal.add(lblUsuario);
		panelPrincipal.add(txtUsuario);
		panelPrincipal.add(lblSenha);
		panelPrincipal.add(txtSenha);
		
		this.getContentPane().add(panelPrincipal);
		this.getContentPane().add(panelTitulo);
		this.setVisible(true);
		
		btLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				autenticarLogin();
				
			}

		});
	}
	
	private void autenticarLogin() {
		
		UsuarioDAO dao = new UsuarioDAO();
		
		String usuario = txtUsuario.getText();
		String senha = String.valueOf(txtSenha.getPassword());
		user = dao.buscarUsuario(usuario, senha);
		
		if(user == null) {
			
			JOptionPane.showMessageDialog(null, "Campos inválidos! Por favor verifique seu usuário e senha", "Usuário não encontrado",
					JOptionPane.ERROR_MESSAGE);
			
		}else {
			
			FrmPrincipal FrmPrincipal = new FrmPrincipal();
			this.dispose();
			
		}
		
	}
	
	
}
