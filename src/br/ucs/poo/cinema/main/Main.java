package br.ucs.poo.cinema.main;

import br.ucs.poo.cinema.cinema.Cinema;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Help h = new Help();

		Cinema cine = new Cinema();

		// ! Check Rating ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧
		// ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧
		if (!h.validFile("ratings")) {
			cine.setRatingNome(Arrays.asList("Livre", "10", "12", "14", "16", "18"));
			h.writeFileRating("ratings", cine.getRating());
		} else {
			cine.setRatingList(h.readFileRating("ratings"));
		}

		// ! Check Genero ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧
		// ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧
		if (!h.validFile("generos")) {
			cine.setGeneroNome(
					Arrays.asList("Ação", "Aventura", "Comédia", "Comédia dramática", "Comédia romântica", "Dança",
							"Documentário", "Drama", "Espionagem", "Faroeste", "Fantasia", "Fantasia Científica",
							"Ficção Científica", "Filmes de Guerra", "Mistério", "Musical", "Filme Policial", "Romance",
							"Terror", "Thriller"));
			h.writeFileGenero("generos", cine.getGenero());
		} else {
			cine.setGeneroList(h.readFileGenero("generos"));
		}

		// ! Check Filme ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧
		// ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧
		if (h.validFile("filmes")) {
			cine.setFilme(h.readFileFilme("filmes"));
		}

		String user = "";

		do {// ? While !esc -- sair do prompt
			List<String> usuarios = Arrays.asList("admin", "selfService", "rh");
			user = h.testUser(in, "Digite o usuário: ", usuarios);

			int opcao;

			// ! Interfaces ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧
			// ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧
			if (user.equals(usuarios.get(0))) { // ? admin ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧
												// ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧ ‧
				System.out.println("\nAcessando com usuário de administrador...");

				do {
					opcao = h.returnInt(in,
							"\nEscolha uma das opções: \n1 - Venda de ingresso \n2 - Consultar catálogo de filmes \n3 - Consultar filmes em cartaz \nDigite 0 para cancelar",
							0, 3);
					System.out.println("");

					switch (opcao) {

						case 0:
							h.clearScreen();
							break;
						case 1: // TODO: Venda de ingressos

							// Qual filme deseja ver?
							// ? tipo 3d/legendado/dublado
							// Qual horário?
							// Mostra sala, qual assento? 1 ou mais
							// mostra preço
							// nome
							// celular
							// meia entrada - estudante, -12, +60

							break;

						case 2: // Consultar filmes
							System.out.println(h.tableFilme(cine));

							int opt = h.returnInt(in,
									"1 - Adicionar um filme \n2 - Editar um filme \n3 - Remover um filme \n0 - Cancelar",
									0, 3);

							switch (opt) {
								case 0:
									h.clearScreen();
									break;

								case 1: // Adicionar filme
									String nome, descricao;
									int ano, timeMin;

									nome = h.returnString(in, "Digite o nome do filme:");
									ano = h.returnInt(in, "Digite o ano de publicação do filme:");

									int test = h.testFilme(cine, nome, ano);
									char sn;
									if (test != -1) {
										System.out.println("Este filme já está cadastrado:");
										System.out.println(test);
										System.out.println("1 - Criar outro \n2 - Editar \nDigite 0 para cancelar");
									} else {
										timeMin = h.returnInt(in, "Digite a duração do filme, em minutos: ");
										descricao = h.returnString(in, "Digite a descrição do filme:");
										Object rating = h.testRating(in, cine);
										Object genero = h.testGenero(in, cine);

										System.out.println(String.format("%s, %i, %imin \n%s \n%s | %s", nome, ano,
												timeMin, descricao, rating.toString(), genero.toString()));
										int opt1 = h.returnInt(in, "1 - Continuar \n2 - Editar", 1, 2);

										if (opt1 == 1) {
											cine.setFilme(nome, ano, timeMin, descricao, h.objToRating(rating),
													h.objToGenero(genero));
											h.writeFileFilme("filmes", cine.getFilmes());
										}

									}
									// filmes não é duplicado

									// confirmar informações do filme

									System.out.println("Filme cadastrado");

									sn = h.returnChar(in, "Este filme está em cartaz?");
									if (sn == 'S') {
										LocalDate data = h.returnDate(in, "Até quado este filme estará em cartaz?");

										//System.out.println(cine.getS);
										// Em quais salas ele será aprensentado?
										// lista de salas
										// Sala x -> lista de filmes exibidos na sala x/horarios
										// Confirmar sala
										// Qual horário sera exibido?
										// Este horário (minutos do filme) irá conflitar com o filme y
										// escolha outra sala
										// Confirmar informações
										// salvar na lista + arquivo
									}

									// TODO: Ao add, adicionar ou não ao cartaz + tempo
									// TODO: Se está em cartaz, sala e horários
									break;

								case 2: // Editar filme

									break;

								case 3: // Remover filme
									// if(cine.getIngresso().getFilme().equals(filmeRemover)){
									// Este filme já vendeu ingressos, tem certeza que deseja remover o filme?
									// }
									break;

								default:
									System.out.println("Esta opção não existe");
									break;
							}

							break;

						case 3: // Consultar filmes em cartaz
							int tam = cine.getFilmeCartazTam();
							if (tam > 0) {
								System.out.println("\nOs seguintes filmes estão em exibição: ");
								for (int i = 0; i < tam; i++) {
									System.out.println(cine.getFilmeCartaz(i));
								}
							} else {
								System.out.println("\nNenhum filme em cartaz");
							}
							opt = h.returnInt(in,
									"1 - Adicionar um filme ao cartaz \n2 - Remover um filme do cartaz \n0 - Cancelar",
									0, 2);
							switch (opt) {
								case 0:
									h.clearScreen();
									break;

								case 1: // Adicionar um filme ao cartaz
									String nome, descricao;
									int ano, timeMin;

									nome = h.returnString(in, "Digite o nome do filme:");
									ano = h.returnInt(in, "Digite o ano de publicação do filme:");
									timeMin = h.returnInt(in, "Digite a duração do filme, em minutos: ");
									descricao = h.returnString(in, "Digite a descrição do filme:");

									cine.setFilmeCartaz(nome, ano, timeMin, descricao, h.testRating(in, cine),
											h.testGenero(in, cine));
									System.out.println("Filme cadastrado");
									break;

								case 2: // todo: Remover um filme do cartaz
									// do{
									// String filme = h.returnString(in, "Digite o filme que deseja remover:");
									// } while(cine.getFilmes().contains(filme));

									// indexof
									break;
								default:
									System.out.println("Esta opção não existe");
									break;
							}
							break;
						default:
							System.out.println("Esta opção não existe");
							break;
					}
				} while (opcao != 0);
			} else if (user.equals(usuarios.get(1))) { // ? selfService
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

			} else if (user.equals(usuarios.get(2))) { // ? rh

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
			// TODO: Criar lista, add .dat e testar se a lista do cinema está diferente, e
			// salvar alterações
		} while (!user.equals("Esc"));
	}
}
