package projetoPOO;

public class Endereco {
	private String cep;
	private	String bairro;
	private	String complemento;
	private int numero;
	
	
	public Endereco() {
		cep = null;
		bairro = null;
		complemento = null;
		numero = 0;
	}
	
	public Endereco(String cep, String bairro, String complemento, int numero) {
		this.cep = cep;
		this.bairro = bairro;
		this.complemento = complemento;
		this.numero = numero;
	}
	
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
	
}
