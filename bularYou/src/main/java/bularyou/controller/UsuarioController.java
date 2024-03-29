package bularyou.controller;

import java.util.List;

import bularyou.business.UsuarioServico;
import bularyou.domain.Usuario;
import bularyou.exception.BusinessException;
import bularyou.security.Papel;
import bularyou.util.Mensagens;

/**
 * Controller de usu�rio.
 * 
 * @author gustavo
 *
 */
public class UsuarioController {

	private UsuarioServico servico;

	public UsuarioController(Usuario usuario, boolean arquivo) {
		this.servico = new UsuarioServico(usuario, arquivo);
	}
	
	public UsuarioController(boolean arquivo) {
		Usuario superUser = new Usuario("superUser");
		superUser.setPapel(Papel.ADMINISTRADOR);
		this.servico = new UsuarioServico(superUser, arquivo);
	}

	/**
	 * Autentica um usu�rio no sistema.
	 * 
	 * @param login
	 * @param senha
	 * @param arquivo
	 * @return Usuario
	 */
	public Usuario autenticar(String login, String senha) {
		Usuario autenticado = null;
		try {
			autenticado = servico.autenticar(login, senha);
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		return autenticado;
	}

	/**
	 * Cadastra um usu�rio.
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
	 * Pesquisa um usu�rio.
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
	 * Lista todos os usu�rios cadastrados.
	 * 
	 * @return List<Usuario>
	 */
	public List<Usuario> listarUsuarios() {
		return this.servico.listarUsuarios();
	}

	/**
	 * Remove um usu�rio.
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
	
	public void setUsuarioPermissao(Usuario usuario) {
		servico.setUsuarioPermissao(usuario);
	}
}
