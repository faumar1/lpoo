package bularyou.persistence;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import bularyou.interfaces.Entidade;
import bularyou.interfaces.PersistenciaDao;
import bularyou.util.Constantes;

public class GenericoPersistencia implements PersistenciaDao {
	private Map<String, Entidade> lista;

	public GenericoPersistencia() {
		this.lista = new HashMap<String, Entidade>();
	}

	/**
	 * Salva ou atualiza uma entidade.
	 * 
	 * @param entidade
	 */
	public void salvar(Entidade entidade) {
		this.lista.put(entidade.getId(), entidade);
	}

	/**
	 * Remove uma entidade.
	 * 
	 * @param entidade
	 */
	public Boolean remover(Entidade entidade) {
		return this.lista.values().remove(entidade);
	}

	/**
	 * Lista todas as entidades cadastrados
	 */
	public Collection<? extends Entidade> listarTodos() {
		return this.lista.values();
	}

	/**
	 * Lista uma entidade de acordo com um critério.
	 * 
	 * @param entidade
	 * @param criterio
	 */
	public Entidade listar(Entidade entidade, String criterio) {

		switch (criterio) {
		case Constantes.CRITEIRO_ID:
			return this.lista.get(entidade.getId());
		default:
			return null;
		}
	}
}
