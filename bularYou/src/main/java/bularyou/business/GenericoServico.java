package bularyou.business;

import java.util.Collection;

import bularyou.domain.Usuario;
import bularyou.exception.BusinessException;
import bularyou.interfaces.Entidade;
import bularyou.interfaces.PersistenciaDao;
import bularyou.persistence.GenericoPersistencia;
import bularyou.persistence.PersistenciaArquivo;
import bularyou.util.Mensagens;

/**
 * Template que disponibiliza os principais comportamentos dos serviços.
 * 
 * @author gustavo
 *
 */
public abstract class GenericoServico {
	private Usuario usuario;
	private PersistenciaDao persistencia;

	public GenericoServico(Usuario usuario, boolean arquivo) {
		this.usuario = usuario;

		if (arquivo) {
			this.persistencia = new PersistenciaArquivo();
		} else {
			this.persistencia = new GenericoPersistencia();
		}
	}

	/**
	 * Salva ou atualiza uma entidade.
	 * 
	 * @param entidade
	 */
	public void salvar(Entidade entidade) {
		UsuarioServico.usuarioServicoPermissao(this.usuario);
		this.persistencia.salvar(entidade);
	}

	/**
	 * Remove uma entidade.
	 * 
	 * @param entidade
	 */
	public Boolean remover(Entidade entidade) {
		UsuarioServico.usuarioServicoPermissao(this.usuario);
		return this.persistencia.remover(entidade);
	}

	/**
	 * Lista todas as entidades cadastrados
	 */
	public Collection<? extends Entidade> listarTodos() {
		return this.persistencia.listarTodos();
	}

	/**
	 * Lista uma entidade de acordo com um critério.
	 * 
	 * @param entidade
	 * @param criterio
	 */
	public Entidade pesquisar(Entidade entidade, String criterio) {
		Entidade resultado = this.persistencia.listar(entidade, criterio);

		if (resultado == null) {
			throw new BusinessException(Mensagens.REGISTRO_NAO_ENCONTRADO);
		}

		return resultado;
	}
}
