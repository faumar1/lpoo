package bularyou.domain;

import bularyou.util.Constantes;

/**
 * Entidade Medicamento.
 * 
 * @author Fausto Sousa
 *
 */
public class Medicamento extends Produto {

	private boolean necessitaReceita;
	private String tipoReceita;
	private String interacao;
	private String posologia;
	private String principiosAtivo;
	private String indicacoes;
	private String classesTerapeuticas;
	private String categorias;

	/**
	 * Construtor da classe Medicamento
	 * 
	 */
	public Medicamento() {
		super();
		this.necessitaReceita = false;
		this.tipoReceita = Constantes.NAO_INFORMADO;
		this.posologia = Constantes.NAO_INFORMADO;
		this.principiosAtivo = Constantes.NAO_INFORMADO;
		this.indicacoes = Constantes.NAO_INFORMADO;
		this.classesTerapeuticas = Constantes.NAO_INFORMADO;
		this.categorias = Constantes.NAO_INFORMADO;
	}

	/**
	 * Construtor da classe Medicamento
	 * 
	 * @param necessitaReceita
	 * @param tipoReceita
	 * @param interacao
	 * @param posologia
	 * @param principiosAtivo
	 * @param indicacoes
	 * @param classesTerapeuticas
	 * @param categorias
	 * 
	 */
	public Medicamento(String id, String nome, String descricao,
			Double valorCompra, Double valorVenda, PessoaJuridica fabricante,
			boolean necessitaReceita, String tipoReceita, String interacao,
			String posologia, String principiosAtivo, String indicacoes,
			String classesTerapeuticas, String categorias) {

		super(nome, descricao, valorCompra, valorVenda, fabricante);
		this.necessitaReceita = necessitaReceita;
		this.tipoReceita = tipoReceita;
		this.interacao = interacao;
		this.posologia = posologia;
		this.principiosAtivo = principiosAtivo;
		this.indicacoes = indicacoes;
		this.classesTerapeuticas = classesTerapeuticas;
		this.categorias = categorias;
	}

	public boolean isNecessitaReceita() {
		return necessitaReceita;
	}

	public void setNecessitaReceita(boolean necessitaReceita) {
		this.necessitaReceita = necessitaReceita;
	}

	public String getTipoReceita() {
		return tipoReceita;
	}

	public void setTipoReceita(String tipoReceita) {
		this.tipoReceita = tipoReceita;
	}

	public String getInteracao() {
		return interacao;
	}

	public void setInteracao(String interacao) {
		this.interacao = interacao;
	}

	public String getPosologia() {
		return posologia;
	}

	public void setPosologia(String posologia) {
		this.posologia = posologia;
	}

	public String getPrincipiosAtivo() {
		return principiosAtivo;
	}

	public void setPrincipiosAtivo(String principiosAtivo) {
		this.principiosAtivo = principiosAtivo;
	}

	public String getIndicacoes() {
		return indicacoes;
	}

	public void setIndicacoes(String indicacoes) {
		this.indicacoes = indicacoes;
	}

	public String getClassesTerapeuticas() {
		return classesTerapeuticas;
	}

	public void setClassesTerapeuticas(String classesTerapeuticas) {
		this.classesTerapeuticas = classesTerapeuticas;
	}

	public String getCategorias() {
		return categorias;
	}

	public void setCategorias(String categorias) {
		this.categorias = categorias;
	}

	/**
	 * Reescrita do m�todo toString.
	 * 
	 */
	@Override
	public String toString() {

		String principiosAtivo = "";
		String indicacoes = "";
		String classesTerapeuticas = "";
		String categorias = "";
		String receita = "N�o";

		if (isNecessitaReceita()) {
			receita = "Sim";
		}

		return "Nome " + this.getNome() + " - Descri��o: "
				+ this.getDescricao() + " - Valor de Compra: "
				+ this.getValorCompra() + " - Valor de Venda: "
				+ this.getValorVenda() + " - Fabricante: "
				+ this.getFabricante().toString()
				+ " - Necessita de Receita?: " + receita
				+ " - Tipo da Receita: " + this.tipoReceita
				+ " - Intera��o: " + this.interacao + " - Posologia: "
				+ this.posologia + " - Princ�pio(s) ativo: "
				+ principiosAtivo + " - Indica��es: " + indicacoes
				+ " - Classe(s) Terapeutica(s): " + classesTerapeuticas
				+ " - Categorias: " + categorias;
	}

}
