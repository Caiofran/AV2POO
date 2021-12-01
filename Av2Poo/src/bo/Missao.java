package bo;

public class Missao {
    private int codigo;
	private String componente;
    private String tipo;
    private String cliente;
    private String ranking;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
    }
    
	public String getComponente() {
		return componente;
	}
	public void setComponente(String componente) {
		this.componente = componente;
    }
    
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
    }
    
    public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
    }
    
    public String getRanking() {
		return ranking;
	}
	public void setRanking(String ranking) {
		this.ranking = ranking;
    }
   
}
