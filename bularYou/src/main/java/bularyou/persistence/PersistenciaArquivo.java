package bularyou.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import bularyou.interfaces.Entidade;
import bularyou.interfaces.PersistenciaDao;
import bularyou.util.Constantes;

public class PersistenciaArquivo implements PersistenciaDao {

	private Map<String, Entidade> lista;
	private Class<? extends Entidade> classe;

	public PersistenciaArquivo(Class<? extends Entidade> classe) {
		this.classe = classe;
		this.lista = new HashMap<String, Entidade>();
		carregarDados();
	}

	/**
	 * Salva ou atualiza uma entidade.
	 * 
	 * @param entidade
	 */
	public void salvar(Entidade entidade) {
		this.lista.put(entidade.getId(), entidade);
		commit();
	}

	/**
	 * Remove uma entidade.
	 * 
	 * @param entidade
	 */
	public Boolean remover(Entidade entidade) {
		if(this.lista.remove(entidade.getId()) != null) {
			commit();
			return true;
		}
		return false;
	}

	/**
	 * Lista todas as entidades cadastrados
	 */
	public Collection<? extends Entidade> listarTodos() {
		return this.lista.values();
	}

	/**
	 * Lista uma entidade de acordo com um critério.
	 * 
	 * @param entidade
	 * @param criterio
	 */
	public Entidade listar(Entidade entidade, String criterio) {

		switch (criterio) {
		case Constantes.CRITERIO_ID:
			return this.lista.get(entidade.getId());
		default:
			return null;
		}
	}
	
	private String getNomeArquivoBD() {
		return "arquivo" + classe.getSimpleName() + "s.bd";
	}
	
	@SuppressWarnings("unchecked")
	private void carregarDados() {
		ObjectInputStream is;
		try {
			File arquivo = new File(getNomeArquivoBD());
			if(arquivo.exists()) {
				is = new ObjectInputStream(new FileInputStream(arquivo));
				this.lista = (Map<String, Entidade>) is.readObject();
				is.close();
			}
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Problemas no acesso ao arquivo " + e.getMessage());
		} 
		
	}
	
	private void commit() {

		try {
			ObjectOutputStream os = new ObjectOutputStream(
					new FileOutputStream(new File(getNomeArquivoBD()))); 
			os.writeObject(lista);
			os.close();
			
		} catch (IOException e1) {
			System.out.println("Problemas no acesso ao arquivo " + e1.getMessage());
		} 
		
	}
	
}
