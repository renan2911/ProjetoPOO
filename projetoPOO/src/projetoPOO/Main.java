package projetoPOO;

import java.util.Scanner;

public class Main {
	static Scanner input = new Scanner	(System.in);
	static RepoPrest repositorioPrestador = new RepositorioPrestador();
	static RepoClient repositorioCliente = new RepositorioCliente();
	public static void main(String[] args) {
		int opcao = 0;
		do {
			opcao = exibirMenu();
		}while(opcao != 0);											
		

	}
	/*--Menu--*/
	private static int exibirMenu() {
		int opcao;
			System.out.println("1- Cliente, 2- Prestador de Serviço, 0- Sair");
			opcao = input.nextInt();
			
			switch(opcao) {
				case 0 :
					System.out.println("Obrigado por utilizar nosso sistema!");
					opcao = 0;
					break;
				case 1:
					System.out.println("Menu Cliente \n");
					menuCliente();
					break;
				case 2: 
					System.out.println("\nMenu Prestador de Serviço \n");
					menuPrestador();
					break;
				default:
					System.out.println("Opção Inválida");
					
			}
		return opcao;
	}
	 /*--Menu Prestador--*/
	private static void menuPrestador() {
		int opcao;
		System.out.println("================================================================================================================================================================================================================");
		System.out.println("1- Inserir Prestador de Serviço, 2- Pesquisar Prestador de Serviço pelo CNPJ,\n3- Pesquisar Prestador de Serviço por Código, 4- Remover Prestador de Serviço pelo CNPJ,\n5- Remover Prestador de Serviço pelo Código, 6- Relatório de Prestadores cadastrados,\n7- Relatório de Prestadores Por CEP");
		opcao = input.nextInt();
		
				switch(opcao) {
					case 1:
						System.out.println("\n Inserir Prestador de Serviço \n");
						cadastraPrestador();
						System.out.println("================================================================================================================================================================================================================");
						break;
					case 2:
						System.out.println("\n Pesquisar Prestador de Serviço por CNPJ");
						pesquisarPrestadorCNPJ();
						System.out.println("================================================================================================================================================================================================================");
						break;
					case 3:
						System.out.println("\n Pesquisar Prestador de Serviço por código");
						pesquisarPrestadorCodigo();
						System.out.println("================================================================================================================================================================================================================");
						break;
					case 4:
						System.out.println("\n Remover Prestador de Serviço pelo CNPJ");
						removerPrestadorCNPJ();
						System.out.println("================================================================================================================================================================================================================");
						break;
					case 5:
						System.out.println("\n Remover Prestador de Serviço pelo código");
						removerPrestadorCodigo();
						System.out.println("================================================================================================================================================================================================================");
						break;
					case 6:
						relatorioPrestado();
						break;
					case 7:
						relatorioPrestadorCEP();
						break;
					
					default: 
						System.out.println("\n Opção invalida!");
						System.out.println("================================================================================================================================================================================================================");
			}
	}
	
