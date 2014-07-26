package bularyou.controller;

import java.util.List;

import bularyou.business.MedicamentoServico;
import bularyou.domain.Medicamento;
import bularyou.domain.Usuario;
import bularyou.exception.BusinessException;
import bularyou.util.Mensagens;

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
			System.out.println(Mensagens.MEDICAMENTO_CADASTRO_SUCESSO);
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
			System.out.println(Mensagens.MEDICAMENTO_REMOCAO_SUCESSO);
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
	
	/**
	 * Pesquisa um medicamento por ID.
	 * 
	 * @param usuario
	 * @param criterio
	 * @return
	 */
	public Medicamento pesquisar(Medicamento medicamento, String criterio) {
		Medicamento encontrado = null;

		try {
			encontrado = servico.pesquisar(medicamento, criterio);
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}

		return encontrado;
	}

}
