package bularyou.business;

import java.util.List;

import bularyou.domain.Medicamento;
import bularyou.domain.Usuario;
import bularyou.exception.BusinessException;
import bularyou.interfaces.Entidade;
import bularyou.util.Mensagens;

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
	@SuppressWarnings("unchecked")
	public  List<Medicamento>listarMedicamentos() {
		return (List<Medicamento>) this.listarTodos();
	}
	
	/**
	 * Lista um medicamento.
	 * 
	 * @param medicamento
	 * @param criterio
	 */
	public Medicamento listarCategoria(Medicamento medicamento, String criterio) {
		Entidade resultado = this.pesquisar(medicamento, criterio);
		
		if (resultado == null) {
			throw new BusinessException(Mensagens.REGISTRO_NAO_ENCONTRADO);
		}

		return (Medicamento) resultado;
	}
}
