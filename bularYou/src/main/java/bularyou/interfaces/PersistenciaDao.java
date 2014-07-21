package bularyou.interfaces;

import java.util.Collection;

public interface PersistenciaDao {

	void salvar(Entidade entidade);

	Boolean remover(Entidade entidade);

	Collection<? extends Entidade> listarTodos();

	Entidade listar(Entidade entidade, String criterio);
}
