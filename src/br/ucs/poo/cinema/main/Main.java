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
			do {
				user = Help.returnString(in, "Digite o usuário: ");
				if (!usuarios.contains(user)) {
					System.out.println("Usuário não encontrado.\n");
				}
			} while (!usuarios.contains(user));

			/*-------------------------Interfaces------------------------------ */
			int opcao;

			if (user.equals(usuarios.get(0))) { // admin
				System.out.println("\nAcessando com usuário de administrador...");

				do {
					System.out.println("\nEscolhe uma das opções: ");
					System.out.println("1 - Venda de ingresso");
					System.out.println("2 - Consultar catálogo de filmes");
					System.out.println("3 - Consultar filmes em cartaz");
					System.out.println("4 - Cadastrar filmes");
					System.out.println("Digite 0 para cancelar");
					opcao = in.nextInt();
					in.nextLine();

					switch (opcao) {
						case 0:
							Help.clearScreen();
							break;
						case 1:

							break;

						case 2:

							break;

						case 3:
							int tam = cine.getFilmeCartazList();
							if (tam > 0) {
								System.out.println("\nOs seguintes filmes estão em exibição: ");
								for (int i = 0; i < tam; i++) {
									System.out.println(cine.getFilmeCartaz(i));
								}
							} else {
								System.out.println("\nNenhum filme em cartaz");
								System.out.println("Adicione um a lista\n");
							}

							System.out.println();
							break;
						case 4:
							String nome, descricao;
							int ano, timeMin, rating;

							nome = Help.returnString(in, "Digite o nome do filme:");
							ano = Help.returnInt(in, "Digite o ano de publicação do filme:");
							timeMin = Help.returnInt(in, "Digite a duração do filme, em minutos: ");
							descricao = Help.returnString(in, "Digite a descrição do filme:");
							rating = Help.returnInt(in, "Digite a classificação indicativa do filme:");

							cine.setFilme(nome, ano, timeMin, descricao, rating);
							break;

						default:
							System.out.println("Esta opção não existe");
					}
				} while (opcao != 0);
			} else if (user.equals(usuarios.get(1))) { // selfService
				System.out.println("\nAcessando com usuário de auto atendimento...");

				do {

					int tam = cine.getFilmeCartazList();
					if (tam > 0) {
						System.out.println("\nOs seguintes filmes estão em exibição: ");
						for (int i = 0; i < tam; i++) {
							System.out.println(cine.getFilmeCartaz(i));
						}
						System.out.println("Qual filme deseja ver?");
					} else {
						System.out.println("\nNenhum filme em cartaz");
						System.out.println("Verifique com o responsável para adicionar filmes a lista\n");
					}

					System.out.println("Digite 0 para cancelar");
					opcao = in.nextInt();
					in.nextLine();

					switch (opcao) {
						case 0:
							Help.clearScreen();
							break;

						default:
							break;
					}

				} while (opcao != 0);

			} else if (user.equals(usuarios.get(2))) { // rh

				System.out.println("Acessando com usuário de recursos humanos...");

				do {
					System.out.println("\nEscolhe uma das opções: ");
					System.out.println("1 - Configurar preço dos ingressos");
					System.out.println("Digite 0 para cancelar");
					opcao = in.nextInt();
					in.nextLine();

					switch (opcao) {
						case 0:
							Help.clearScreen();
							break;
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
			user = "";
		} while (!user.equals("Esc"));
	}
}
