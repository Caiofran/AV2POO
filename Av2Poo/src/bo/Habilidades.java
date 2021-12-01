package bo;

public class Habilidades {
    private int codigo;
	private String nome;
    private int poder;
    private String rankingHabilidade;
    private int consumoChackra;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
    }
    
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
    }
    
	public int getPoder() {
		return poder;
	}
	public void setPoder(int poder) {
		this.poder = poder;
    }
    
    public String getRankingHabilidade() {
		return rankingHabilidade;
	}
	public void setRankingHabilidade(String rankingHabilidade) {
		this.rankingHabilidade = rankingHabilidade;
    }
    
    public int getConsumoChackra() {
		return consumoChackra;
	}
	public void setConsumoChackra(int consumoChackra) {
		this.consumoChackra = consumoChackra;
    }
    
}
