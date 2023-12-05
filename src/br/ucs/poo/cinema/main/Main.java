package br.ucs.poo.cinema.main;

import br.ucs.poo.cinema.cinema.Cinema;
import br.ucs.poo.cinema.filme.Filme;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	@Deprecated
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Help h = new Help();
		HelpCartaz hc = new HelpCartaz();
		HelpFilme hf = new HelpFilme();
		HelpGenero hg = new HelpGenero();
		HelpIngresso hi = new HelpIngresso();
		HelpRating hr = new HelpRating();
		HelpSala hs = new HelpSala();

		Cinema cine = new Cinema();

		if (!h.validFile("ratings")) {
			cine.setRatingNome(Arrays.asList("Livre", "10", "12", "14", "16", "18"));
			hr.writeFileRating("ratings", cine.getRating());
		} else {
			cine.setRatingList(hr.readFileRating("ratings"));
		}

		if (!h.validFile("generos")) {
			cine.setGeneroNome(
					Arrays.asList("Ação", "Aventura", "Comédia", "Comédia dramática", "Comédia romântica", "Dança",
							"Documentário", "Drama", "Espionagem", "Faroeste", "Fantasia", "Fantasia Científica",
							"Ficção Científica", "Filmes de Guerra", "Mistério", "Musical", "Filme Policial", "Romance",
							"Terror", "Thriller"));
			hg.writeFileGenero("generos", cine.getGenero());
		} else {
			cine.setGeneroList(hg.readFileGenero("generos"));
		}

		if (h.validFile("filmes")) {
			cine.setFilme(hf.readFilme());
		}

		if (h.validFile("cartaz")) {
			cine.setFilmeCartaz(hc.readCartaz());
		}

		if (h.validFile("salas")) {
			cine.setSalas(hs.readSala());
		}

		String user = "";

		do {// ? While !esc -- sair do prompt
			List<String> usuarios = Arrays.asList("admin", "selfService", "rh");
			user = h.testUser(in, "Digite o usuário: ", usuarios);

			int opcao;

			if (user.equals(usuarios.get(0))) {
				System.out.println("\nAcessando com usuário de administrador...");

				do {
					opcao = h.returnInt(in,
							"\nEscolha uma das opções: \n1 - Venda de ingresso \n2 - Consultar catálogo de filmes \n3 - Consultar filmes em cartaz \n4 - Adicionar sala \nDigite 0 para cancelar",
							0, 4);
					System.out.println("");

					switch (opcao) {

						case 0:
							h.clearScreen();
							break;
						case 1:
							hi.vendaIngresso(in, cine);
							break;

						case 2: // Consultar filmes
							if (cine.getFilmes().isEmpty()) {
								System.out.println("Nenhum filme cadastrado");
							} else {
								System.out.println(hf.formatFilme(cine));
							}

							int opt = h.returnInt(in,
									"1 - Adicionar um filme \n2 - Editar um filme \n3 - Remover um filme \n0 - Cancelar",
									0, 3);

							switch (opt) {
								case 0:
									h.clearScreen();
									break;

								case 1: // Adicionar filme
									Filme filme = hf.addFilme(in, cine);

									char sn;
									sn = h.returnChar(in, "Este filme está em cartaz?");
									if (sn == 'S') {
										hc.addCartaz(in, cine, filme.getNome());
									}
									break;

								case 2: // Editar filme
									String nome = h.returnString(in, "Digite o nome do filme:");
									if (hf.searchFilme(in, cine, nome) > -1) {
										hf.editFilme(cine, in, cine.getFilme(hf.searchFilme(in, cine, nome)));
									}

									break;

								case 3: // Remover filme
									hf.removeFilme(in, cine);
									break;

								default:
									System.out.println("Esta opção não existe");
									break;
							}

							break;

						case 3: // Consultar filmes em cartaz
							if (cine.getFilmeCartaz().size() > 0) {
								System.out.println("\nOs seguintes filmes estão em exibição: ");
								for (int i = 0; i < cine.getFilmeCartaz().size(); i++) {
									System.out.println(cine.getFilmeCartaz(i).toString(4));
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
									String nome = h.returnString(in, "Digite o nome do filme:");
									hc.addCartaz(in, cine, nome);
									/*
									 * String nome = h.returnString(in, "Digite o nome do filme:");
									 * if(hf.searchFilme(in, cine, nome) > -1){
									 * if(!cine.getFilme(hf.searchFilme(in, cine, nome)).getHorarios().isEmpty()){
									 * System.out.println(cine.getFilme(hf.searchFilme(in, cine,
									 * nome)).toString(4));
									 * }
									 * Sala sala = hs.addSala(in, cine);
									 * int time = cine.getFilme(hf.searchFilme(in, cine, nome)).getTimeMin();
									 * Horario hora = hh.addHorario(in, cine, time, sala.getHorarios());
									 * cine.getFilme(hf.searchFilme(in, cine, nome)).setSala(sala);
									 * cine.getFilme(hf.searchFilme(in, cine, nome)).setHora(hora);;
									 * //hc.saveFilme(cine, cine.getFilme(hf.searchFilme(in, cine, nome)));
									 * } else{
									 * System.out.println("Cadastre o filme primeiro");
									 * break;
									 * }
									 * System.out.println("Filme cadastrado");
									 */
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
						case 4:
							System.out.println(cine.getSalas());
							hs.addSala(in, cine);
						default:
							System.out.println("Esta opção não existe");
							break;
					}
				} while (opcao != 0);
			} else if (user.equals(usuarios.get(1))) { // ? selfService
				System.out.println("\nAcessando com usuário de auto atendimento...");

				do {
					if (cine.getFilmeCartaz().size() > 0) {
						System.out.println("\nOs seguintes filmes estão em exibição: ");
						for (int i = 0; i < cine.getFilmeCartaz().size(); i++) {
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
			}
			user = "";
			// TODO: Criar lista, add .dat e testar se a lista do cinema está diferente, e
			// salvar alterações
		} while (!user.equals("Esc"));
		in.close();
	}
}
