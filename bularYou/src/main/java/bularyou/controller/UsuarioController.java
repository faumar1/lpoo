package bularyou.controller;

import java.util.List;

import bularyou.business.UsuarioServico;
import bularyou.domain.Usuario;
import bularyou.exception.BusinessException;
import bularyou.util.Mensagens;

/**
 * Controller de usuário.
 * 
 * @author gustavo
 *
 */
public class UsuarioController {

	private UsuarioServico servico;

	public UsuarioController(Usuario usuario, boolean arquivo) {
		this.servico = new UsuarioServico(usuario, arquivo);
	}

	/**
	 * Autentica um usuário no sistema.
	 * 
	 * @param login
	 * @param senha
	 * @param arquivo
	 * @return Usuario
	 */
	public static Usuario autenticar(String login, String senha, boolean arquivo) {
		Usuario autenticado = null;
		try {
			autenticado = UsuarioServico.autenticar(login, senha, arquivo);
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		return autenticado;
	}

	/**
	 * Cadastra um usuário.
	 * 
	 * @param usuario
	 */
	public void salvar(Usuario usuario) {
		try {
			servico.salvar(usuario);
			System.out.println(Mensagens.USUARIO_CADASTRO_SUCESSO);
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Pesquisa um usuário.
	 * 
	 * @param usuario
	 * @param criterio
	 * @return
	 */
	public Usuario pesquisar(Usuario usuario, String criterio) {
		Usuario encontrado = null;

		try {
			encontrado = servico.pesquisar(usuario, criterio);
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}

		return encontrado;
	}

	/**
	 * Lista todos os usuários cadastrados.
	 * 
	 * @return List<Usuario>
	 */
	public List<Usuario> listarUsuarios() {
		return this.servico.listarUsuarios();
	}

	/**
	 * Remove um usuário.
	 * 
	 * @param usuario
	 */
	public void remover(Usuario usuario) {
		try {
			this.servico.removerUsuario(usuario);
			System.out.println(Mensagens.USUARIO_REMOCAO_SUCESSO);
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
	}
}
