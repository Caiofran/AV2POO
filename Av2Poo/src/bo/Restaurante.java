package bo;

public class Restaurante {
	private String nome;
    private String endereco;
    private String telefone;
    private String culinaria;
	private int codigo;
	
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
    
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
    }
    
    public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
    }
    
    public String getCulinaria() {
		return culinaria;
	}
	public void setCulinaria(String culinaria) {
		this.culinaria = culinaria;
    }
   
}
