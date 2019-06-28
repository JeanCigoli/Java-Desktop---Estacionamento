package br.senai.sp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.senai.sp.model.Estacionamento;

public class Data {
	
	public static String pegarDataAtual() {

		Date agora = new Date();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String dataAtual = df.format(agora);
	
		return dataAtual;
	}
	

	public static int calcularTempo(String dataEntrada, String dataSaida) {
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date dtSaida = null;
		Date dtEntrada = null;
		 
		 
		try {
			dtSaida = df.parse(dataSaida);
			dtEntrada = df.parse(dataEntrada);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		 
		long mils = dtSaida.getTime() - dtEntrada.getTime();
		 
		double hora = mils / 1000 / 60 / 60;
		double minuto = mils / 1000 / 60;
		
		int tolerancia = 5;
		
		if(hora == 0.0) {
			if(minuto > tolerancia) {
				hora += 1;
			}
		} else if (minuto >= hora * 60) {
			if( (minuto - hora * 60) > tolerancia ) {
				hora += 1;
			}
		}
		
		return (int)hora;

	}
	
}
