package br.edu.facear.service;

import br.edu.facear.dao.ClienteDAO;
import br.edu.facear.model.Cliente;

public class AutenticarUsuarioService {

	public Cliente autenticar(String email, String senha) {
		
		ClienteDAO dao = new ClienteDAO();
		Cliente c = null;
		try {
			c = dao.autenticar(email, senha);	
		} catch (Exception e) {
			// TODO: handle exception
		}
		return c;
	}
}
