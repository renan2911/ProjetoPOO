package projetoPOO;

public class RepositorioCliente implements RepoClient{
	Cliente [] clientes;
	
	public RepositorioCliente() {
		clientes = new Cliente [100];
	}
	
	//--------------------------------------------------------------------------------------#INSERIR CLIENTE#------------------------------------------------------------------------------------------------------------------------------------------------
		public boolean inserirCliente(Cliente c){
			if(c == null) {
				return false;
			}
			for(int i = 0; i < clientes.length; i++) {
				if(clientes[i] != null && (clientes[i].getCPF().equals(c.getCPF())  || clientes[i].gerarCodigo() == c.gerarCodigo())) {
					
					return false;
				}
			}
			for(int i = 0; i < clientes.length; i++) {
				if(clientes[i] == null) {
					clientes[i] = c;
					return true;
				}
			}
			return false;
			
	}
		//---------------------------------------------------------------------------------------#BUSCAR CLIENTE PELO CPF#-----------------------------------------------------------------------------------------------------------------------------------------
		public Cliente buscarClientePorCPF(String cpf) {
			for(int i = 0; i < clientes.length; i++) {
				if(clientes[i] != null && clientes[i].getCPF().equals(cpf)) {
					return clientes[i];
				}
			}
			return null;
		}
		//---------------------------------------------------------------------------------------#BUSCAR CLIENTE POR CODIGO#-----------------------------------------------------------------------------------------------------------------------------------------
		public Cliente buscarClientePorCodigo(String codigo) {
			for(int i = 0; i < clientes.length; i++) {
				if(clientes[i] != null && clientes[i].gerarCodigo().equals(codigo)) {
					return clientes[i];
				}
			}
			return null;
		}
		//----------------------------------------Remover Cliente pelo CPF-----------------------------------------//
		public boolean removerClienteCPF(String CPF) {
			for(int i = 0; i < clientes.length; i++) {
				if(clientes[i] != null && clientes[i].getCPF().equals(CPF)) {
					clientes[i] = null;
					return true;
				}
			}
			return false;	
		}
		//----------------------------------------Remover Cliente pelo CÓDIGO-----------------------------------------//
		public boolean removerClienteCodigo(String codigo) {
			for(int i = 0; i < clientes.length; i++) {
				if(clientes[i] != null && clientes[i].gerarCodigo().equals(codigo)) {
					clientes[i] = null;
					return true;
				}
			}
			return false;	
		}
		
		//---------------------------------------------------------------------------------------#Relatóro CLIENTE#----------------------------------------------------------------------------------------------------------------------------------------
		public Cliente[] relatorioClientes() {
			Cliente[] result = null;
			int contador = 0;
			
			for(int i = 0; i < clientes.length; i++) {
				if(clientes[i] != null) {
					contador++;
				}
			}
			if(contador > 0) {
				result = new Cliente[contador];
				
				int aux = 0;
				
				for(int i = 0; i < clientes.length; i++) {
					if(clientes[i] != null) {
						result[aux] = clientes[i];
						aux++;
					}
				}
			}
			return result;
		}
		//---------------------------------------------------------------------------------------#BUSCAR CLIENTE POR BAIRRO#----------------------------------------------------------------------------------------------------------------------------------------
		public Cliente[] buscarClientesPorBairro(String bairro) {
			Cliente[] result = null;
			int contador = 0;
			
			for(int i = 0; i < clientes.length; i++) {
				if(clientes[i] != null && clientes[i].getEndereco() != null && clientes[i].getEndereco().getBairro().equalsIgnoreCase(bairro)) {
					contador++;
				}
			}
			if(contador > 0) {
				result = new Cliente[contador];
				
				int aux = 0;
				
				for(int i = 0; i < clientes.length; i++) {
					if(clientes[i] != null && clientes[i].getEndereco() != null && clientes[i].getEndereco().getBairro().equalsIgnoreCase(bairro)) {
						result[aux] = clientes[i];
						aux++;
					}
				}
			}
			return result;
		}
}
