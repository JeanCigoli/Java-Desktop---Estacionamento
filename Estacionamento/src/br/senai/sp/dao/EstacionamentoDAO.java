package br.senai.sp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.senai.sp.model.Estacionamento;

public class EstacionamentoDAO {

	private Estacionamento carro;

	public EstacionamentoDAO() {}

	public EstacionamentoDAO(Estacionamento carro) {
		this.carro = carro;
	}

	// CREATE
	public void gravar() {
		String sql = "INSERT INTO tbl_movimentacao(" + 
				"placa, modelo, data_entrada, tempo, valor_pago)"
				+ "VALUES(?, ?, ?, ?, ?)";

		try {
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, carro.getPlaca());
			stm.setString(2, carro.getModelo());
			stm.setString(3, carro.getDataEntrada());
			stm.setString(4, String.valueOf(carro.getTempo()));
			stm.setString(5, String.valueOf(carro.getValorPago()));

			stm.execute();

			Conexao.fecharConexao();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// READ
	public ArrayList<Estacionamento> buscarEstacionados() {

		ArrayList<Estacionamento> carros = new ArrayList<Estacionamento>();

		Estacionamento carro;

		String sql = "SELECT * FROM tbl_movimentacao WHERE data_saida IS NULL";

		try {
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);

			ResultSet rs;

			rs = stm.executeQuery();

			while (rs.next()) {

				carro = new Estacionamento();

				carro.setCodigo(rs.getInt("codigo"));
				carro.setPlaca(rs.getString("placa"));
				carro.setModelo(rs.getString("modelo"));
				carro.setDataEntrada(rs.getString("data_entrada"));
				carro.setDataSaida(rs.getString("data_saida"));
				carro.setTempo(rs.getInt("tempo"));
				carro.setValorPago(rs.getDouble("valor_pago"));

				carros.add(carro);
			}

			Conexao.fecharConexao();

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return carros;
	}
	
	public ArrayList<Estacionamento> listarCarrosSaida() {

		ArrayList<Estacionamento> carros = new ArrayList<Estacionamento>();

		Estacionamento carro;

		String sql = "SELECT * FROM tbl_movimentacao WHERE data_saida IS NOT NULL";

		try {
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);

			ResultSet rs;

			rs = stm.executeQuery();

			while (rs.next()) {

				carro = new Estacionamento();

				carro.setCodigo(rs.getInt("codigo"));
				carro.setPlaca(rs.getString("placa"));
				carro.setModelo(rs.getString("modelo"));
				carro.setDataEntrada(rs.getString("data_entrada"));
				carro.setDataSaida(rs.getString("data_saida"));
				carro.setTempo(rs.getInt("tempo"));
				carro.setValorPago(rs.getDouble("valor_pago"));

				carros.add(carro);
			}

			Conexao.fecharConexao();

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return carros;
	}

	public Estacionamento buscarPorCodigo(int codigo) {
		
		Estacionamento carro = new Estacionamento();
		
		String sql = "SELECT * FROM tbl_movimentacao WHERE codigo = ?";
		
		try {
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);
			stm.setInt(1, codigo);
			
			ResultSet rs;
						
			rs = stm.executeQuery();
			
			rs.next();
			
			carro.setCodigo(rs.getInt("codigo"));
			carro.setPlaca(rs.getString("placa"));
			carro.setModelo(rs.getString("modelo"));
			carro.setDataEntrada(rs.getString("data_entrada"));
			carro.setDataSaida(rs.getString("data_saida"));
			carro.setTempo(rs.getInt("tempo"));
			carro.setValorPago(rs.getDouble("valor_pago"));
				
			Conexao.fecharConexao();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return carro;
		
	}

	// UPDATE
	public void atualizar() {
		
		String sql = "UPDATE tbl_movimentacao SET placa = ?, modelo = ?, data_entrada = ?, data_saida = ?, tempo = ?, valor_pago = ?"
				+ " WHERE codigo = ?";
		
		
		try {
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, carro.getPlaca());
			stm.setString(2, carro.getModelo());
			stm.setString(3, carro.getDataEntrada());
			stm.setString(4, carro.getDataSaida());
			stm.setString(5, String.valueOf(carro.getTempo()));
			stm.setString(6, String.valueOf(carro.getValorPago()));
			stm.setInt(7, carro.getCodigo());
			
			// Executar o comando no banco!!
			stm.execute();
			
			Conexao.fecharConexao();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public double buscarPrimeiraHora() {
		
		String sql = "SELECT valor_primeira_hora FROM tbl_valor WHERE data_fim IS NULL";
		
		try {
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);
			
			ResultSet rs;
						
			rs = stm.executeQuery();
			
			rs.next();
			
			double valor = (rs.getDouble("valor_primeira_hora"));
			
			Conexao.fecharConexao();
			
			return valor;

		} catch (SQLException e) {
			e.printStackTrace();
			return (Double) null;
		}
	}
	
	public double buscarDemaisHora() {
		
		String sql = "SELECT valor_demais_horas FROM tbl_valor WHERE data_fim IS NULL";
		
		try {
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);
			
			ResultSet rs;
						
			rs = stm.executeQuery();
			
			rs.next();
			
			double valor = (rs.getDouble("valor_demais_horas"));
			
			Conexao.fecharConexao();
			
			return valor;

		} catch (SQLException e) {
			e.printStackTrace();
			return (Double) null;
		}
	}

}
