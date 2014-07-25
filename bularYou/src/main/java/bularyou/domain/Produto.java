package bularyou.domain;

import bularyou.interfaces.Entidade;
import bularyou.util.Constantes;

/**
 * Entidade Produto
 * 
 * @author Fausto Sousa
 */
public class Produto implements Entidade {
	
	private String id;
	private String nome;
	private String descricao;
	private Double valorCompra;
	private Double valorVenda;
	private PessoaJuridica fabricante;
	
	/**
	 * Construtor da classe Produto
	 * 
	 * @param nome
	 * @param descricao
	 * @param valorCompra
	 * @param valorVenda
	 * @param fabricante
	 */
	public Produto(String nome, String descricao, Double valorCompra, 
			Double valorVenda, PessoaJuridica fabricante) {
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
	public Produto() {
		this.nome = Constantes.NAO_INFORMADO;
		this.descricao = Constantes.NAO_INFORMADO;
		this.valorCompra = 0.0;
		this.valorVenda = 0.0;
		this.fabricante = new PessoaJuridica();
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
	 * Reescrita do m�todo toString.
	 * 
	 */
	@Override
	public String toString() {
		return "Produto - Nome: " + this.nome + " - Descri��o: " + this.descricao
				+ " - Valor de Compra: " + this.valorCompra
				+ " - Valor de Venda: " + this.valorVenda
				+ " - Fabricante: " + this.fabricante.toString();
	}

	/**
	 * Implementa��o da interface Entidade.
	 * 
	 */
	@Override
	public String getId() {
		return this.id;
	}
	
}
