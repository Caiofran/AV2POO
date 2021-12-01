package  controller;

import java.util.ArrayList;
import java.util.List;
import  bo.Ninja;
import  model.NinjaDAO;

public class NinjaController {

	public void create(Ninja ninja) {
        try {
            NinjaDAO model = new NinjaDAO();
            model.create(ninja);
        } catch(Exception e) {
            System.out.println("<Controller> Erro ao tentar inserir Ninja: " + e);
        }
	}

	public List<Ninja> read() {
		List<Ninja> listaDeNinjas = new ArrayList<Ninja>();
		
		try {
			NinjaDAO model = new NinjaDAO();
            listaDeNinjas = model.read();
            		
		} catch(Exception e) {
			System.out.println("<Controller> Erro ao tentar ler Ninja: " + e);
		}

		return listaDeNinjas;
	}

	public void delete(Ninja ninja) {
        try {
			NinjaDAO model = new NinjaDAO();
            model.delete(ninja);
            		
		} catch(Exception e) {
			System.out.println("<Controller> Erro ao tentar Renegar Ninja: " + e);
		}
	}
	
	public void update(Ninja ninja) {
        try {
            NinjaDAO model = new NinjaDAO();
            model.update(ninja);

        } catch(Exception e) {
            System.out.println("<Controller> Erro ao tentar Atualizar Ninja: " + e);
        }
	}
}