package bularyou.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Efetua as validações do projeto.
 * 
 * @author gustavo
 *
 */
public class Validador {

	private Validador() {
	}

	/**
	 * Verifica se a senha é alfanumérica e possui 8 caracteres.
	 * 
	 * @param senha
	 * @return boolean
	 */
	public static Boolean validarSenha(String senha) {

		Pattern p = Pattern
				.compile("(?=.*\\d)(?=.*([a-z]|[A-Z]))([\\x20-\\x7E]){8,}");
		Matcher m = p.matcher(senha);

		return m.matches();
	}
}
