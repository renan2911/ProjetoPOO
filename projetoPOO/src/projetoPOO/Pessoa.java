package projetoPOO;

public class Pessoa{
	protected String nome; 
	private String codigo;
	private String email;
	Endereco endereco;
	
	//Sobrecarga
	public Pessoa(String nome, String codigo, String email) {
		this.nome = nome;
		this.codigo = codigo;
		this.email = email;
	}
	//Sobrecarga
	public Pessoa(){
        nome = null;
        codigo = null;
        email = null;
    }
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	//Sobrescrita
	public String gerarCodigo() {
      return null;
    }
	//Polimorfismo
	public String informacao() {
		return "\nNome: "+getNome()+"\nCodigo: "+gerarCodigo()+ "\nE-mail: "+getEmail();	
	}
}
