package br.senai.sp.util;

public class Converter {

	public static String converterParaBanco(String date) {

		// 28/03/2019 09:01 ---> 2019-03-28 09:01

		String dataBanco;
		String dia = date.substring(0, 2);
		String mes = date.substring(3, 5);
		String ano = date.substring(6, 10);
		String hora = date.substring(11, 13);
		String minuto = date.substring(14, 16);
		String segundo = date.substring(17, 19);

		dataBanco = ano + "-" + mes + "-" + dia + " " + hora + ":" + minuto + ":" + segundo;

		return dataBanco;
	}

	public static String converterParaUsuario(String date) {

		// 2019-03-28 09:01:00 ---> 28/03/2019 09:01:00

		String dataTela;
		String segundo = date.substring(17, 19);
		String minuto = date.substring(14, 16);
		String hora = date.substring(11, 13);
		String dia = date.substring(8, 10);
		String mes = date.substring(5, 7);
		String ano = date.substring(0, 4);

		dataTela = dia + "/" + mes + "/" + ano + " " + hora + ":" + minuto + ":" + segundo;

		return dataTela;
	}
	
	public static String converterPlacaBanco(String placa) {
		
		//DSF-4567 -----> DSF4567
		
		String placaBanco;
		String letras = placa.substring(0, 3);
		String numeros = placa.substring(4, 8);
		
		placaBanco = letras + numeros;
		
		return placaBanco;
		
	}
}
