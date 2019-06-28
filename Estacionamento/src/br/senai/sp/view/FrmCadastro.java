package br.senai.sp.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;

import br.senai.sp.dao.EstacionamentoDAO;
import br.senai.sp.model.Estacionamento;
import br.senai.sp.util.Converter;
import br.senai.sp.util.Data;


public class FrmCadastro extends JDialog{

	public JPanel panelTitulo;
	public JLabel lblTitulo;
	public JLabel lblIcon;
	public JLabel lblPlaca;
	public JTextField txtPlaca;
	public JLabel lblModelo;
	public JTextField txtModelo;
	public JLabel lblCodigo;
	public JLabel lblDataEntrada;
	public JTextField txtDataEntrada;
	public JLabel lblTextoCodigo;
	public JButton btGravar;
	
	
	// DEFININDO AS CORES
	public Color azulEscuro = new Color(3, 72, 99);
	public Color azul = new Color(141, 211, 239);
	public Color branco = new Color(255, 255, 255);
	public Color cinza = new Color(181, 182, 183);
	public Color preto = new Color(0,0,0);
	public Color verde = new Color(19, 191, 21);
	public Color amarelo = new Color(237, 218, 9);
	public Color vermelho = new Color(237, 78, 75);
			
	
	public FrmCadastro (){
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(350, 500);
		this.setTitle("Check-in");
		this.setLayout(null);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		
		// CRIANDO O TITULO DA TELA
		panelTitulo = new JPanel();
		panelTitulo.setLayout(null);
		panelTitulo.setBackground(azulEscuro);
		panelTitulo.setBounds(0, 0, 350, 100);
		
		Border lineBorder = BorderFactory.createLineBorder(preto);
		Font titulo = new Font("Arial" , Font.BOLD , 32);
		Font texto = new Font("Arial" , Font.BOLD , 16);
		
		lblTitulo = new JLabel("Novo Veículo");
		lblTitulo.setFont(titulo);
		lblTitulo.setBounds(100, 25, 250, 50);
		lblTitulo.setForeground(branco);
		
		lblIcon = new JLabel();
		lblIcon.setBounds(15, 15, 65, 60);
		lblIcon.setIcon(new ImageIcon(FrmCadastro.class.getResource("/br/senai/sp/imagens/entrada48.png")));
		
		panelTitulo.add(lblTitulo);
		panelTitulo.add(lblIcon);
		
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(null);
		panelPrincipal.setBackground(branco);
		panelPrincipal.setBounds(0, 100, 350, 400);
		
		lblTextoCodigo = new JLabel("Código: ");
		lblTextoCodigo.setFont(texto);
		lblTextoCodigo.setBounds(200, 5, 100, 50);
		
		lblCodigo = new JLabel("00");
		lblCodigo.setFont(texto);
		lblCodigo.setBounds(270, 5, 100, 50);
		
		lblPlaca = new JLabel("Placa: ");
		lblPlaca.setFont(texto);
		lblPlaca.setBounds(15, 5, 100, 50);
		
		try {
			txtPlaca = new JFormattedTextField(new MaskFormatter("AAA-####"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		txtPlaca.setBounds(15, 60, 150, 30);
		
		lblModelo = new JLabel("Modelo: ");
		lblModelo.setFont(texto);
		lblModelo.setBounds(15, 100, 100, 50);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(15, 145, 150, 30);
		
		lblDataEntrada = new JLabel("Data entrada: ");
		lblDataEntrada.setFont(texto);
		lblDataEntrada.setBounds(15, 185, 150, 50);
		
		txtDataEntrada = new JTextField();
		txtDataEntrada.setBounds(15, 225, 150, 30);
		txtDataEntrada.setEditable(false);
		
		btGravar = new JButton("Gravar");
		btGravar.setFont(texto);
		btGravar.setBounds(170, 270, 150, 70);
		
		panelPrincipal.add(lblTextoCodigo);
		panelPrincipal.add(lblCodigo);
		panelPrincipal.add(btGravar);
		panelPrincipal.add(lblPlaca);
		panelPrincipal.add(txtPlaca);
		panelPrincipal.add(lblModelo);
		panelPrincipal.add(txtModelo);
		panelPrincipal.add(lblDataEntrada);
		panelPrincipal.add(txtDataEntrada);
		
		
		// --------------------- OUVINTES -------------------------------
		
		// Calculando os botoes
		btGravar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (btGravar.getText().equals("Gravar")) {
					gravar();
				} else {
					atualizar();
				}

			}

		});
		
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				
				if(btGravar.getText().equals("Gravar")) {
					txtDataEntrada.setText(Data.pegarDataAtual());
				}
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
			}
		});
		
		
		this.getContentPane().add(panelPrincipal);
		this.getContentPane().add(panelTitulo);
		this.setModal(true);
	}
	
	private void atualizar() {
		
		EstacionamentoDAO dao = new EstacionamentoDAO(criarCarro());
		
		
		dao.atualizar();
		JOptionPane.showMessageDialog(null, "Veículo atualizado com sucesso!",
				"Atualização de veículo", 
				JOptionPane.INFORMATION_MESSAGE, null);
		
	}
	
	private void gravar() {
		
		EstacionamentoDAO dao = new EstacionamentoDAO(criarCarro());
		
		dao.gravar();
		JOptionPane.showMessageDialog(null, "Veículo registrado com sucesso", "Novo veículo", JOptionPane.INFORMATION_MESSAGE, null);

		btGravar.setEnabled(false);
		
	}
	
	private Estacionamento criarCarro() {
		
		Estacionamento carro = new Estacionamento();
		
		// Para validar os Códigos
		
		if(!btGravar.getText().equals("Gravar")) {
			carro.setCodigo(Integer.parseInt(lblCodigo.getText()));
		}

		carro.setDataEntrada(Converter.converterParaBanco(txtDataEntrada.getText()));
		carro.setPlaca(Converter.converterPlacaBanco(txtPlaca.getText()));
		carro.setModelo(txtModelo.getText());
		
		
		return carro;
	}
}
