package bularyou.view;

public class Terminal {
	
	public static void menuPrincipal() {
		System.out.println("Informe uma das op��es abaixo:");
		System.out.println("1 - Usu�rios");
		System.out.println("2 - Medicamentos");
	}
	
	public static void genericoMenu() {
		System.out.println("1 - Novo");
		System.out.println("2 - Pesquisar pelo login");
		System.out.println("3 - Listar todos");
		System.out.println("4 - Atualizar dados");
		System.out.println("5 - Remover");
	}

	public static void menuMedicamento() {
		System.out.println("1 - Novo");
		System.out.println("2 - Pesquisar por ID");
		System.out.println("3 - Pesquisar por Nome");
		System.out.println("4 - Listar todos");
		System.out.println("5 - Atualizar medicamento");
		System.out.println("6 - Remover");
		/*System.out.println("5 - Fabricante");*/
	}

	public static void menuFabricante() {
		System.out.println("1 - Novo");
		System.out.println("2 - Listar todos");
	}
}
