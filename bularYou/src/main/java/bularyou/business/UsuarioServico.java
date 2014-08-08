package bularyou.business;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import bularyou.domain.Usuario;
import bularyou.exception.BusinessException;
import bularyou.interfaces.Entidade;
import bularyou.security.Papel;
import bularyou.util.Constantes;
import bularyou.util.Mensagens;

/**
 * Classe de serviço para a entidade usuário.
 * 
 * @author gustavo
 *
 */
public class UsuarioServico extends GenericoServico {

	/**
	 * Construtor.
	 * 
	 * @param usuario
	 */
	public UsuarioServico(Usuario usuario, boolean arquivo) {
		super(usuario, arquivo, Usuario.class);
	}

	/**
	 * Autentica um Usuário no sistema.
	 */
	public Usuario autenticar(String login, String senha) 
			throws BusinessException{
		
		List<Usuario> usuarios = listarUsuarios();
		if(usuarios == null || usuarios.isEmpty()) {
			inicializarUsuariosVolateis();
		}
		return autenticarUsuario(login, senha);
	}

	private void inicializarUsuariosVolateis() {
		Usuario admin = new Usuario("admin", "321", "Administrador",
				Papel.ADMINISTRADOR);
		Usuario usuario = new Usuario("neymarjr", "123", "Neymar",
				Papel.USUARIO);

		salvarUsuario(admin);
		salvarUsuario(usuario);
	}

	private Usuario autenticarUsuario(String login, String senha) {
		Usuario logar = new Usuario(login, senha);
		Usuario logado = null;

		try {
			logado = this.pesquisar(logar, "id");
			return logado;
		} catch (BusinessException e) {
			throw new BusinessException(Mensagens.USUARIO_INEXISTENTE);
		}
	}

	/**
	 * Salva um usuário.
	 * 
	 * @param usuario
	 */
	public void salvarUsuario(Usuario usuario) {
		this.salvar(usuario);
	}

	/**
	 * Remove um usuário.
	 * 
	 * @param usuario
	 */
	public void removerUsuario(Usuario usuario) {
		if (!this.remover(usuario)) {
			throw new BusinessException(Mensagens.USUARIO_INEXISTENTE);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Usuario> listarUsuarios() {
		List<Usuario> usuarios = new ArrayList(this.listarTodos());
		return usuarios;
	}

	/**
	 * Lista os usuários ordenados por um determinado critério.
	 * 
	 * @param criterio
	 * @return List<Usuario>
	 */
	public List<Usuario> listarUsuariosOrdenadosPor(String criterio) {
		List<Usuario> usuarios = this.listarUsuarios();

		switch (criterio) {
		case Constantes.CRITERIO_ID:
			usuarios.sort(Comparator.comparing(Usuario::getId));
			break;
		case Constantes.CRITERIO_NOME:
			usuarios.sort(Comparator.comparing(Usuario::getNome));
			break;
		}

		return usuarios;
	}

	/**
	 * Verifica se o usuário possui papel de adminsitrador.
	 */
	public static void usuarioServicoPermissao(Usuario usuario) {
		if (!usuario.isAdministrador()) {
			throw new BusinessException(Mensagens.PERMISSAO_NEGADA);
		}
	}

	/**
	 * Lista uma entidade de acordo com um critério.
	 * 
	 * @param entidade
	 * @param criterio
	 */
	public Usuario pesquisar(Entidade entidade, String criterio) {
		Entidade resultado = super.pesquisar(entidade, criterio);

		if (resultado == null) {
			throw new BusinessException(Mensagens.REGISTRO_NAO_ENCONTRADO);
		}

		return (Usuario) resultado;
	}
}
