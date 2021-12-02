package bo;

public class Entregador {

	private String nome; //ok
    private int telefone; //ok
    private int cpf; //ok
    private String placa;
    private int habilitacao;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
    }

	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
    }    
    
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
    }
    
    public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
    }
    
    public String getHabilitacao() {
		return habilitacao;
	}
	public void sethabilitacao(int habilitacao) {
		this.habilitacao = habilitacao;
    }
    
}
