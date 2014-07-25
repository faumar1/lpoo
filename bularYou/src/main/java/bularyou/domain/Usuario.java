package bularyou.domain;

import bularyou.interfaces.Entidade;
import bularyou.security.Papel;
import bularyou.util.Constantes;

/**
 * Entidade Usuário.
 * 
 * @author gustavo
 *
 */
public class Usuario implements Entidade {

	private String login;
	private String senha;
	private String nome;
	private Papel papel;

	/**
	 * Construtor da classe usuário.
	 * 
	 * @param login
	 * @param senha
	 * @param nome
	 * @param papel
	 */
	public Usuario(String login, String senha, String nome, Papel papel) {
		this.login = login.toLowerCase();
		this.senha = senha;
		this.nome = nome;
		this.papel = papel;
	}

	/**
	 * Construtor da classe usuário.
	 * 
	 * @param login
	 * @param senha
	 */
	public Usuario(String login, String senha) {
		this(login, senha, Constantes.NAO_INFORMADO, Papel.USUARIO);
	}

	public Usuario(String login) {
		this(login, "", "", Papel.USUARIO);
	}

	/**
	 * Define o login do usuário.
	 * 
	 * @param login
	 */
	public void setLogin(String login) {
		this.login = login.toLowerCase();
	}

	/**
	 * Retorna o valor do login do usuário.
	 * 
	 * @return String
	 */
	public String getLogin() {
		return this.login;
	}

	/**
	 * Define a senha do usuário.
	 * 
	 * @param senha
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * Retorna o valor da senha do usuário.
	 * 
	 * @return String
	 */
	public String getSenha() {
		return this.senha;
	}

	/**
	 * Define o nome do usuário.
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna o nome do usuário.
	 * 
	 * @return String
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Define o papel do usuário.
	 * 
	 * @param papel
	 */
	public void setPapel(Papel papel) {
		this.papel = papel;
	}

	/**
	 * Retorna o papel do usuário.
	 * 
	 * @return Papel
	 */
	public Papel getPapel() {
		return this.papel;
	}

	/**
	 * Verifica se o usuário é um administrador.
	 * 
	 * @return Boolean
	 */
	public Boolean isAdministrador() {
		return (this.papel.getPerfil() == Papel.ADMINISTRADOR.getPerfil()) ? true
				: false;

	}

	/**
	 * Reescrita do método equals.
	 * 
	 */
	@Override
	public boolean equals(Object usuario) {
		if (usuario instanceof Usuario
				&& ((Usuario) usuario).getLogin().equals(this.login)
				&& ((Usuario) usuario).getSenha().equals(this.senha)) {
			return true;
		}

		return false;
	}

	/**
	 * Reescrita do método toString.
	 * 
	 */
	@Override
	public String toString() {
		return "Usuário - Nome: " + this.nome + "\n - Login: " + this.login
				+ "\n - Senha: " + this.senha + "\n - Perfil: "
				+ this.papel.name();
	}

	/**
	 * Implementação da interface Entidade.
	 * 
	 */
	public String getId() {
		return this.login;
	}
}
