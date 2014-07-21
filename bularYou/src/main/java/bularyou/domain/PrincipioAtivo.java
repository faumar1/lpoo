package bularyou.domain;

import bularyou.interfaces.Entidade;

/**
 * Entidade Princ�pioAtivo.
 * 
 * @author Fausto Sousa
 *
 */
public class PrincipioAtivo implements Entidade {

	private String id;
	private String principioAtivo;

	/**
	 * Construtor da classe PrincipioAtivo
	 * 
	 */
	public PrincipioAtivo() {
		this.principioAtivo = "N�o especificado";
	}

	/**
	 * Construtor da classe PrincipioAtivo
	 * 
	 * @param principioAtivo
	 */
	public PrincipioAtivo(String principioAtivo) {
		this.principioAtivo = principioAtivo;
	}

	public String getPrincipioAtivo() {
		return principioAtivo;
	}

	public void setPrincipioAtivo(String principioAtivo) {
		this.principioAtivo = principioAtivo;
	}

	/**
	 * Reescrita do m�todo toString.
	 * 
	 */
	@Override
	public String toString() {
		return "Principio ativo: " + this.principioAtivo;
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
