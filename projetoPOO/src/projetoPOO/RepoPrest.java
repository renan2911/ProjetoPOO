package projetoPOO;

public interface RepoPrest {
	 public  boolean inserirPrestador(Prestador prestador);
	 public  boolean removerPrestadorCnpj(String CNPJ);
	 public  boolean removerPrestadorCodigo(String codigo);
	 public  Prestador pesquisarPorCNPJ(String CNPJ);
	 public  Prestador pesquisaPorCodigo(String codigo);
	 public  Prestador[] relatorioPrestadores();
	 public  Prestador[] relatorioPrestadorPorCep(String cep); 
}
