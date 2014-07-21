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
	private static List<Usuario> cadastrados;

	/**
	 * Construtor.
	 * 
	 * @param usuario
	 */
	public UsuarioServico(Usuario usuario, boolean arquivo) {
		super(usuario, arquivo);
	}

	/**
	 * Autenticar um Usuário
	 */
	public static Usuario autenticar(String login, String senha, boolean arquivo) {
		if (arquivo) {
			return autenticarArquivo(login, senha);
		} else {
			inicializarUsuariosVolateis();
			return autenticarVolatil(login, senha);
		}
	}

	private static Usuario autenticarArquivo(String login, String senha) {
		return null;
	}

	private static void inicializarUsuariosVolateis() {
		cadastrados = new ArrayList<>();

		Usuario admin = new Usuario("admin", "321", "Administrador",
				Papel.ADMINISTRADOR);
		Usuario usuario = new Usuario("neymarjr", "123", "Neymar",
				Papel.USUARIO);

		cadastrados.add(admin);
		cadastrados.add(usuario);
	}

	private static Usuario autenticarVolatil(String login, String senha) {
		Usuario logar = new Usuario(login, senha);
		Usuario logado = null;

		if (cadastrados.contains(logar)) {
			int index = cadastrados.indexOf(logar);
			logado = cadastrados.get(index);
		} else {
			throw new BusinessException(Mensagens.USUARIO_INEXISTENTE);
		}

		return logado;
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
		case Constantes.CRITEIRO_ID:
			usuarios.sort(Comparator.comparing(Usuario::getId));
			break;
		case Constantes.CRITEIRO_NOME:
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
