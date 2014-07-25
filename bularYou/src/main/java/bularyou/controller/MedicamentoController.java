package bularyou.controller;

import java.util.List;

import bularyou.business.MedicamentoServico;
import bularyou.domain.Medicamento;
import bularyou.domain.Usuario;
import bularyou.exception.BusinessException;

/**
 * Controlador de Medicamento.
 * 
 * @author fausto
 *
 */
public class MedicamentoController {

	private MedicamentoServico servico;

	public MedicamentoController(Usuario usuario, boolean arquivo) {
		this.servico = new MedicamentoServico(usuario, arquivo);
	}
	
	/**
	 * Salva um medicamento.
	 * 
	 * @param medicamento
	 */
	public void salvar(Medicamento medicamento) {
		try {
			servico.salvar(medicamento);
		} catch (BusinessException exception) {
			System.out.println(exception.getMessage());
		}
	}

	/**
	 * Remove um medicamento.
	 * 
	 * @param medicamento
	 */
	public void remover(Medicamento medicamento) {
		try {
			this.servico.removerMedicamento(medicamento);
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Lista um medicamento.
	 * 
	 * @return  List<Medicamento>
	 */
	public List<Medicamento> listarMedicamentos() {
		return this.servico.listarMedicamentos();
	}

}
