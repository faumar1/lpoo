package bularyou.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bularyou.controller.FabricanteController;
import bularyou.controller.MedicamentoController;
import bularyou.controller.TerminalController;
import bularyou.controller.UsuarioController;
import bularyou.domain.Fabricante;
import bularyou.domain.Medicamento;
import bularyou.domain.Usuario;
import bularyou.security.Papel;
import bularyou.util.Constantes;
import bularyou.util.Mensagens;

/**
 * Classe que inicia a aplicaÃ§Ã£o.
 * 
 * @author gustavo
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

		MedicamentoController medicamentoController = new 
				MedicamentoController(logado, controlador.isArquivo());
		
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
					System.out.println("Informe o seu login:");
					String login = entrada.next();

					System.out.println("Informe a sua senha:");
					String senha = entrada.next();

					System.out.println("Informe o seu nome:");
					String nome = entrada.next();

					usuarioControlador.salvar(new Usuario(login, senha, nome,
							Papel.USUARIO));

				} else if (opcaoUsuario.equals("2")) {
					System.out.println("Informe o login que deseja pesquisar:");
					String pesquisar = entrada.next();

					System.out.println(usuarioControlador.pesquisar(
							new Usuario(pesquisar), Constantes.CRITEIRO_ID));
				} else if (opcaoUsuario.equals("3")) {
					List<Usuario> usuarios = usuarioControlador
							.listarUsuarios();
					usuarios.forEach(System.out::println);

				} else if (opcaoUsuario.equals("4")) {
					System.out
							.println("Informe o login do usuÃ¡rio que deseja remover:");
					String pesquisar = entrada.next();

					Usuario remover = usuarioControlador.pesquisar(new Usuario(
							pesquisar), Constantes.CRITEIRO_ID);

					usuarioControlador.remover(remover);
				} else {
					System.out.println("OpÃ§Ã£o InvÃ¡lida!");
				}

				break;

			case "2":
				Terminal.menuMedicamento();
				opcaoMedicamento = entrada.next();

				if(opcaoMedicamento.equals("1")){
					
					System.out.println("Informe o código do medicamento:");
					String id = entrada.next();

					System.out.println("Informe o nome do medicamento:");
					String nome = entrada.next();

					System.out.println("Informe a descrição do medicamento:");
					String descricao = entrada.next();

					System.out.println("Informe o valor de compra do medicamento:");
					Double valorCompra = Double.parseDouble(entrada.next());
					
					System.out.println("Informe o valor de venda do medicamento:");
					Double valorVenda = Double.parseDouble(entrada.next());	
					
					System.out.println("Informa o fabricante:");
					String fabricante = entrada.next();
					
					System.out.println("Necessita de receita? (S/N)");
					String receita = entrada.next();
					boolean necessitaReceita = false;
					
					if(receita.equals("S")) {
						necessitaReceita = true;
					}
					
					System.out.println("Informe o tipo da receita:");
					String tipoReceita = entrada.next();
					
					System.out.println("Informe se exite interação medicamentosa:");
					String interacao = entrada.next();

					System.out.println("Informe a posologia:");
					String posologia = entrada.next();
					
					System.out.println("Informe o(s) principio(s) ativo:");
					String principiosAtivo = entrada.next();
					
					System.out.println("Informe indicação:");
					String indicacoes = entrada.next();

					System.out.println("informe classe(s) terapeutica:");
					String classesTerapeuticas = entrada.next();

					System.out.println("Informe a(s) categoria(s):");
					String categorias = entrada.next();

					medicamentoController.salvar(new Medicamento(id, nome, descricao,
							valorCompra, valorVenda, fabricante, necessitaReceita, tipoReceita,
							interacao, posologia, principiosAtivo, indicacoes, classesTerapeuticas,
							categorias));
					
					List<Medicamento> medicamentos = new ArrayList<Medicamento>();
					medicamentos.add(new Medicamento(id, nome, descricao,
							valorCompra, valorVenda, fabricante, necessitaReceita, tipoReceita,
							interacao, posologia, principiosAtivo, indicacoes, classesTerapeuticas,
							categorias));
					
					medicamentos.forEach(System.out::println);
					
				} 	
			
				break;
			
			}

		} while (!opcaoPrincipal.equals("0"));
		System.out.println("Saindo do sistema");
	}
}
