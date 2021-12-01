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
		List<Entregador> listaDeMissao = new ArrayList<Entregador>();
		
		try {
			EntregadorDAO model = new EntregadorDAO();
            listaDeMissao = model.read();
            		
		} catch(Exception e) {
			System.out.println("<Controller> Erro ao tentar ler Entregador: " + e);
		}

		return listaDeMissao;
	}

	public void delete(Entregador missao) {
        try {
			EntregadorDAO model = new EntregadorDAO();
            model.delete(missao);
            		
		} catch(Exception e) {
			System.out.println("<Controller> Erro ao esconder Entregador: " + e);
		}
	}
	
	public void update(Entregador missao) {
		try {
			EntregadorDAO model = new EntregadorDAO();
            model.update(missao);
            		
		} catch(Exception e) {
			System.out.println("<Controller> Erro ao tentar atualizar Entregador: " + e);
		}
	}
}
