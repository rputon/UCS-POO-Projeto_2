package br.ucs.poo.cinema.main;
import br.ucs.poo.cinema.cinema.Cinema;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Cinema cine = new Cinema();

		/*----------------------Usuário/Dispositivo------------------------ */
		String[] vetor = { "admin", "selfService", "rh" };
		List<String> usuarios = Arrays.asList(vetor);
		String user = "";
		do {
			System.out.println("Digite o usuário: ");
			user = Help.returnString(in, user);
		} while (!usuarios.contains(user));

		/*-------------------------Interfaces------------------------------ */
		int opcao;
		if (user.equals(usuarios.get(0))) {
			System.out.println("Acessando com usuário de administrador...");

			do {
				System.out.println("\nEscolhe uma das opções: ");
				System.out.println("1 - Venda de ingresso");
				System.out.println("2 - Consultar filmes");
				System.out.println("3 - Cadastrar filmes");
				System.out.println("Digite 0 para cancelar");
				opcao = in.nextInt();

				switch (opcao) {
					case 1:

						break;

					case 2:

						break;

					case 3:

						break;

					default:
						System.out.println("Esta opção não existe");
				}
			} while (opcao != 0);
		} else if (user.equals(usuarios.get(1))) {
			System.out.println("Acessando com usuário de auto atendimento...");

			do{
			System.out.println("Os seguintes filmes estão em exibição: ");
			for ( int i =0; i<cine.getFilmeList(); i ++){
				System.out.println(cine.getFilme(i));
			}
			// TODO: exibir lista de filmes em cartaz
			System.out.println("Qual filme deseja ver?");
			System.out.println("Digite 0 para cancelar");
			opcao = in.nextInt();
			
			} while (opcao != 0);

		} else if (user.equals(usuarios.get(2))) {
			System.out.println("Acessando com usuário de recursos humanos...");

			System.out.println("\nEscolhe uma das opções: ");
			System.out.println("1 - Configurar preço dos ingressos");
			System.out.println("Digite 0 para cancelar");
			opcao = in.nextInt();

			do{
				switch (opcao) {
					case 1:

						break;

					case 2:

						break;

					case 3:

						break;

					default:
						System.out.println("Esta opção não existe");
				}
			} while (opcao != 0);
		}

	}
}
