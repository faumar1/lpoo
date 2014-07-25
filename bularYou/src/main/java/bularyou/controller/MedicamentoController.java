package bularyou.controller;

import java.util.List;

import bularyou.business.MedicamentoServico;
import bularyou.domain.Medicamento;
import bularyou.domain.Usuario;
import bularyou.exception.BusinessException;

public class MedicamentoController {

	private MedicamentoServico servico;
	
	public MedicamentoController(Usuario usuario, boolean arquivo) {
		this.servico = new MedicamentoServico(usuario, arquivo);
	}
	
	
	public void salvar(Medicamento medicamento) {
		try {
			servico.salvar(medicamento);			
		} catch (BusinessException exception) {
			System.out.println(exception.getMessage());
		}
	}
	
	public void remover(Medicamento medicamento) {
		try {
			this.servico.removerMedicamento(medicamento);
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public List<Medicamento> listarMedicamentos() {
		return this.servico.listarMedicamentos();
	}
	
}
