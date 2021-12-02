package  controller;

import java.util.ArrayList;
import java.util.List;
import  bo.Cliente;
import  model.ClienteDAO;

public class ClienteController {

	public void create(Cliente cliente) {
        try {
            ClienteDAO model = new ClienteDAO();
            model.create(cliente);
        } catch(Exception e) {
            System.out.println("<Controller> Erro ao tentar inserir Cliente: " + e);
        }
	}

	public List<Cliente> read() {
		List<Cliente> listaDeClientes = new ArrayList<Cliente>();
		
		try {
			ClienteDAO model = new ClienteDAO();
            listaDeClientes = model.read();
            		
		} catch(Exception e) {
			System.out.println("<Controller> Erro ao tentar ler Cliente: " + e);
		}

		return listaDeClientes;
	}

	public void delete(Cliente cliente) {
        try {
			ClienteDAO model = new ClienteDAO();
            model.delete(cliente);
            		
		} catch(Exception e) {
			System.out.println("<Controller> Erro ao tentar Renegar Cliente: " + e);
		}
	}
	
	public void update(Cliente cliente) {
        try {
            ClienteDAO model = new ClienteDAO();
            model.update(cliente);

        } catch(Exception e) {
            System.out.println("<Controller> Erro ao tentar Atualizar Cliente: " + e);
        }
	}
}