package bularyou.domain;

import bularyou.interfaces.Entidade;

/**
 * Entidade Categoria.
 * 
 * @author Fausto Sousa
 *
 */
public class Categoria implements Entidade {

	private String id;
	private String categoria;

	/**
	 * Construtor da classe Categoria
	 * 
	 */
	public Categoria() {
		this.categoria = "N�o especificada";
	}

	/**
	 * Construtor da classe Categoria
	 * 
	 * @param indicacao
	 */
	public Categoria(String categoria) {
		this.categoria = categoria;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	/**
	 * Reescrita do m�todo toString.
	 * 
	 */
	@Override
	public String toString() {
		return "Categoria: " + this.categoria;
	}

	/**
	 * Implementa��o da interface Entidade.
	 * 
	 */
	public String getId() {
		return this.id;
	}
}
