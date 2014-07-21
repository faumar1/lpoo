package bularyou.domain;

import bularyou.interfaces.Entidade;

/**
 * Entidade ClasseTerapeutica.
 * 
 * @author Fausto Sousa
 *
 */
public class ClasseTerapeutica implements Entidade {

	private String id;
	private String classeTerapeutica;

	/**
	 * Construtor da classe ClasseTerapeutica
	 * 
	 */
	public ClasseTerapeutica() {
		this.classeTerapeutica = "N�o especificada";
	}

	/**
	 * Construtor da classe ClasseTerapeutica
	 * 
	 * @param classeTerapeutica
	 */
	public ClasseTerapeutica(String classeTerapeutica) {
		this.classeTerapeutica = classeTerapeutica;
	}

	public String getClasseTerapeutica() {
		return classeTerapeutica;
	}

	public void setClasseTerapeutica(String classeTerapeutica) {
		this.classeTerapeutica = classeTerapeutica;
	}

	/**
	 * Reescrita do m�todo toString.
	 * 
	 */
	@Override
	public String toString() {
		return "Classe terapeutica: " + this.classeTerapeutica;
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
