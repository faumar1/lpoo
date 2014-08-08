package bularyou.domain;

import java.io.Serializable;

import bularyou.util.Constantes;

/**
 * Entidade PessoaJuridica.
 * 
 * @author Fausto Sousa
 *
 */
public class PessoaJuridica extends Pessoa implements Serializable {

	private static final long serialVersionUID = -1465251821503037719L;
	private String nomeFantasia;
	private String cnpj;
	private String inscricaoEstadual;

	/**
	 * Construtor da classe PessoaJuridica
	 * 
	 * @param razaoSocial
	 * @param nomeFantasia
	 * @param cnpj
	 * @param inscricaoEstadual
	 */
	public PessoaJuridica(String razaoSocial, String nomeFantasia, String cnpj,
			String inscricaoEstadual) {
		super(razaoSocial);
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		this.inscricaoEstadual = inscricaoEstadual;
	}

	/**
	 * Construtor da classe PessoaJuridica
	 * 
	 */
	public PessoaJuridica() {
		this.nomeFantasia = Constantes.NAO_INFORMADO;
		this.cnpj = Constantes.NAO_INFORMADO;
		this.inscricaoEstadual = Constantes.NAO_INFORMADO;
	}

	public PessoaJuridica(String nomeFantasia) {
		this(Constantes.NAO_INFORMADO, Constantes.NAO_INFORMADO,
				Constantes.NAO_INFORMADO, nomeFantasia);
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	/**
	 * Reescrita do mï¿½todo toString.
	 * 
	 */
	@Override
	public String toString() {
		return "Razão Social: " + this.getNome() + " - Fantasia: "
				+ this.nomeFantasia + " - CNPJ: " + this.cnpj
				+ " - Inscrição Estadual: " + this.inscricaoEstadual;
	}

}
