package bularyou.security;

/**
 * Enum que gerencia os possíveis papéis de usuários no sistema.
 * 
 * @author gustavo
 *
 */
public enum Papel {
	ADMINISTRADOR(1), USUARIO(0);

	private int tipoPerfil;

	Papel(int tipoPerfil) {
		this.tipoPerfil = tipoPerfil;
	}

	public int getPerfil() {
		return this.tipoPerfil;
	}

}
