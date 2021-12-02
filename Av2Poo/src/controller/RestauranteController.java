package  controller;

import java.util.ArrayList;
import java.util.List;

import  bo.Restaurante;
import  model.RestauranteDAO;

public class RestauranteController {
    public void create(Restaurante ninja) {
        try {
            RestauranteDAO model = new RestauranteDAO();
            model.create(ninja);
        } catch(Exception e) {
			System.out.println("<Controller> Erro ao tentar inserir Restaurante: " + e);
		}
	}

	public List<Restaurante> read() {
		List<Restaurante> listaDeRestaurante = new ArrayList<Restaurante>();
		
		try {
			RestauranteDAO model = new RestauranteDAO();
            listaDeRestaurante = model.read();
            		
		} catch(Exception e) {
			System.out.println("<Controller> Erro ao tentar ler Restaurante: " + e);
		}

		return listaDeRestaurante;
	}

	public void delete(Restaurante restaurante) {
        try {
			RestauranteDAO model = new RestauranteDAO();
            model.delete(restaurante);
            		
		} catch(Exception e) {
			System.out.println("<Controller> Erro ao esconder Restaurante: " + e);
		}
	}
	
	public void update(Restaurante restaurante) {
		try {
			RestauranteDAO model = new RestauranteDAO();
            model.update(restaurante);
            		
		} catch(Exception e) {
			System.out.println("<Controller> Erro ao tentar atualizar Restaurante: " + e);
		}
	}
}
