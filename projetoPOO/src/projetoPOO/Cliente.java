package projetoPOO;

public class Cliente extends Pessoa{
	
	private String CPF;
	private String data_Nascimento;
	RepoClient repoClient;
	
	
	//Sobrecarga
	public Cliente(String nome, String CPF, String codigo, String email, Endereco endereco, String data_Nascimento,String senha) {
		super(nome, codigo, email);
		this.CPF = CPF; 
		this.endereco = endereco;
		this.data_Nascimento = data_Nascimento;
	}
	//Sobrecarga
	public Cliente() {
		super();
		CPF = null; 
		endereco = null;
		data_Nascimento = null;
		
	}
	
	
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String CPF) {
		this.CPF = CPF;
	}
	public String getData_Nascimento() {
		return data_Nascimento;
	}
	public void setData_Nascimento(String data_Nascimento) {
		this.data_Nascimento = data_Nascimento;
	}
	
	// SOBRESCRITA
	public String gerarCodigo() {
        return CPF.substring (CPF.length() - 4);
    }

	public String informacao() {
		return super.informacao()+"\nCPF: "+ getCPF()+"\nData de Nascimento: "+getData_Nascimento();
	}
}
