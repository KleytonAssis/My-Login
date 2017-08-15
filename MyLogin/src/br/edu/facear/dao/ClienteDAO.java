package br.edu.facear.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import br.edu.facear.model.Cliente;

public class ClienteDAO extends GenericDAO {

	private PreparedStatement ps;
	private String LOGIN_SQL = "select * from CLiente where Email = ? and Senha = ?;";
	
	public  Cliente autenticar (String email , String senha) {
		Cliente c = null;
		//Abrir conexão
		
		try {
			openConnection();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//preparar o script
		try {
			ps = connect.prepareStatement(LOGIN_SQL);
			ps.setString(1, email);
			ps.setString(2, senha);
			
			ResultSet rs = ps.executeQuery();
			if(rs !=  null) {
				while (rs.next()) {
					c = new Cliente(rs.getInt("Id_Cliente"),
							rs.getString("Nome"),
							rs.getString("Cpf"),
							rs.getString("Email"),
							rs.getString("Senha"));
					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// fechar conexão
		closeConnection();
		
		return c;
	}
	
	
}
