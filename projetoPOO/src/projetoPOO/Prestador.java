package projetoPOO;

public class Prestador extends Pessoa{
	private String CNPJ;
	private String tipo_Servico;
	private double preco;
	private String contato;
	RepoPrest repoprest;
	
	//Sobrecarga
	public Prestador(String nome, String CNPJ, String servico, double preco, String contato, Endereco endereco, String email, String codigo, String senha) {
		super(nome, codigo, email);
		this.CNPJ = CNPJ;
		tipo_Servico = servico;
		this.preco = preco;
		this.contato = contato;
		this.endereco =  endereco;
	}
	//Sobrecarga
	public Prestador() {
		super();
		CNPJ = null;
		tipo_Servico = null;
		preco = 0.0;
		contato = null;
		endereco = null;
	}
	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String CNPJ) {
		this.CNPJ = CNPJ;
	}
	public String getTipo_Servico() {
		return tipo_Servico;
	}
	public void setTipo_Servico(String tipo_Servico) {
		this.tipo_Servico = tipo_Servico;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	
	
	// SOBRESCRITA
	public String gerarCodigo() {
        return CNPJ.substring (CNPJ.length() - 4);
    }

	public String informacao() {
		return super.informacao()+"\nCnpj: "+gerarCodigo()+"\nTipo de serviço: "+getTipo_Servico()+"\nValor: "+getPreco()+"\nContato: "+getContato();
	}
}
