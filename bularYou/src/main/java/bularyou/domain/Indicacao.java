package bularyou.domain;

import bularyou.interfaces.Entidade;

/**
 * Entidade Indicacao.
 * 
 * @author Fausto Sousa
 *
 */
public class Indicacao implements Entidade{
	
	private String id;
	private String indicacao;
	
	/**
	 * Construtor da classe Indicacao
	 * 
	 */
	public Indicacao() {
		this.indicacao = "N�o especificada";
	}

	/**
	 * Construtor da classe Indicacao
	 * 
	 * @param indicacao
	 */
	public Indicacao(String indicacao) {
		this.indicacao = indicacao;
	}
	
	public String getIndicacao() {
		return indicacao;
	}

	public void setIndicacao(String indicacao) {
		this.indicacao = indicacao;
	}

	/**
	 * Reescrita do m�todo toString.
	 * 
	 */
	@Override
	public String toString() {
		return "Indicacao: " + this.indicacao;
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
