package bularyou.view;

import java.util.List;
import java.util.Scanner;

import bularyou.controller.MedicamentoController;
import bularyou.controller.TerminalController;
import bularyou.controller.UsuarioController;
import bularyou.domain.Medicamento;
import bularyou.domain.PessoaJuridica;
import bularyou.domain.Usuario;
import bularyou.security.Papel;
import bularyou.util.Constantes;
import bularyou.util.Mensagens;

/**
 * Camada de visão que inicia a aplicação.
 * 
 * @author gustavo, fausto, alisson
 *
 */
public class Startup {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		TerminalController controlador = new TerminalController();
		controlador.escolherTipoArmazenamento(entrada);

		Usuario logado = null;

		do {
			System.out.println(Mensagens.MENSAGEM_LOGIN);
			String loginUser = entrada.next();

			System.out.println(Mensagens.MENSAGEM_SENHA);
			String senhaUser = entrada.next();

			logado = UsuarioController.autenticar(loginUser, senhaUser,
					controlador.isArquivo());

		} while (logado == null);

		UsuarioController usuarioControlador = new UsuarioController(logado,
				controlador.isArquivo());

		MedicamentoController medicamentoController = new MedicamentoController(
				logado, controlador.isArquivo());

		String opcaoPrincipal = Constantes.VALOR_OPCAO_DEFAULT;
		String opcaoMedicamento = Constantes.VALOR_OPCAO_DEFAULT;

