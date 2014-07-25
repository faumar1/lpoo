package bularyou.domain;

import bularyou.interfaces.Entidade;
import bularyou.util.Constantes;

/**
 * Entidade Pessoa.
 * 
 * @author Fausto Sousa
 *
 */
public class Pessoa implements Entidade {

	private String id;
	private String nome;

	/**
	 * Construtor da classe Pessoa
	 * 
	 * @param endereco
	 * @param cidade
	 */
	public Pessoa(String nome) {
		this.nome = nome;
	}

	/**
	 * Construtor da classe Pessoa
	 * 
	 */
	public Pessoa() {
		this.nome = Constantes.NAO_INFORMADO;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
