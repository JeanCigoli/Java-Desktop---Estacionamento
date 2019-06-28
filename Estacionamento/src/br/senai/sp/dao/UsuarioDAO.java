package br.senai.sp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.senai.sp.model.Usuario;

public class UsuarioDAO {

	private Usuario usuario;
	
	public UsuarioDAO() {}

	public UsuarioDAO(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	public void gravar() {
		String sql = "INSERT INTO tbl_usuario(" + 
				"nome, usuario, senha)"
				+ "VALUES(?, ?, ?)";

		try {
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, usuario.getNome());
			stm.setString(2, usuario.getUsuario());
			stm.setString(3, usuario.getSenha());

			stm.execute();

			Conexao.fecharConexao();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public Usuario buscarUsuario(String usuario, String senha) {
		
		Usuario user = new Usuario();
		
		String sql = "SELECT * FROM tbl_usuario WHERE usuario = ? AND senha = ?";
		
		try {
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, usuario);
			stm.setString(2, senha);
			
			ResultSet rs;
						
			rs = stm.executeQuery();
			
			rs.next();
			
			user.setId(rs.getInt("id"));
			user.setNome(rs.getString("nome"));
			user.setUsuario(rs.getString("usuario"));
			user.setSenha(rs.getString("senha"));
				
			Conexao.fecharConexao();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
			
		}
		
		return user;
		
	}
	
	
}
