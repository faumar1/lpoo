package bularyou.domain;

import bularyou.interfaces.Entidade;

/**
 * Entidade Endereco.
 * 
 * @author Fausto Sousa
 *
 */
public class Endereco implements Entidade{
	
	private String id;
	private String endereco;
	private String cidade;
	private String estado;
	private String cep;
	
	/**
	 * Construtor da classe Endereco
	 * 
	 */
	public Endereco() {
		this.endereco = "N�o especificado";
		this.cidade = "N�o especificada";
		this.estado = "N�o especificado";
		this.cep = "N�o especificado";
	}
	
	/**
	 * Construtor da classe Endereco
	 * 
	 * @param endereco
	 * @param cidade
	 * @param valorCompra
	 * @param valorVenda
	 * @param fabricante
	 */
	public Endereco(String endereco, String cidade, String estado, String cep) {
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	/**
	 * Reescrita do m�todo toString.
	 * 
	 */
	@Override
	public String toString() {
		return "Endere�o: " + this.endereco + " - Cidade: " + this.cidade
				+ " - Estado: " + this.estado + " - CEP: " + this.cep;
	}
	
	/**
	 * Implementa��o da interface Entidade
	 * 
	 */
	@Override
	public String getId() {		
		return this.id;
	}
	
}
