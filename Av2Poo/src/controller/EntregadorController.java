package controller;

import java.util.ArrayList;
import java.util.List;

import bo.Entregador;
import model.EntregadorDAO;

public class EntregadorController {
    public void create(Entregador entregador) {
        try {
            EntregadorDAO model = new EntregadorDAO();
            model.create(entregador);
        } catch(Exception e) {
			System.out.println("<Controller> Erro ao tentar inserir Entregador: " + e);
		}
	}

	public List<Entregador> read() {
		List<Entregador> listaDeEntregador = new ArrayList<Entregador>();
		
		try {
			EntregadorDAO model = new EntregadorDAO();
            listaDeEntregador = model.read();
            		
		} catch(Exception e) {
			System.out.println("<Controller> Erro ao tentar ler Entregador: " + e);
		}

		return listaDeEntregador;
	}

	public void delete(Entregador entregador) {
        try {
			EntregadorDAO model = new EntregadorDAO();
            model.delete(entregador);
            		
		} catch(Exception e) {
			System.out.println("<Controller> Erro ao deletar Entregador: " + e);
		}
	}
	
	public void update(Entregador entregador) {
		try {
			EntregadorDAO model = new EntregadorDAO();
            model.update(entregador);
            		
		} catch(Exception e) {
			System.out.println("<Controller> Erro ao atualizar Entregador: " + e);
		}
	}
}
