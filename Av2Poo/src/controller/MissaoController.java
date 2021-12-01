package  controller;

import java.util.ArrayList;
import java.util.List;

import  bo.Missao;
import  model.MissaoDAO;

public class MissaoController {
    public void create(Missao ninja) {
        try {
            MissaoDAO model = new MissaoDAO();
            model.create(ninja);
        } catch(Exception e) {
			System.out.println("<Controller> Erro ao tentar inserir Missao: " + e);
		}
	}

	public List<Missao> read() {
		List<Missao> listaDeMissao = new ArrayList<Missao>();
		
		try {
			MissaoDAO model = new MissaoDAO();
            listaDeMissao = model.read();
            		
		} catch(Exception e) {
			System.out.println("<Controller> Erro ao tentar ler Missao: " + e);
		}

		return listaDeMissao;
	}

	public void delete(Missao missao) {
        try {
			MissaoDAO model = new MissaoDAO();
            model.delete(missao);
            		
		} catch(Exception e) {
			System.out.println("<Controller> Erro ao esconder Missao: " + e);
		}
	}
	
	public void update(Missao missao) {
		try {
			MissaoDAO model = new MissaoDAO();
            model.update(missao);
            		
		} catch(Exception e) {
			System.out.println("<Controller> Erro ao tentar atualizar Missao: " + e);
		}
	}
}
