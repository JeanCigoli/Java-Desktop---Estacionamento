package br.senai.sp.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import br.senai.sp.dao.EstacionamentoDAO;
import br.senai.sp.model.Estacionamento;
import br.senai.sp.util.Calculo;
import br.senai.sp.util.Converter;
import br.senai.sp.util.Data;

public class FrmPrincipal extends JFrame {

	private JPanel painelTabela;
	private final JTable tabelaVeiculos = new JTable();
	private final JScrollPane scroll = new JScrollPane();
	private DefaultTableModel modelo; 

	// FAZENDO AS CORES PARA USAR
	public Color azulEscuro = new Color(3, 72, 99);
	public Color azul = new Color(141, 211, 239);
	public Color branco = new Color(255, 255, 255);
	public Color cinza = new Color(181, 182, 183);

	public Color verde = new Color(19, 191, 21);
	public Color amarelo = new Color(237, 218, 9);
	public Color vermelho = new Color(237, 78, 75);
	public Color preto = new Color(0, 0, 0);

	public FrmPrincipal() {

		this.setTitle("Estacionamento Parking Center");
		setSize(700, 600);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		this.setLocationRelativeTo(null);
		
		String vetor[] = {"Veículos estacionados", "Veículos que saíram"};
		
		JComboBox opcaoTabela = new JComboBox(vetor);

		// CRIANDO O PAINEL PRINCIPAL DA TABELA
		painelTabela = new JPanel();
		painelTabela.setBounds(10, 40, 660, 360);
		painelTabela.setLayout(null);
		
		opcaoTabela.setBounds(500, 10, 165, 30);
		this.getContentPane().add(opcaoTabela);

		Border blackBorder = BorderFactory.createLineBorder(preto);
		TitledBorder bordaTabela = new TitledBorder(blackBorder, "Lista de veículos");
		painelTabela.setBorder(bordaTabela);

		// CRIANDO O PAINEL DE BOTAO
		JPanel painelBotao = new JPanel();
		painelBotao.setBounds(12, 420, 656, 130);
		painelBotao.setLayout(null);

		TitledBorder bordaBotao = new TitledBorder(blackBorder, "");
		painelBotao.setBorder(bordaBotao);

		
		// CRIANDO OS BOTOES
		Border greenBorder = BorderFactory.createLineBorder(verde);
		Border yellowBorder = BorderFactory.createLineBorder(amarelo);
		Border redBorder = BorderFactory.createLineBorder(vermelho);
		
		
		JButton btAdicionar = new JButton();
		btAdicionar.setBounds(15, 15, 100, 100);
		painelBotao.add(btAdicionar);
		
		TitledBorder bordaAdicionar = new TitledBorder(greenBorder, "");
		btAdicionar.setBorder(bordaAdicionar);
		
		btAdicionar.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/br/senai/sp/imagens/entrada48.png")));
		btAdicionar.setToolTipText("Adicionar Novo Veículo");

		
		
		JButton btExcluir = new JButton();
		btExcluir.setBounds(125, 15, 100, 100);
		painelBotao.add(btExcluir);
		
		TitledBorder bordaExcluir = new TitledBorder(redBorder, "");
		btExcluir.setBorder(bordaExcluir);
		
		btExcluir.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/br/senai/sp/imagens/saida48.png")));
		btExcluir.setToolTipText("Saída de Veículo");


		
		JButton btEditar = new JButton();
		btEditar.setBounds(235, 15, 100, 100);
		painelBotao.add(btEditar);
		
		TitledBorder bordaEditar = new TitledBorder(yellowBorder, "");
		btEditar.setBorder(bordaEditar);
	
		btEditar.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/br/senai/sp/imagens/editar.png")));
		btEditar.setToolTipText("Alterar dados do veículo");
		
		

		JButton btSair = new JButton();
		btSair.setBounds(540, 15, 100, 100);
		painelBotao.add(btSair);
		
		TitledBorder bordaSair = new TitledBorder(blackBorder, "");
		btSair.setBorder(bordaSair);
		
		btSair.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/br/senai/sp/imagens/sairsistema48.png")));
		btSair.setToolTipText("Sair do Sistema");
		
		
		// ------------------------- OUVINTE DE AÇÃO ---------------------------
		
		btAdicionar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				 FrmCadastro cadastro = new FrmCadastro();
				 cadastro.setVisible(true);
				
			}
		});

		btEditar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				abrirFormularioCarro("Atualizar", "Atualizar", "editar.png");

			}
		});

		btExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				abrirFormularioSaida();

			}
		});

		btSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int resposta;

				resposta = JOptionPane.showConfirmDialog(null, "Confirma a saída do sistema?", "Fechar Sistema",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

				if (resposta == 0) {
					System.exit(EXIT_ON_CLOSE);
				}

			}
		});

		this.getContentPane().add(painelBotao);
		this.getContentPane().add(painelTabela);

		this.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
			}

			@Override
			public void windowIconified(WindowEvent e) {
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
			}

			@Override
			public void windowClosing(WindowEvent e) {
			}

			@Override
			public void windowClosed(WindowEvent e) {
			}

			@Override
			public void windowActivated(WindowEvent e) {
				
				criarTabela();
				
			}
		});
		
		opcaoTabela.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(opcaoTabela.getSelectedIndex() == 0) {
					criarTabela();
				}else {
					criarTabelaSaida();
				}
				
			}
		});
		
		this.setVisible(true);
	}
	
	private void criarTabela() {
		
		scroll.setBounds(15, 25, 630, 320);

		String[] cabecalho = { "CÓDIGO", "MODELO", "PLACA", "DATA ENTRADA" };

		EstacionamentoDAO dao = new EstacionamentoDAO();
		ArrayList<Estacionamento> carros = dao.buscarEstacionados();

		int linhas = carros.size();

		int linha = 0;

		String[][] dados = new String[linhas][4];

		for (Estacionamento carro : carros) {
			dados[linha][0] = String.valueOf(carro.getCodigo());
			dados[linha][1] = carro.getModelo();
			dados[linha][2] = carro.getPlaca();
			dados[linha][3] = Converter.converterParaUsuario(carro.getDataEntrada());
			linha++;
		}

		modelo = new DefaultTableModel(dados, cabecalho);

		// Criar a tabela (JTable)
		tabelaVeiculos.setModel(modelo);

		// Determinar largura das colunas da tabela
		tabelaVeiculos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabelaVeiculos.getColumnModel().getColumn(0).setPreferredWidth(60);
		tabelaVeiculos.getColumnModel().getColumn(1).setPreferredWidth(170);
		tabelaVeiculos.getColumnModel().getColumn(2).setPreferredWidth(200);
		tabelaVeiculos.getColumnModel().getColumn(3).setPreferredWidth(198);

		tabelaVeiculos.setDefaultEditor(Object.class, null);

		tabelaVeiculos.getTableHeader().setReorderingAllowed(false);
		tabelaVeiculos.setRowSelectionAllowed(true);

		scroll.setViewportView(tabelaVeiculos);

		painelTabela.add(scroll);
		
	}
	
