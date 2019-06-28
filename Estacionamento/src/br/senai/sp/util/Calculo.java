package br.senai.sp.util;

import br.senai.sp.dao.EstacionamentoDAO;
import br.senai.sp.model.Estacionamento;

public class Calculo {

	private int horas;
	private double valorPagar;
	private double primeiraHora;
	private double demaisHora;
	
	public double calcularValorPago(int horas) {
		
		EstacionamentoDAO dao = new EstacionamentoDAO();
		primeiraHora = dao.buscarPrimeiraHora();
		demaisHora = dao.buscarDemaisHora();
		
		if(horas == 1) {
			valorPagar = primeiraHora;
		}else if(horas > 1){
			valorPagar = primeiraHora + (horas-1) * demaisHora;
		}

		return valorPagar;
		
	}
	
}
