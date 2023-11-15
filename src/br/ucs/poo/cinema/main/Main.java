package br.ucs.poo.cinema.main;

import br.ucs.poo.cinema.cinema.Cinema;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		Cinema cine = new Cinema();

		Help h = new Help();

		/*----------------------Usuário/Dispositivo------------------------ */
		String[] vetor = { "admin", "selfService", "rh" };
		List<String> usuarios = Arrays.asList(vetor);
		String user = "";
		do {// While !esc -- sair do prompt
			do {
				user = h.returnString(in, "Digite o usuário: ");
				if (!usuarios.contains(user)) {
					System.out.println("Usuário não encontrado.\n");
				}
			} while (!usuarios.contains(user));

			/*-------------------------Interfaces------------------------------ */
			int opcao;

			if (user.equals(usuarios.get(0))) { // admin
				System.out.println("\nAcessando com usuário de administrador...");

				do {
					opcao = h.returnInt(in,
							"\nEscolha uma das opções: \n1 - Venda de ingresso \n2 - Consultar catálogo de filmes \n3 - Consultar filmes em cartaz \n4 - Cadastrar filmes \nDigite 0 para cancelar",
							0, 4);

					switch (opcao) {
						case 0:
							h.clearScreen();
							break;
						case 1:

							break;

						case 2:

							break;

						case 3:
							int tam = cine.getFilmeCartazTam();
							if (tam > 0) {
								System.out.println("\nOs seguintes filmes estão em exibição: ");
								for (int i = 0; i < tam; i++) {
									System.out.println(cine.getFilmeCartaz(i));
								}
							} else {
								System.out.println("\nNenhum filme em cartaz");
							}
							int opt = h.returnInt(in,
									"1 - Adicionar um filme ao cartaz \n2 - Remover um filme do cartaz \n0 - Cancelar",
									0, 2);
							switch (opt) {
								case 0:
									break;
							
								case 1:
									String nome, descricao,genero;
									int ano, timeMin, rating;

									nome = h.returnString(in, "Digite o nome do filme:");
									ano = h.returnInt(in, "Digite o ano de publicação do filme:");
									timeMin = h.returnInt(in, "Digite a duração do filme, em minutos: ");
									descricao = h.returnString(in, "Digite a descrição do filme:");

									//Lista pré-pronto de classificação
									rating = h.returnInt(in, "Digite a classificação indicativa do filme:");

									//Puxar lista de gêneros cadastrados
									genero = h.returnString(in, "Digite o gênero do filme:");

									cine.setFilmeCartaz(nome, ano, timeMin, descricao, rating, genero);
									System.out.println("Filme cadastrado");
									break;
									
								case 2:
									//do{
									//	String filme = h.returnString(in, "Digite o filme que deseja remover:");
									//} while(cine.getFilmes().contains(filme));

									//indexof
									break;
								default:
									break;
							}
							break;
						case 4:
							String nome, descricao, genero;
							int ano, timeMin, rating;

							nome = h.returnString(in, "Digite o nome do filme:");
							ano = h.returnInt(in, "Digite o ano de publicação do filme:");
							timeMin = h.returnInt(in, "Digite a duração do filme, em minutos: ");
							descricao = h.returnString(in, "Digite a descrição do filme:");
							rating = h.returnInt(in, "Digite a classificação indicativa do filme:");
							genero = h.returnString(in, "Digite o gênero do filme:");

							cine.setFilme(nome, ano, timeMin, descricao, rating, genero);
							break;

						default:
							System.out.println("Esta opção não existe");
							break;
					}
				} while (opcao != 0);
			} else if (user.equals(usuarios.get(1))) { // selfService
				System.out.println("\nAcessando com usuário de auto atendimento...");

				do {
					int tam = cine.getFilmeCartazTam();
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
							h.clearScreen();
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
							h.clearScreen();
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
			//TODO: Criar lista, add .dat e testar se a lista do cinema está diferente, e salvar alterações
		}while(!user.equals("Esc"));
}}