	private static void removerPrestadorCodigo() {
		System.out.println("Informe o código: ");
		String codigo = input.next();
		
		boolean resultado = repositorioPrestador.removerPrestadorCodigo(codigo);
		
		if(resultado) {
			System.out.println("Prestador removido");
		}else {
			System.out.println("Erro");
		}
	}
	//-------------------------------------------------------------------------------------------#REMOVER PRESTADOR PELO CNPJ#---------------------------------------------------------------------------------------------------------------------------------------------------
	private static void removerPrestadorCNPJ() {
		System.out.println("Informe o CNPJ");
		 String cnpj = input.next();
		 
		 boolean resultado = repositorioPrestador.removerPrestadorCnpj(cnpj);
		 
		 if(resultado) {
			 System.out.println("Prestador removido");
		 }else {
			 System.out.println("Erro");
		 }
		
	}
	//---------------------------------------------------------------------------------------------#PESQUISAR PRESTADOR POR CÓDIGO#-------------------------------------------------------------------------------------------------------------------------------------------------------
	 private static void pesquisarPrestadorCodigo() {
		System.out.println("Informe o Código: ");
		String codigo = input.next();
		
		Prestador p = repositorioPrestador.pesquisaPorCodigo(codigo);
		 if(p != null) {
			 System.out.println("Nome do Fornecedor: "+p.getNome());
		 }else {
			 System.out.println("Não existe fornecedor cadastrado.");
		 }
		
	}
	//------------------------------------------------------------------------------------------------------#PESQUISAR PRESTADOR POR CEP#---------------------------------------------------------------------------------------------------------------------------------------------
	private static void pesquisarPrestadorCNPJ() {
		 System.out.println("Informe o CNPJ: ");
		 String CNPJ = input.next();
		 
		 Prestador p = repositorioPrestador.pesquisarPorCNPJ(CNPJ);
		 if(p != null) {
			 System.out.println("Nome do Fornecedor: "+p.getNome());
			 System.out.println("Tipo de serviço: "+p.getTipo_Servico());
			 System.out.println("Preço: "+p.getPreco());
		 }else {
			 System.out.println("Não existe prestador de serviço cadastrado.");
		 }
		
	}
	//----------------------------------------------------------------------------------------#CADASTRAR PRESTADOR#----------------------------------------------------------------------------------------------------------------------------------------------------
	private static void cadastraPrestador() {
		//Polimorfismo 
		Pessoa p = new Prestador();
		System.out.println("=============================================");
		System.out.println("Cadastrandro um novo Prestador de Serviço");
		System.out.println("=============================================");
		
		System.out.println("Digite o nome: ");
		p.setNome(input.next());
		
		System.out.println("Digite o CNPJ: ");
		((Prestador) p).setCNPJ(input.next());
		
		System.out.println("Informe o tipo de serviço: ");
		((Prestador) p).setTipo_Servico(input.next());
		
		System.out.println("Informe o Preço: ");
		((Prestador) p).setPreco(input.nextDouble());
		
		System.out.println("Digite um número para contato: ");
		((Prestador) p).setContato(input.next());
		
		System.out.println("Codigo gerado: ");
		String codigo = p.gerarCodigo();
		p.setCodigo(codigo);
	    System.out.println(codigo);
		
	    
	    
		System.out.println("=================================");
		System.out.println("Endereço do prestador de Serviço");
		System.out.println("=================================");
		
		Endereco enderecoPrestador = new Endereco();
		
		System.out.println("Informe o CEP: ");
		enderecoPrestador.setCep(input.next());
		
		System.out.println("Informe o bairro: ");
		enderecoPrestador.setBairro(input.next());
		
		System.out.println("Informe o complemento: ");
		enderecoPrestador.setComplemento(input.next());
		
		System.out.println("Informe o número: ");
		enderecoPrestador.setNumero(input.nextInt());
		
		p.setEndereco(enderecoPrestador);
		
		
		boolean resultado = repositorioPrestador.inserirPrestador((Prestador) p);
		
		if(resultado) {
			System.out.println("\n------------------------------------------------");
			System.out.println("Prestador de serviço cadastrado com sucesso!!");
			System.out.println("------------------------------------------------- \n");
		}else {
			System.out.println("Erro no cadastro");
		}
	}
	private static void relatorioPrestado() {
		System.out.println("----------------------------------------------");
		System.out.println("Relatório de todos os Prestadores de Serviços");
		System.out.println("----------------------------------------------\n");
		
		Prestador [] prestador = repositorioPrestador.relatorioPrestadores();
		
		if(prestador != null && prestador.length > 0) {
			for(int i = 0; i < prestador.length; i++) {
				System.out.println("Informações: "+prestador[i].informacao());
				System.out.println("Endereco: ");
				System.out.println("CEP: "+prestador[i].getEndereco().getCep());
				System.out.println("Bairro: "+prestador[i].getEndereco().getBairro());
				System.out.println("Complemento: "+prestador[i].getEndereco().getComplemento());
				System.out.println("Numero: "+prestador[i].getEndereco().getNumero());
			
				
				System.out.println("------------------------------------------------------------\n");
			}
		}
	}
	private static void relatorioPrestadorCEP() {
		 System.out.println("Informe o CEP");
		 String cep = input.next();
		 
		 Prestador[] prestador = repositorioPrestador.relatorioPrestadorPorCep(cep);
		 
		 if(prestador != null && prestador.length > 0) {
			 System.out.println("Fornecedores que se encontram no Cep "+cep);
			 for(int i = 0; i < prestador.length; i++) {
				 if(prestador != null) {
					System.out.println("Informações: "+prestador[i].informacao());
					System.out.println("Endereco: ");
					System.out.println("CEP: "+prestador[i].getEndereco().getCep());
					System.out.println("Bairro: "+prestador[i].getEndereco().getBairro());
					System.out.println("Complemento: "+prestador[i].getEndereco().getComplemento());
					System.out.println("Numero: "+prestador[i].getEndereco().getNumero());
					System.out.println("------------------------------------------------------------\n");
				 }
			 }
		 }else {
			 System.out.println("Não existe fornecedores no CEP: "+cep);
	 }
	}
	 
