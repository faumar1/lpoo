package bularyou.domain;

/**
 * Entidade PessoaJuridica.
 * 
 * @author Fausto Sousa
 *
 */
public class PessoaJuridica extends Pessoa {

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
			String inscricaoEstadual, Endereco endereco) {		
		super(razaoSocial, endereco);
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		this.inscricaoEstadual = inscricaoEstadual;
	}

	/**
	 * Construtor da classe PessoaJuridica
	 * 
	 */
	public PessoaJuridica() {		
		super();
		this.nomeFantasia = "N�o especificado";
		this.cnpj = "N�o especificado";
		this.inscricaoEstadual = "N�o especificada";
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
	 * Reescrita do m�todo toString.
	 * 
	 */
	@Override
	public String toString() {
		return "Raz�o Social: " + this.getNome() + " - Fantasia: "
				+ this.nomeFantasia + " - CNPJ: " + this.cnpj
				+ " - Inscri��o Estadual: " + this.inscricaoEstadual
				+ " - Endereco: " + getEndereco().toString();
	}
	
}
