package bularyou.domain;

import bularyou.interfaces.Entidade;
import bularyou.util.Constantes;

/**
 * Entidade Produto
 * 
 * @author Fausto Sousa, Alisson Sena
 */
public abstract class Produto implements Entidade {
	
	protected String id;
	protected String nome;
	protected String descricao;
	protected Double valorCompra;
	protected Double valorVenda;
	protected PessoaJuridica fabricante;
	
	/**
	 * Construtor da classe Produto
	 * 
	 * @param nome
	 * @param descricao
	 * @param valorCompra
	 * @param valorVenda
	 * @param fabricante
	 */
	public Produto(String id, String nome, String descricao, Double valorCompra, 
			Double valorVenda, PessoaJuridica fabricante) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.valorCompra = valorCompra;
		this.valorVenda = valorVenda;
		this.fabricante = fabricante;		
	}
	
	/**
	 * Construtor da classe Produto
	 * 
	 */
	public Produto(String id) {
		this(id, Constantes.NAO_INFORMADO, Constantes.NAO_INFORMADO, 0.0, 0.0, new PessoaJuridica());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(Double valorCompra) {
		this.valorCompra = valorCompra;
	}

	public Double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public PessoaJuridica getFabricante() {
		return fabricante;
	}

	public void setFabricante(PessoaJuridica fabricante) {
		this.fabricante = fabricante;
	}

	/**
	 * Reescrita do método toString.
	 * 
	 */
	@Override
	public String toString() {
		return "Produto - Nome: " + this.nome + " - Descrição: " + this.descricao
				+ " - Valor de Compra: " + this.valorCompra
				+ " - Valor de Venda: " + this.valorVenda
				+ " - Fabricante: " + this.fabricante.toString();
	}

	/**
	 * Implementação da interface Entidade.
	 * 
	 */
	@Override
	public String getId() {
		return this.id;
	}
	
}
