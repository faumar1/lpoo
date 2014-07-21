package bularyou.controller;

import java.util.List;

import bularyou.business.UsuarioServico;
import bularyou.domain.Usuario;
import bularyou.exception.BusinessException;

public class UsuarioController {

	private UsuarioServico servico;

	public UsuarioController(Usuario usuario, boolean arquivo) {
		this.servico = new UsuarioServico(usuario, arquivo);
	}

	public static Usuario autenticar(String login, String senha, boolean arquivo) {
		Usuario autenticado = null;
		try {
			autenticado = UsuarioServico.autenticar(login, senha, arquivo);
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		return autenticado;
	}

	public void salvar(Usuario usuario) {
		try {
			servico.salvar(usuario);
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
	}

	public Usuario pesquisar(Usuario usuario, String criterio) {
		Usuario encontrado = null;

		try {
			encontrado = servico.pesquisar(usuario, criterio);
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}

		return encontrado;
	}

	public List<Usuario> listarUsuarios() {
		return this.servico.listarUsuarios();
	}

	public void remover(Usuario usuario) {
		try {
			this.servico.removerUsuario(usuario);
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
	}
}
