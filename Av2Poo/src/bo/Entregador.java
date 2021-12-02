package bo;

public class Entregador {

	private String nome; //ok
    private String telefone; //ok
    private int cpf; //ok
    private String placa; //ok
    private String habilitacao;//ok
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
    }

	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
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
	public void setHabilitacao(String habilitacao) {
		this.habilitacao = habilitacao;
    }
    
}
