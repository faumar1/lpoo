package bularyou.exception;

/**
 * Classe de exceção.
 * 
 * @author gustavo
 *
 */
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Construtor.
	 * 
	 * @param mensagem
	 */
	public BusinessException(String mensagem) {
		super(mensagem);
	}
}
