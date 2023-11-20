package br.ucs.poo.cinema.main;

import br.ucs.poo.cinema.cinema.Cinema;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Help h = new Help();
		HelpList hList = new HelpList();
		HelpFile hFile = new HelpFile();

		Cinema cine = new Cinema();

		if (!hFile.validFile("ratings")) {
			cine.setRatingNome(Arrays.asList("Livre", "10", "12", "14", "16", "18"));
			hFile.writeFileRating("ratings", cine.getRating());
		} else {
			cine.setRatingList(hFile.readFileRating("ratings"));
		}

		if (!hFile.validFile("generos")) {
			cine.setGeneroNome(
					Arrays.asList("Ação", "Aventura", "Comédia", "Comédia dramática", "Comédia romântica", "Dança",
							"Documentário", "Drama", "Espionagem", "Faroeste", "Fantasia", "Fantasia Científica",
							"Ficção Científica", "Filmes de Guerra", "Mistério", "Musical", "Filme Policial", "Romance",
							"Terror", "Thriller"));
			hFile.writeFileGenero("generos", cine.getGenero());
		} else {
			cine.setGeneroList(hFile.readFileGenero("generos"));
		}

		if (hFile.validFile("filmes")) {
			cine.setFilme(hFile.readFileFilme("filmes"));
		}

		if (hFile.validFile("salas")){
			
		}
		if (hFile.validFile("assentos")){
			
		}

		String user = "";

		do {// ? While !esc -- sair do prompt
			List<String> usuarios = Arrays.asList("admin", "selfService", "rh");
			user = hList.testUser(in, "Digite o usuário: ", usuarios);

			int opcao;

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
							//String nome = h.returnString(in, "Digite o nome do filme:");

							//if (hList.searchFilmeName(cine, nome).size() == 1) {
								// filme selecionado
						//	} else {
						//		int ano = h.returnInt(in, "Digite o ano do filme:");
						//		for (Filme f : hList.searchFilmeName(cine, nome)) {
						//			if (f.getAno() == ano) {
										// filme selecionado
									//}
								//}
								// filme não existe
								// tentar novamente
								// criar filme
							//}

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
							System.out.println(hList.tableFilme(cine));

							int opt = h.returnInt(in,
									"1 - Adicionar um filme \n2 - Editar um filme \n3 - Remover um filme \n0 - Cancelar",
									0, 3);

							switch (opt) {
								case 0:
									h.clearScreen();
									break;

								case 1: // Adicionar filme
									hList.addFilme(in);

									// confirmar informações do filme

									
									char sn;
									sn = h.returnChar(in, "Este filme está em cartaz?");
									if (sn == 'S') {
										hList.addFilmeCartaz(in,true);
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

									cine.setFilmeCartaz(nome, ano, timeMin, descricao, hList.testRating(in, cine),
											hList.testGenero(in, cine));
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
		in.close();
	}
}
