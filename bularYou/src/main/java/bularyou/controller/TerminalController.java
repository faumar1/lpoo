package bularyou.controller;

import java.util.Scanner;

import bularyou.util.Mensagens;

public class TerminalController {

	private boolean isArquivo;

	public void escolherTipoArmazenamento(Scanner entrada) {
		String opcao;

		do {
			System.out.println(Mensagens.ESCOLHER_ARMAZENAMENTO);
			opcao = entrada.next();

			if (opcao.equalsIgnoreCase("s") || opcao.equalsIgnoreCase("n")) {
				if (opcao.equals("s")) {
					this.isArquivo = true;
				}
			} else {
				System.out.println("Opção inválida!");
			}

		} while (!(opcao.equalsIgnoreCase("S") || opcao.equalsIgnoreCase("N")));
	}

	public boolean isArquivo() {
		return this.isArquivo;
	}
}
