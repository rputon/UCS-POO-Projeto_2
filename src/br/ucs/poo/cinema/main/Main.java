package br.ucs.poo.cinema.main;

import br.ucs.poo.cinema.cinema.Cinema;
import br.ucs.poo.cinema.filme.Filme;
import br.ucs.poo.cinema.filme.Genero;
import br.ucs.poo.cinema.filme.Rating;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Help h = new Help();

		Cinema cine = new Cinema();

		if (!h.validFile("ratings")) {
			String[] lista = { "Livre", "10", "12", "14", "16", "18" };
			List<String> list = Arrays.asList(lista);
			cine.setRatingNome(list);
			h.writeFileRating("ratings", cine.getRating());
		} else {
			cine.setRatingList(h.readFileRating("ratings"));
		}

		System.out.println(cine.getRating());

		if (!h.validFile("generos")) {
			String[] lista = { "Ação", "Aventura", "Comédia", "Comédia dramática", "Comédia romântica", "Dança",
					"Documentário", "Drama", "Espionagem", "Faroeste", "Fantasia", "Fantasia Científica",
					"Ficção Científica", "Filmes de Guerra", "Mistério", "Musical", "Filme Policial", "Romance",
					"Terror", "Thriller" };
			List<String> list = Arrays.asList(lista);
			cine.setGeneroNome(list);
			h.writeFileGenero("generos", cine.getGenero());
		} else {
			cine.setGeneroList(h.readFileGenero("generos"));
		}
		System.out.println(cine.getGenero());

		


		String user = "";

		do {// ? While !esc -- sair do prompt
			String[] vetor = { "admin", "selfService", "rh" };
			List<String> usuarios = Arrays.asList(vetor);
			user = h.testUser(in, "Digite o usuário: ", usuarios);

			int opcao;

			// !-------------------------Interfaces------------------------------
			if (user.equals(usuarios.get(0))) { // ? admin
				System.out.println("\nAcessando com usuário de administrador...");

				do {
					opcao = h.returnInt(in,
							"\nEscolha uma das opções: \n1 - Venda de ingresso \n2 - Consultar catálogo de filmes \n3 - Consultar filmes em cartaz \n4 - Cadastrar filmes \nDigite 0 para cancelar",
							0, 4);

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

						case 2: // TODO: Consultar catálogo de filmes
							Map<Integer, Filme> mapFilme = new TreeMap<>();

							for (int i = 0; i < cine.getFilmeTam(); i++) {
								mapFilme.put(i, cine.getFilme(i));
							}

							for (int i = 0; i < cine.getFilmeTam(); i++) {
								for (int j = 1; j <= 3; j++) {
									System.out.print(mapFilme.get(i) + " |\t");
									i++;
								}
								System.out.println("");
							}
							System.out.println(mapFilme);

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
							int opt = h.returnInt(in,
									"1 - Adicionar um filme ao cartaz \n2 - Remover um filme do cartaz \n0 - Cancelar",
									0, 2);
							switch (opt) {
								case 0:
									h.clearScreen();
									break;

								case 1: // Adicionar um filme ao cartaz
									String nome, descricao;
									int ano, timeMin;
									Rating iRating;
									Genero iGenero;

									nome = h.returnString(in, "Digite o nome do filme:");
									ano = h.returnInt(in, "Digite o ano de publicação do filme:");
									timeMin = h.returnInt(in, "Digite a duração do filme, em minutos: ");
									descricao = h.returnString(in, "Digite a descrição do filme:");
									iRating = h.testRating(in, cine);
									iGenero = h.testGenero(in, cine);
									
									cine.setFilmeCartaz(nome, ano, timeMin, descricao,iRating, iGenero);
									System.out.println("Filme cadastrado");
									break;

								case 2: // todo: Remover um filme do cartaz
									// do{
									// String filme = h.returnString(in, "Digite o filme que deseja remover:");
									// } while(cine.getFilmes().contains(filme));

									// indexof
									break;
								default:
									break;
							}
							break;
						case 4: // Cadastrar um filme
							String nome, descricao;
							int ano, timeMin;
							Rating iRating;
							Genero iGenero;

							nome = h.returnString(in, "Digite o nome do filme:");
							ano = h.returnInt(in, "Digite o ano de publicação do filme:");
							timeMin = h.returnInt(in, "Digite a duração do filme, em minutos: ");
							descricao = h.returnString(in, "Digite a descrição do filme:");
							
							iRating = h.testRating(in,cine);
							iGenero = h.testGenero(in,cine);
							cine.setFilme(nome, ano, timeMin, descricao,iRating, iGenero);

							h.writeFileFilme("filmes", cine.getFilmes());

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