	 /*--Menu Cliente--*/
	 private static void menuCliente() {
		int opcao; 
		System.out.println("===============================================================================================================================================");
		System.out.println("1- Inserir Cliente, 2- Pesquisar Cliente pelo CPF,\n 3- Pesquisar Cliente por Código, 4- Remover Cliente pelo CPF,\n 5- Remover Cliente pelo Código, 6- Relatório de clientes cadastrados,\n7- Buscar cliente por bairro");
		opcao = input.nextInt();
		System.out.println("===============================================================================================================================================");
		switch(opcao) {
			case 1:
				System.out.println("Inserir Cliente \n");
				cadastraCliente();
				break;
			case 2:
				System.out.println("Pesquisar Cliente por CPF");
				pesquisarClientePorCPF();
				break;
			case 3:
				System.out.println("Pesquisar Cliente por código");
				pesquisarClienteCodigo();
				break;
			case 4:
				System.out.println("Remover cliente pelo CPF");
				removerClienteCPF();
				break;
			case 5:
				System.out.println("Remover cliente pelo código");
				removerClienteCodigo();
				break;
			case 6: 
				relatorioCliente();
				break;
			case 7:
				relatorioClienteBairro();
				break;
			default: 
				System.out.println("Opção invalida!");
		}
	}

	private static void cadastraCliente() {
		//Polimorfismo
		Pessoa c = new Cliente();
		System.out.println("=========================================");
		System.out.println("Cadastrando um novo Cliente");
		System.out.println("=========================================\n");
		System.out.println("Nome: ");
		c.setNome(input.next());
		System.out.println("CPF: ");
		((Cliente) c).setCPF(input.next());
		System.out.println("E-mail: ");
		c.setEmail(input.next());
		System.out.println("Data de nascimentos: ");
		((Cliente) c).setData_Nascimento(input.next());
		
		System.out.println("Codigo gerado: ");
		String codigo = c.gerarCodigo();
		c.setCodigo(codigo);
	    System.out.println(codigo);
		
		Endereco enderecoCliente = new Endereco();
		
		System.out.println("===================================");
		System.out.println("Endereco do cliente");
		System.out.println("===================================\n");
		System.out.println("CEP: ");
		enderecoCliente.setCep(input.next());
		System.out.println("Bairro: ");
		enderecoCliente.setBairro(input.next());
		System.out.println("Complemento: ");
		enderecoCliente.setComplemento(input.next());
		System.out.println("Número: ");
		enderecoCliente.setNumero(input.nextInt());
		
		 c.setEndereco(enderecoCliente);
		
		boolean resultado = repositorioCliente.inserirCliente((Cliente) c);
		
		if(resultado) {
			System.out.println("\nCadastro realizado!!\n");
		}else { 
			System.out.println("Erro no cadastro");
		}
	}
	private static void pesquisarClientePorCPF() {
		System.out.println("Informe o CPF do cliente: ");
		String cpf = input.next();
		
		Cliente c = repositorioCliente.buscarClientePorCPF(cpf);
		
		if(c != null) {
			System.out.println("==========================");
			System.out.println("Nome do cliente: "+c.getNome());
			System.out.println("Código do cliente: "+c.gerarCodigo());
			System.out.println("Email do cliente: "+c.getEmail());
			System.out.println("==========================\n");
		}else {
			System.out.println("Cliente não cadastrado");
		}
	}
	private static void pesquisarClienteCodigo() {
		System.out.println("Informe o código do cliente: ");
		String codigo = input.next();
		
		Cliente c = repositorioCliente.buscarClientePorCodigo(codigo);
		
		if(c != null) {
			System.out.println("Nome do cliente: "+c.getNome());
			System.out.println("Código do cliente: "+c.gerarCodigo());
			System.out.println("Email do cliente: "+c.getEmail());
			
			System.out.println("==========================\n");
		}
	}
	private static void removerClienteCPF() {
		System.out.println("Informe o CPF: ");
		String cpf = input.next();
		
		boolean resultado = repositorioCliente.removerClienteCPF(cpf);
		
		if(resultado) {
			System.out.println("Cliente removido!");
		}else {
			System.out.println("Erro");
		}
	}
	private static void removerClienteCodigo() {
		System.out.println("Informe o Código: ");
		String codigo = input.next();
		
		boolean resultado = repositorioCliente.removerClienteCodigo(codigo);
		
		if(resultado) {
			System.out.println("Cliente removido!");
		}else {
			System.out.println("Erro");
		}
	}
	private static void relatorioCliente() {
		System.out.println("-----------------------------------------");
		System.out.println("Relatório dos clientes Cadastrados");
		System.out.println("-----------------------------------------");
		
		Cliente [] cliente = repositorioCliente.relatorioClientes();
		
		if(cliente != null && cliente.length > 0) {
			for(int i = 0; i < cliente.length; i++) {
				System.out.println("Informações: "+cliente[i].informacao());
				System.out.println("Endereço: ");
				System.out.println("CEP: "+ cliente[i].getEndereco().getCep());
				System.out.println("Bairro: "+cliente[i].getEndereco().getBairro());
				System.out.println("Complemento: "+cliente[i].getEndereco().getComplemento());
				System.out.println("Número: "+ cliente[i].getEndereco().getNumero());
				System.out.println("---------------------------------------------------\n");
			}
		}else {
			System.out.println("Erro");
		}
	}
	private static void relatorioClienteBairro() {
		 System.out.println("Digite o nome do bairro");
		 String bairro = input.next();
		 
		 Cliente[] cliente = repositorioCliente.buscarClientesPorBairro(bairro);
		 
		 if(cliente != null && cliente.length > 0) {
			 System.out.println("\nCliente(s) no bairro: "+ bairro);
			 System.out.println("-------------------------------------------");
			 for(int i = 0; i < cliente.length; i++) {
				 if(cliente[i] != null) {
					System.out.println("Informações: "+cliente[i].informacao());
					System.out.println("Endereço: ");
					System.out.println("CEP: "+ cliente[i].getEndereco().getCep());
					System.out.println("Bairro: "+cliente[i].getEndereco().getBairro());
					System.out.println("Complemento: "+cliente[i].getEndereco().getComplemento());
					System.out.println("Número: "+ cliente[i].getEndereco().getNumero());
				 }			 
			 }
		 }else {
			 System.out.println("Não existem clientes no bairro "+ bairro);
		 }
	}

}