private void criarTabelaSaida() {
		
		scroll.setBounds(15, 25, 630, 320);

		String[] cabecalho = { "CÓDIGO", "MODELO", "PLACA", "DATA ENTRADA", "DATA SAÍDA" , "TEMPO" ,"VALOR PAGO" };

		EstacionamentoDAO dao = new EstacionamentoDAO();
		ArrayList<Estacionamento> carros = dao.listarCarrosSaida();

		int linhas = carros.size();

		int linha = 0;

		String[][] dados = new String[linhas][7];

		for (Estacionamento carro : carros) {
			dados[linha][0] = String.valueOf(carro.getCodigo());
			dados[linha][1] = carro.getModelo();
			dados[linha][2] = carro.getPlaca();
			dados[linha][3] = Converter.converterParaUsuario(carro.getDataEntrada());
			dados[linha][4] = Converter.converterParaUsuario(carro.getDataSaida());
			dados[linha][5] = String.valueOf(carro.getTempo());
			dados[linha][6] = String.valueOf(carro.getValorPago());
			linha++;
		}

		modelo = new DefaultTableModel(dados, cabecalho);

		// Criar a tabela (JTable)
		tabelaVeiculos.setModel(modelo);

		// Determinar largura das colunas da tabela
		tabelaVeiculos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabelaVeiculos.getColumnModel().getColumn(0).setPreferredWidth(50);
		tabelaVeiculos.getColumnModel().getColumn(1).setPreferredWidth(100);
		tabelaVeiculos.getColumnModel().getColumn(2).setPreferredWidth(100);
		tabelaVeiculos.getColumnModel().getColumn(3).setPreferredWidth(130);
		tabelaVeiculos.getColumnModel().getColumn(4).setPreferredWidth(130);
		tabelaVeiculos.getColumnModel().getColumn(5).setPreferredWidth(45);
		tabelaVeiculos.getColumnModel().getColumn(6).setPreferredWidth(73);
		
		tabelaVeiculos.setDefaultEditor(Object.class, null);
		tabelaVeiculos.getTableHeader().setReorderingAllowed(false);
		tabelaVeiculos.setRowSelectionAllowed(false);
		
		scroll.setViewportView(tabelaVeiculos);

		painelTabela.add(scroll);
		
	}

	private void abrirFormularioCarro(String textoTitulo, String textoBotao, String nomeDaImagem) {
		
		FrmCadastro cadastro = new FrmCadastro();
		
		cadastro.btGravar.setText(textoBotao);
		cadastro.lblTitulo.setText(textoTitulo);
		cadastro.lblIcon
		.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/br/senai/sp/imagens/" + nomeDaImagem)));
	
		// pegando a linha que vc quer
		int codigo = 0;
	
		int linha = tabelaVeiculos.getSelectedRow();
	
		int coluna = 0;
	
		if (linha == -1) {
	
			JOptionPane.showMessageDialog(null, "Por favor selecione um veículo na lista!", "Veículo não selecionado",
					JOptionPane.ERROR_MESSAGE);
	
		} else {
	
			codigo = Integer.parseInt(tabelaVeiculos.getValueAt(linha, coluna).toString());
	
			// Criando um aluno pelo o aluno no banco
			EstacionamentoDAO dao = new EstacionamentoDAO();
			Estacionamento carro = dao.buscarPorCodigo(codigo);
	
			cadastro.lblCodigo.setText(String.valueOf(carro.getCodigo()));
			cadastro.txtPlaca.setText(carro.getPlaca());
			cadastro.txtDataEntrada.setText(Converter.converterParaUsuario(carro.getDataEntrada()));
			cadastro.txtModelo.setText(carro.getModelo());
			
			cadastro.setVisible(true);
	
		}
	
	}
	
