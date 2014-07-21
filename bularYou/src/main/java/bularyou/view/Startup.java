package bularyou.view;

import java.util.List;
import java.util.Scanner;

import bularyou.controller.TerminalController;
import bularyou.controller.UsuarioController;
import bularyou.domain.Usuario;
import bularyou.security.Papel;
import bularyou.util.Constantes;
import bularyou.util.Mensagens;

/**
 * Classe que inicia a aplicação.
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

		// TODO escrever medicamento controller
		UsuarioController usuarioControlador = new UsuarioController(logado,
				controlador.isArquivo());

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
							.println("Informe o login do usuário que deseja remover:");
					String pesquisar = entrada.next();

					Usuario remover = usuarioControlador.pesquisar(new Usuario(
							pesquisar), Constantes.CRITEIRO_ID);

					usuarioControlador.remover(remover);
				} else {
					System.out.println("Opção Inválida!");
				}

				break;

			case "2":
				Terminal.genericoMenu();
				opcaoMedicamento = entrada.next();

				break;
			}

		} while (!opcaoPrincipal.equals("0"));
		System.out.println("Saindo do sistema");
	}
}
