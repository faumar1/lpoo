package bularyou.view;

public class Terminal {
	
	public static void menuPrincipal() {
		System.out.println("Informe uma das opções abaixo:");
		System.out.println("1 - Usuários");
		System.out.println("2 - Medicamentos");
	}
	
	public static void genericoMenu() {
		System.out.println("1 - Novo");
		System.out.println("2 - Pesquisar pelo login");
		System.out.println("3 - Listar todos");
		System.out.println("4 - Remover");
	}

	public static void menuMedicamento() {
		System.out.println("1 - Novo");
		System.out.println("2 - Pesquisar");
		System.out.println("3 - Listar todos");
		System.out.println("4 - Remover");
		System.out.println("5 - Fabricante");
	}

	public static void menuFabricante() {
		System.out.println("1 - Novo");
		System.out.println("2 - Listar todos");
	}
}