		do {
			Terminal.menuPrincipal();
			opcaoPrincipal = entrada.next();

			switch (opcaoPrincipal) {
			case "1":
				Terminal.genericoMenu();
				String opcaoUsuario = entrada.next();

				if (opcaoUsuario.equals("1")) {
					System.out.println(Mensagens.INPUT_LOGIN);
					String login = entrada.next();

					System.out.println(Mensagens.INPUT_SENHA);
					String senha = entrada.next();

					System.out.println(Mensagens.INPUT_NOME);
					String nome = entrada.next();

					usuarioControlador.salvar(new Usuario(login, senha, nome,
							Papel.USUARIO));

				} else if (opcaoUsuario.equals("2")) {
					System.out.println(Mensagens.INPUT_PESQUISAR_NOME);
					String pesquisar = entrada.next();

					System.out.println(usuarioControlador.pesquisar(
							new Usuario(pesquisar), Constantes.CRITERIO_ID));
				} else if (opcaoUsuario.equals("3")) {
					
					List<Usuario> usuarios = usuarioControlador
							.listarUsuarios();
					usuarios.forEach(System.out::println);

				} else if (opcaoUsuario.equals("4")) {
					System.out.println(Mensagens.INPUT_ATUALIZAR_USUARIO);
					String pesquisar = entrada.next();

					Usuario atualizar = usuarioControlador.pesquisar(new Usuario(
							pesquisar), Constantes.CRITERIO_ID);
							
					if(atualizar != null) {
						System.out.println(Mensagens.MENSAGEM_SENHA_NOVA);
						String senha = entrada.next();
						
						System.out.println(Mensagens.INPUT_NOVO_NOME);
						String nome = entrada.next();
						
						atualizar.setNome(nome);
						atualizar.setSenha(senha);
						
						usuarioControlador.salvar(atualizar);
					}
					
				} else if (opcaoUsuario.equals("5")) {
					System.out.println(Mensagens.INPUT_REMOVER_NOME);
					String pesquisar = entrada.next();

					Usuario remover = usuarioControlador.pesquisar(new Usuario(
							pesquisar), Constantes.CRITERIO_ID);

					usuarioControlador.remover(remover);
				} else {
					System.out.println(Mensagens.MSG_INVALIDA);
				}

				break;

			case "2":
				Terminal.menuMedicamento();
				opcaoMedicamento = entrada.next();

				if (opcaoMedicamento.equals("1")) {

					System.out.println(Mensagens.COD_MEDICAMENTO);
					String id = entrada.next();

					System.out.println(Mensagens.NOME_MEDICAMENTO);
					String nome = entrada.next();

					System.out.println(Mensagens.DESCRICAO_MEDICAMENTO);
					String descricao = entrada.next();

					System.out
							.println(Mensagens.VALOR_COMPRA_MEDICAMENTO);
					Double valorCompra = Double.parseDouble(entrada.next());

					System.out
							.println(Mensagens.VALOR_VENDA_MEDICAMENTO);
					Double valorVenda = Double.parseDouble(entrada.next());

					System.out.println(Mensagens.FABRICANTE_MEDICAMENTO);
					String fabricante = entrada.next();

					System.out.println(Mensagens.FLAG_RECEITA_MEDICAMENTO);
					String receita = entrada.next();
					boolean necessitaReceita = false;

					if (receita.equals("S")) {
						necessitaReceita = true;
					}

					System.out.println(Mensagens.TIPO_RECEITA_MEDICAMENTO);
					String tipoReceita = entrada.next();

					System.out
							.println(Mensagens.INTERACAO_MEDICAMENTO);
					String interacao = entrada.next();

					System.out.println(Mensagens.POSOLOGIA_MEDICAMENTO);
					String posologia = entrada.next();

					System.out.println(Mensagens.PRINCIPIOS_ATIVOS_MEDICAMENTO);
					String principiosAtivo = entrada.next();

					System.out.println(Mensagens.INDICACAO_MEDICAMENTO);
					String indicacoes = entrada.next();

					System.out.println(Mensagens.CLASSES_TERAPEUTICAS_MEDICAMENTO);
					String classesTerapeuticas = entrada.next();

					System.out.println(Mensagens.CATEGORIAS_MEDICAMENTO);
					String categorias = entrada.next();

					medicamentoController.salvar(new Medicamento(id, nome,
							descricao, valorCompra, valorVenda,
							new PessoaJuridica(fabricante), necessitaReceita,
							tipoReceita, interacao, posologia, principiosAtivo,
							indicacoes, classesTerapeuticas, categorias));

				} else if(opcaoMedicamento.equals("2")) {
					
					System.out.println(Mensagens.MEDICAMENTO_PESQUISAR_ID);
					String idMedicamento = entrada.next();
					Medicamento temp = medicamentoController.pesquisar(
							new Medicamento(idMedicamento), Constantes.CRITERIO_ID);
					if(temp != null) {
						System.out.println(temp);
					}
					
				} else if(opcaoMedicamento.equals("3")) {
					
					System.out.println(Mensagens.MEDICAMENTO_PESQUISAR_NOME);
					String nomeMedicamento = entrada.next();
					Medicamento temp = new Medicamento("pesquisa");
					temp.setNome(nomeMedicamento);
					temp = medicamentoController.pesquisar(temp, 
							Constantes.CRITERIO_NOME);
					if(temp != null) {
						System.out.println(temp);
					}

				} else if(opcaoMedicamento.equals("4")) {
					
					List<Medicamento> medicamentos = 
							medicamentoController.listarMedicamentos();
					medicamentos.forEach(System.out::println);
					
				} else if(opcaoMedicamento.equals("5")) {
					
					System.out.println(Mensagens.MEDICAMENTO_PESQUISAR_ID);
					String idMedicamento = entrada.next();
					Medicamento medicamentoAtualizar = medicamentoController.pesquisar(
							new Medicamento(idMedicamento), Constantes.CRITERIO_ID);
					
					if(medicamentoAtualizar != null) {

						System.out.println(Mensagens.NOME_MEDICAMENTO);
						String nome = entrada.next();

						System.out.println(Mensagens.DESCRICAO_MEDICAMENTO);
						String descricao = entrada.next();

						System.out
								.println(Mensagens.VALOR_COMPRA_MEDICAMENTO);
						Double valorCompra = Double.parseDouble(entrada.next());

						System.out
								.println(Mensagens.VALOR_VENDA_MEDICAMENTO);
						Double valorVenda = Double.parseDouble(entrada.next());

						System.out.println(Mensagens.FABRICANTE_MEDICAMENTO);
						String fabricante = entrada.next();

						System.out.println(Mensagens.FLAG_RECEITA_MEDICAMENTO);
						String receita = entrada.next();
						boolean necessitaReceita = false;

						if (receita.equals("S")) {
							necessitaReceita = true;
						}

						System.out.println(Mensagens.TIPO_RECEITA_MEDICAMENTO);
						String tipoReceita = entrada.next();

						System.out
								.println(Mensagens.INTERACAO_MEDICAMENTO);
						String interacao = entrada.next();

						System.out.println(Mensagens.POSOLOGIA_MEDICAMENTO);
						String posologia = entrada.next();

						System.out.println(Mensagens.PRINCIPIOS_ATIVOS_MEDICAMENTO);
						String principiosAtivo = entrada.next();

						System.out.println(Mensagens.INDICACAO_MEDICAMENTO);
						String indicacoes = entrada.next();

						System.out.println(Mensagens.CLASSES_TERAPEUTICAS_MEDICAMENTO);
						String classesTerapeuticas = entrada.next();

						System.out.println(Mensagens.CATEGORIAS_MEDICAMENTO);
						String categorias = entrada.next();
						
						medicamentoController.salvar(new Medicamento(medicamentoAtualizar.getId(), 
								nome, descricao, valorCompra, valorVenda,
								new PessoaJuridica(fabricante), necessitaReceita,
								tipoReceita, interacao, posologia, principiosAtivo,
								indicacoes, classesTerapeuticas, categorias));
					}
					
				} else if(opcaoMedicamento.equals("6")) {
					System.out.println(Mensagens.INPUT_REMOVER_MEDICAMENTO_ID);
					String idMedicamento = entrada.next();
					medicamentoController.remover(new Medicamento(idMedicamento));
				}

				break;
			}

		} while (!opcaoPrincipal.equals("0"));
		System.out.println(Mensagens.LOGOFF);
	}
}
