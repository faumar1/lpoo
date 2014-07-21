package bularyou.domain;

import java.util.ArrayList;
import java.util.List;

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
	private List<PrincipioAtivo> principiosAtivo;
	private List<Indicacao> indicacoes;
	private List<ClasseTerapeutica> classesTerapeuticas;
	private List<Categoria> categorias;	
	
	/**
	 * Construtor da classe Medicamento
	 * 
	 */
	public Medicamento(){
		super();
		this.necessitaReceita = false;
		this.tipoReceita = "N�o especificada";
		this.posologia = "N�o especificda";
		this.principiosAtivo = new ArrayList<PrincipioAtivo>();
		this.principiosAtivo.add(new PrincipioAtivo());
		this.indicacoes = new ArrayList<Indicacao>();
		this.indicacoes.add(new Indicacao());
		this.classesTerapeuticas = new ArrayList<ClasseTerapeutica>();
		this.classesTerapeuticas.add(new ClasseTerapeutica());
		this.categorias = new ArrayList<Categoria>();
		this.categorias.add(new Categoria());
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
	public Medicamento(String nome, String descricao, Double valorCompra, 
			Double valorVenda, PessoaJuridica fabricante, boolean necessitaReceita,
			String tipoReceita, String interacao, String posologia, 
			List<PrincipioAtivo> principiosAtivo, List<Indicacao> indicacoes,
			List<ClasseTerapeutica> classesTerapeuticas, List<Categoria> categorias) {
		
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

	public List<PrincipioAtivo> getPrincipiosAtivo() {
		return principiosAtivo;
	}

	public void setPrincipiosAtivo(List<PrincipioAtivo> principiosAtivo) {
		this.principiosAtivo = principiosAtivo;
	}

	public List<Indicacao> getIndicacoes() {
		return indicacoes;
	}

	public void setIndicacoes(List<Indicacao> indicacoes) {
		this.indicacoes = indicacoes;
	}

	public List<ClasseTerapeutica> getClassesTerapeuticas() {
		return classesTerapeuticas;
	}

	public void setClassesTerapeuticas(List<ClasseTerapeutica> classesTerapeuticas) {
		this.classesTerapeuticas = classesTerapeuticas;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
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
		String classesTerapeuticas= "";
		String categorias = "";
		String receita = "N�o";
		
		if(isNecessitaReceita()) {
			receita = "Sim";
		}
		
		for(PrincipioAtivo principioAtivo: this.principiosAtivo) {
			principiosAtivo = principiosAtivo + principioAtivo.getPrincipioAtivo() + "\n";
		}
		
		for(Indicacao indicacao: this.indicacoes) {
			indicacoes = indicacoes + indicacao.getIndicacao() + "\n";
		}

		for(ClasseTerapeutica classeTerapeutica: this.classesTerapeuticas) {
			classesTerapeuticas = classesTerapeuticas + classeTerapeutica.getClasseTerapeutica() + "\n";
		}

		for(Categoria categoria: this.categorias) {
			categorias = categorias + categoria.getCategoria() + "\n";
		}

		return "Nome " + this.getNome() + " - Descri��o: " + this.getDescricao()
				+ " - Valor de Compra: " + this.getValorCompra() 
				+ " - Valor de Venda: " + this.getValorVenda()
				+ " - Fabricante: " + this.getFabricante().toString()
				+ " - Necessita de Receita?: " + receita
				+ " - Tipo da Receita: " + this.tipoReceita
				+ " - Intera��o: " + this.interacao
				+ " - Posologia: " + this.posologia
				+ " - Princ�pio(s) ativo: " + principiosAtivo
				+ " - Indica��es: " + indicacoes
				+ " - Classe(s) Terapeutica(s): " + classesTerapeuticas
				+ " - Categorias: " + categorias;
	}
	
}
