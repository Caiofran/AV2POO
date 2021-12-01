package controller;

import java.util.ArrayList;
import java.util.List;

import bo.Entregador;
import model.EntregadorDAO;

public class EntregadorController {
    public void create(Entregador habilidade) {
        try {
            EntregadorDAO model = new EntregadorDAO();
            model.create(habilidade);
        } catch(Exception e) {
			System.out.println("<Controller> Erro ao tentar inserir Habilidade: " + e);
		}
	}

	public List<Entregador> read() {
		List<Entregador> listaDeMissao = new ArrayList<Entregador>();
		
		try {
			EntregadorDAO model = new EntregadorDAO();
            listaDeMissao = model.read();
            		
		} catch(Exception e) {
			System.out.println("<Controller> Erro ao tentar ler Habilidade: " + e);
		}

		return listaDeMissao;
	}

	public void delete(Entregador missao) {
        try {
			EntregadorDAO model = new EntregadorDAO();
            model.delete(missao);
            		
		} catch(Exception e) {
			System.out.println("<Controller> Erro ao esconder Habilidade: " + e);
		}
	}
	
	public void update(Entregador missao) {
		try {
			EntregadorDAO model = new EntregadorDAO();
            model.update(missao);
            		
		} catch(Exception e) {
			System.out.println("<Controller> Erro ao tentar atualizar Habilidade: " + e);
		}
	}
}
