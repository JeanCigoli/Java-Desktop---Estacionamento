package br.senai.sp.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class FrmSaida extends JDialog {

	public JPanel panelTitulo;
	public JLabel lblTitulo;
	public JLabel lblIcon;
	public JLabel lblTextoCodigo;
	public JLabel lblCodigo;
	public JLabel lblPlaca;
	public JTextField txtPlaca;
	public JLabel lblModelo;
	public JTextField txtModelo;
	public JLabel lblDataEntrada;
	public JTextField txtDataEntrada;
	public JLabel lblDataSaida;
	public JTextField txtDataSaida;
	public JLabel lblTempo;
	public JTextField txtTempo;
	public JLabel lblValorPagar;
	public JTextField txtValorPagar;
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
	
	public FrmSaida(){
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(400, 700);
		this.setTitle("Check-out");
		this.setLayout(null);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		
		// CRIANDO O TITULO DA TELA
		panelTitulo = new JPanel();
		panelTitulo.setLayout(null);
		panelTitulo.setBackground(azulEscuro);
		panelTitulo.setBounds(0, 0, 400, 100);
		
		Border lineBorder = BorderFactory.createLineBorder(preto);
		Font titulo = new Font("Arial" , Font.BOLD , 32);
		Font texto = new Font("Arial" , Font.BOLD , 16);
		
		lblTitulo = new JLabel("Saída de Veículo");
		lblTitulo.setFont(titulo);
		lblTitulo.setBounds(100, 25, 300, 50);
		lblTitulo.setForeground(branco);
		
		lblIcon = new JLabel();
		lblIcon.setBounds(15, 15, 65, 60);
		lblIcon.setIcon(new ImageIcon(FrmCadastro.class.getResource("/br/senai/sp/imagens/saida48.png")));
		
		panelTitulo.add(lblTitulo);
		panelTitulo.add(lblIcon);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(null);
		panelPrincipal.setBackground(branco);
		panelPrincipal.setBounds(0, 100, 400, 600);
		
		lblTextoCodigo = new JLabel("Código: ");
		lblTextoCodigo.setFont(texto);
		lblTextoCodigo.setBounds(200, 5, 100, 30);
		
		lblCodigo = new JLabel("00");
		lblCodigo.setFont(texto);
		lblCodigo.setBounds(270, 5, 100, 30);
		
		lblPlaca = new JLabel("Placa: ");
		lblPlaca.setFont(texto);
		lblPlaca.setBounds(15, 5, 100, 30);
		
		try {
			txtPlaca = new JFormattedTextField(new MaskFormatter("AAA-####"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtPlaca.setBounds(15, 45, 150, 30);
		txtPlaca.setEditable(false);
		
		lblModelo = new JLabel("Modelo: ");
		lblModelo.setFont(texto);
		lblModelo.setBounds(15, 85, 100, 30);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(15, 120, 150, 30);
		txtModelo.setEditable(false);
		
		lblDataEntrada = new JLabel("Data entrada: ");
		lblDataEntrada.setFont(texto);
		lblDataEntrada.setBounds(15, 160, 150, 30);
		
		txtDataEntrada = new JTextField();
		txtDataEntrada.setBounds(15, 195, 150, 30);
		txtDataEntrada.setEditable(false);
		
		lblDataSaida = new JLabel("Data saída: ");
		lblDataSaida.setFont(texto);
		lblDataSaida.setBounds(15, 235, 150, 30);
		
		txtDataSaida = new JTextField();
		txtDataSaida.setBounds(15, 270, 150, 30);
		txtDataSaida.setEditable(false);
		
		lblTempo = new JLabel("Tempo de uso: ");
		lblTempo.setFont(texto);
		lblTempo.setBounds(15, 310, 150, 30);
		
		txtTempo = new JTextField();
		txtTempo.setBounds(15, 345, 150, 30);
		txtTempo.setEditable(false);
		
		lblValorPagar = new JLabel("Valor a pagar: ");
		lblValorPagar.setFont(texto);
		lblValorPagar.setBounds(15, 385, 150, 30);
		
		txtValorPagar = new JTextField();
		txtValorPagar.setBounds(15, 415, 150, 30);
		txtValorPagar.setEditable(false);
		
		btGravar = new JButton("Confirmar");
		btGravar.setFont(texto);
		btGravar.setBounds(220, 470, 150, 70);
		
		panelPrincipal.add(lblTextoCodigo);
		panelPrincipal.add(lblCodigo);
		panelPrincipal.add(btGravar);
		panelPrincipal.add(lblPlaca);
		panelPrincipal.add(txtPlaca);
		panelPrincipal.add(lblModelo);
		panelPrincipal.add(txtModelo);
		panelPrincipal.add(lblDataEntrada);
		panelPrincipal.add(txtDataEntrada);
		panelPrincipal.add(lblDataSaida);
		panelPrincipal.add(txtDataSaida);
		panelPrincipal.add(lblTempo);
		panelPrincipal.add(txtTempo);
		panelPrincipal.add(lblValorPagar);
		panelPrincipal.add(txtValorPagar);
		
		btGravar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				atualizar();
				
			}
		});
		
		this.getContentPane().add(panelTitulo);
		this.getContentPane().add(panelPrincipal);
		this.setModal(true);
		
	}
	
	private void atualizar() {
		
		int resposta = JOptionPane.showConfirmDialog(null,
				"Confirma a saída do veículo " + txtModelo.getText() + " ?", 
				"Saída de veículo", 
				JOptionPane.YES_NO_OPTION, 
				JOptionPane.QUESTION_MESSAGE);
		
		if (resposta == 0) {
			
			EstacionamentoDAO dao = new EstacionamentoDAO(criarCarro());
			dao.atualizar();
			this.dispose();
		}
	}
	
	private Estacionamento criarCarro() {
		
		Estacionamento carro = new Estacionamento();
		
		// Para validar os Códigos
		carro.setCodigo(Integer.parseInt(lblCodigo.getText()));
		carro.setDataEntrada(Converter.converterParaBanco(txtDataEntrada.getText()));
		carro.setDataSaida(Converter.converterParaBanco(txtDataSaida.getText()));
		carro.setPlaca(Converter.converterPlacaBanco(txtPlaca.getText()));
		carro.setModelo(txtModelo.getText());
		carro.setTempo(Integer.parseInt(txtTempo.getText()));
		carro.setValorPago(Double.parseDouble(txtValorPagar.getText()));
		
		return carro;
	}
}
