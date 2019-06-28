package br.senai.sp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {
	
	private static Connection con;

	public static Connection getConexao() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dbUrl = "jdbc:mysql://localhost/db_estacionamento?useTimezone=true&serverTimezone=UTC&useSSL=false";
			con = DriverManager.getConnection(dbUrl, "root", "");
			//con = DriverManager.getConnection(dbUrl, "root", "bcd127");
			
		} catch (ClassNotFoundException | SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Ocorreu um erro na abertura da conexão!");
			e.printStackTrace();
			
		}
		
		return con;
		
	}
	
	public static void fecharConexao() {
		
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
