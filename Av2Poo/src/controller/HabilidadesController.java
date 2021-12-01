package controller;

import java.util.ArrayList;
import java.util.List;

import bo.Habilidades;
import model.HabilidadesDAO;

public class HabilidadesController {
    public void create(Habilidades habilidade) {
        try {
            HabilidadesDAO model = new HabilidadesDAO();
            model.create(habilidade);
        } catch(Exception e) {
			System.out.println("<Controller> Erro ao tentar inserir Habilidade: " + e);
		}
	}

	public List<Habilidades> read() {
		List<Habilidades> listaDeMissao = new ArrayList<Habilidades>();
		
		try {
			HabilidadesDAO model = new HabilidadesDAO();
            listaDeMissao = model.read();
            		
		} catch(Exception e) {
			System.out.println("<Controller> Erro ao tentar ler Habilidade: " + e);
		}

		return listaDeMissao;
	}

	public void delete(Habilidades missao) {
        try {
			HabilidadesDAO model = new HabilidadesDAO();
            model.delete(missao);
            		
		} catch(Exception e) {
			System.out.println("<Controller> Erro ao esconder Habilidade: " + e);
		}
	}
	
	public void update(Habilidades missao) {
		try {
			HabilidadesDAO model = new HabilidadesDAO();
            model.update(missao);
            		
		} catch(Exception e) {
			System.out.println("<Controller> Erro ao tentar atualizar Habilidade: " + e);
		}
	}
}