private void abrirFormularioSaida() {
		
		FrmSaida FrmSaida = new FrmSaida();
		
		// pegando a linha que vc quer
		int codigo = 0;
	
		int linha = tabelaVeiculos.getSelectedRow();
	
		int coluna = 0;
	
		if (linha == -1) {
	
			JOptionPane.showMessageDialog(null, "Por favor selecione um veículo na lista!", "Veículo não selecionado",
					JOptionPane.ERROR_MESSAGE);
	
		} else {
	
			codigo = Integer.parseInt(tabelaVeiculos.getValueAt(linha, coluna).toString());
	
			// Criando um aluno pelo o aluno no banco
			EstacionamentoDAO dao = new EstacionamentoDAO();
			Calculo calc = new Calculo();
			Estacionamento carro = dao.buscarPorCodigo(codigo);
	
			FrmSaida.lblCodigo.setText(String.valueOf(carro.getCodigo()));
			FrmSaida.txtPlaca.setText(carro.getPlaca());
			FrmSaida.txtModelo.setText(carro.getModelo());
			FrmSaida.txtDataEntrada.setText(Converter.converterParaUsuario(carro.getDataEntrada()));
			FrmSaida.txtDataSaida.setText(Data.pegarDataAtual());
			FrmSaida.txtTempo.setText(
					String.valueOf(
					Data.calcularTempo(
					FrmSaida.txtDataEntrada.getText(), FrmSaida.txtDataSaida.getText())));
			FrmSaida.txtValorPagar.setText(
					String.valueOf(calc.calcularValorPago(
					Integer.parseInt(FrmSaida.txtTempo.getText()))));
			
			FrmSaida.setVisible(true);
	
		}
	
	}

}
