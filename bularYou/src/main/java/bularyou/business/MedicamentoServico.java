package bularyou.business;

import java.util.ArrayList;
import java.util.List;

import bularyou.domain.Medicamento;
import bularyou.domain.Usuario;
import bularyou.exception.BusinessException;
import bularyou.interfaces.Entidade;
import bularyou.util.Constantes;
import bularyou.util.Mensagens;

/**
 * Regras de negócio de medicamento.
 * 
 * @author fausto
 *
 */
public class MedicamentoServico extends GenericoServico {

	/**
	 * Construtor da Classe MedicamentoServico.
	 * 
	 * @param usuario
	 */
	public MedicamentoServico(Usuario usuario, boolean arquivo) {
		super(usuario, arquivo);
	}

	/**
	 * Salva um medicamento.
	 * 
	 * @param medicamento
	 */
	public void salvarMedicamento(Medicamento medicamento) {
		this.salvar(medicamento);
	}

	/**
	 * Remove um medicamento.
	 * 
	 * @param medicamento
	 */
	public void removerMedicamento(Medicamento medicamento) {
		if (!this.remover(medicamento)) {
			throw new BusinessException(Mensagens.MEDICAMENTO_INEXISTENTE);
		}
	}

	/**
	 * Lista todos os medicamentos.
	 * 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Medicamento> listarMedicamentos() {
		return new ArrayList(this.listarTodos());
	}

	/**
	 * Lista um medicamento.
	 * 
	 * @param medicamento
	 * @param criterio
	 */
	public Medicamento pesquisar(Medicamento medicamento, String criterio) {
		Entidade resultado = null;
		
		switch (criterio) {
		case Constantes.CRITERIO_ID:
			resultado = super.pesquisar(medicamento, criterio);
		case Constantes.CRITERIO_NOME:
			for (Medicamento med : this.listarMedicamentos()) {
				if(med.getNome().contains(medicamento.getNome())) {
					resultado = med;
				}
			}
		}

		if (resultado == null) {
			throw new BusinessException(Mensagens.REGISTRO_NAO_ENCONTRADO);
		}

		return (Medicamento) resultado;
	}
	
}
