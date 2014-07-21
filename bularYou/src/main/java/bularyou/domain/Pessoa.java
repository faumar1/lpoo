package bularyou.domain;

import bularyou.interfaces.Entidade;

/**
 * Entidade Pessoa.
 * 
 * @author Fausto Sousa
 *
 */
public class Pessoa implements Entidade {

	private String id;
	private String nome;
	private Endereco endereco;

	/**
	 * Construtor da classe Pessoa
	 * 
	 * @param endereco
	 * @param cidade
	 */
	public Pessoa(String nome, Endereco endereco) {
		this.nome = nome;
		this.endereco = endereco;
	}

	/**
	 * Construtor da classe Pessoa
	 * 
	 */
	public Pessoa() {
		this.nome = "N�o Especificado";
		this.endereco = new Endereco();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	/**
	 * Implementa��o da interface Entidade.
	 * 
	 */
	@Override
	public String getId() {
		return this.id;
	}
}
