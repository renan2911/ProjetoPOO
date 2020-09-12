package projetoPOO;

public class RepositorioPrestador implements RepoPrest{
	private Prestador [] prestador;
	
	public RepositorioPrestador(){
		prestador = new Prestador[100];
	}
	
	
	//----------------------------------------------------------------------------------------------------#INSERIR PRESTADOR#-----------------------------------------------------------------------------------------------------------------------//
		public boolean inserirPrestador(Prestador p) {
			if(p == null) {
				return false;
			}
			for(int i = 0; i < prestador.length; i++) {
				if(prestador[i] != null && prestador[i].getCNPJ().equals(p.getCNPJ())) {
					return false;
				}
			}
			
			for(int i = 0; i < prestador.length;i++) {
				if(prestador[i] == null) {
					prestador[i] = p;
					return true;
				}
			}
			return false;
		}
		
	//-------------------------------------------------------------------------------------------------#REMOVER PRESTADOR PELO CNPJ#--------------------------------------------------------------------------------------------------------------------------------------------//
		public boolean removerPrestadorCnpj(String CNPJ) {
			for(int i = 0; i < prestador.length; i++) {
				if(prestador[i] != null && prestador[i].getCNPJ().equals(CNPJ)) {
					prestador[i] = null;
					return true;
				}
			}
			return false;	
		}
		
	//-------------------------------------------------------------------------------------------------#REMOVER PRESTADOR POR CÓDIGO#---------------------------------------------------------------------------------------------------------------------------------------------//
		public boolean removerPrestadorCodigo(String codigo) {
			for(int i = 0; i < prestador.length; i++) {
				if(prestador[i] != null && prestador[i].gerarCodigo().equals(codigo)) {
					prestador[i] = null;
					return true;
				}
			}
			return false;
		}
	//------------------------------------------------------------------------------------------------#PESQUISAR POR CNPJ#-------------------------------------------------------------------------------------------------------------------------------------------------------------//
		public Prestador pesquisarPorCNPJ(String CNPJ) {
			for(int i = 0; i < prestador.length; i++) {
				if(prestador[i]!=null && prestador[i].getCNPJ().equals(CNPJ)) {
					return prestador[i];
				}
			}
			return null;
			
		}
	//------------------------------------------------------------------------------------------------#PESQUISAR POR CÓDIGO#-------------------------------------------------------------------------------------------------------------------------------------------------------------//
		public Prestador pesquisaPorCodigo(String codigo) {
			for(int i = 0; i < prestador.length; i++) {
				if(prestador[i]!=null && prestador[i].gerarCodigo().equals(codigo)) {
					return prestador[i];
				}
			}
			return null;
		}
		//------------------------------------------------------------------------------------------------#RELATÓRIO PRESTADOR#------------------------------------------------------------------------------------------------------------------------------------------------------------
		public Prestador [] relatorioPrestadores() {
			Prestador [] resultado = null;
			int contador = 0;
			
			for(int i = 0; i < prestador.length; i++) {
				if(prestador[i] != null ) {
					contador++;
				}
			}
			if(contador > 0) {
				resultado = new Prestador[contador];
				int aux = 0;
				
				for(int i = 0; i < prestador.length; i++) {
					if(prestador[i] != null ){
						resultado[aux] = prestador[i];
						aux++;
					}
				}
			}
			return resultado;
			
			
		}
		//------------------------------------------------------------------------------------------------#PESQUISAR PRESTADOR PELO CEP#------------------------------------------------------------------------------------------------------------------------------------------------------------
		public Prestador[] relatorioPrestadorPorCep(String cep) {
			Prestador [] resultado = null;
			int contador = 0;
			
			for(int i = 0; i < prestador.length; i++) {
				if(prestador[i] != null && prestador[i].getEndereco()!= null && prestador[i].getEndereco().getCep().equals(cep)) {
					contador++;
				}
			}
			if(contador > 0) {
				resultado = new Prestador[contador];
				int aux = 0;
				
				for(int i = 0; i < prestador.length; i++) {
					if(prestador[i] != null && prestador[i].getEndereco() != null && prestador[i].getEndereco().getCep().equals(cep)){
						resultado[aux] = prestador[i];
						aux++;
					}
				}
			}
			return resultado;
			
			
		}
		//------------------------------------------------------------------------------------------------#PESQUISAR POR TIPO DE SERVIÇO#-------------------------------------------------------------------------------------------------------------------------------------------------------------
		/*public Prestador pesquisarPorTipoDeServico(String tipo_de_servico) {
			for(int i = 0; i < prestador.length; i++) {
				if(prestador[i]!=null && prestador[i].getTipo_Servico().equals(tipo_de_servico)) {
					return prestador[i];
				}
			}
			return null;
			
		}*/
}
