package projetoPOO;

public interface RepoClient{
	public boolean inserirCliente(Cliente c);
	public Cliente buscarClientePorCPF(String CPF);
	public Cliente buscarClientePorCodigo(String codigo);
	public boolean removerClienteCPF(String cpf);
	public boolean removerClienteCodigo(String codigo);
	public Cliente[] relatorioClientes();
	public Cliente[] buscarClientesPorBairro(String bairro);
}
