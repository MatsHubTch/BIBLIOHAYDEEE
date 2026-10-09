import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Livros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> nomesLivros = new ArrayList<>();
        ArrayList<String> generos = new ArrayList<>();
        ArrayList<String> nomesAutores = new ArrayList<>();
        ArrayList<String> nacionalidadesAutores = new ArrayList<>();
        ArrayList<Integer> anosNascimento = new ArrayList<>();
        ArrayList<Long> isbns = new ArrayList<>();
        ArrayList<Boolean> disponiveis = new ArrayList<>();

        String[] preNomes = {
                "Meridiano de Sangue", "Não Tenho Boca e Preciso Gritar", "O Chamado de Cthulhu",
                "1984", "O Senhor dos Anéis", "Dom Casmurro",
                "O Pequeno Príncipe", "Fahrenheit 451", "Crime e Castigo", "Drácula"
        };
        String[] preGeneros = {
                "Ficção Sombria / Western", "Ficção Científica / Terror", "Terror / Fantasia",
                "Distopia / Ficção Científica", "Fantasia Épica", "Romance / Realismo",
                "Fábula / Literatura Infantil", "Ficção Científica", "Romance / Psicológico", "Terror Gótico"
        };
        String[] preAutores = {
                "Cormac McCarthy", "Harlan Ellison", "H.P. Lovecraft",
                "George Orwell", "J.R.R. Tolkien", "Machado de Assis",
                "Antoine de Saint-Exupéry", "Ray Bradbury", "Fiódor Dostoiévski", "Bram Stoker"
        };
        String[] preNacionalidades = {
                "Americano", "Americano", "Americano",
                "Britânico", "Britânico", "Brasileiro",
                "Francês", "Americano", "Russo", "Irlandês"
        };
        int[] preAnos = {1933, 1934, 1890, 1903, 1892, 1839, 1900, 1920, 1821, 1847};
        long[] preIsbns = {101, 102, 103, 104, 105, 106, 107, 108, 109, 110};

        for (int i = 0; i < 10; i++) {
            nomesLivros.add(preNomes[i]);
            generos.add(preGeneros[i]);
            nomesAutores.add(preAutores[i]);
            nacionalidadesAutores.add(preNacionalidades[i]);
            anosNascimento.add(preAnos[i]);
            isbns.add(preIsbns[i]);
            disponiveis.add(true);
        }

        boolean rodando = true;
        while (rodando) {
            try {
                System.out.println("\nO que quer fazer? Digite o número correspondente.");
                System.out.println("1- Ver nossa Biblioteca de Livros");
                System.out.println("2- Adicionar um Livro");
                System.out.println("3- Pesquisar / Alugar um Livro");
                System.out.println("4- Sair");
                int escolha = scanner.nextInt();
                scanner.nextLine();

                if (escolha == 1) {
                    System.out.println("\n--- BIBLIOTECA DE LIVROS ---");
                    for (int i = 0; i < nomesLivros.size(); i++) {
                        System.out.println("Livro " + (i + 1) + ":");
                        System.out.println("Nome do Livro: " + nomesLivros.get(i));
                        System.out.println("Gênero do Livro: " + generos.get(i));
                        System.out.println("Nome do Autor: " + nomesAutores.get(i));
                        System.out.println("Nacionalidade do Autor: " + nacionalidadesAutores.get(i));
                        System.out.println("Ano de nascimento do Autor: " + anosNascimento.get(i));
                        System.out.println("ISBN: " + isbns.get(i));
                        System.out.println("Status: " + (disponiveis.get(i) ? "Disponível" : "Alugado"));
                        System.out.println("----------------------------------------");
                    }

                } else if (escolha == 2) {
                    Autor autor = new Autor();
                    System.out.println("Qual o nome do livro? ");
                    String nomeDoLivro = scanner.nextLine();
                    System.out.println("Qual o gênero? ");
                    String genero = scanner.nextLine();
                    System.out.println("Qual o nome do Autor?");
                    autor.setNome(scanner.nextLine());
                    System.out.println("Qual é a nacionalidade do autor?");
                    autor.setNacionalidade(scanner.nextLine());
                    System.out.println("Qual o ano de nascimento do autor? ");
                    autor.setAnoDeNascimento(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Qual a ISBN? ");
                    long isbn = scanner.nextLong();
                    scanner.nextLine();

                    System.out.println("\nNome do Livro: " + nomeDoLivro);
                    System.out.println("Gênero do Livro: " + genero);
                    System.out.println("Nome do Autor: " + autor.getNome());
                    System.out.println("Nacionalidade do Autor: " + autor.getNacionalidade());
                    System.out.println("Ano de nascimento do Autor: " + autor.getAnoDeNascimento());
                    System.out.println("ISBN: " + isbn);
                    System.out.println("Você quer adicionar esse livro à biblioteca? Se sim digite 1, se não digite 2: ");
                    int confirma = scanner.nextInt();
                    scanner.nextLine();

                    if (confirma == 1) {
                        nomesLivros.add(nomeDoLivro);
                        generos.add(genero);
                        nomesAutores.add(autor.getNome());
                        nacionalidadesAutores.add(autor.getNacionalidade());
                        anosNascimento.add(autor.getAnoDeNascimento());
                        isbns.add(isbn);
                        disponiveis.add(true);
                        System.out.println("\n(Livro cadastrado com sucesso!)");
                    } else {
                        System.out.println("Encerrando cadastro de livro...");
                    }

                } else if (escolha == 3) {
                    System.out.println("Digite o nome (ou parte do nome) do livro que deseja pesquisar: ");
                    String pesquisa = scanner.nextLine();
                    boolean encontrado = false;

                    for (int i = 0; i < nomesLivros.size(); i++) {
                        if (nomesLivros.get(i).toLowerCase().contains(pesquisa.toLowerCase())) {
                            encontrado = true;
                            System.out.println("\nLivro encontrado!");
                            System.out.println("Nome do Livro: " + nomesLivros.get(i));
                            System.out.println("Gênero do Livro: " + generos.get(i));
                            System.out.println("Nome do Autor: " + nomesAutores.get(i));
                            System.out.println("Nacionalidade do Autor: " + nacionalidadesAutores.get(i));
                            System.out.println("Ano de nascimento do Autor: " + anosNascimento.get(i));
                            System.out.println("ISBN: " + isbns.get(i));


                            if (disponiveis.get(i)) {
                                System.out.println("Status: Disponível na biblioteca!");
                                System.out.println("Deseja alugar este livro? Digite 1 para sim ou 2 para não: ");
                                int alugar = scanner.nextInt();
                                scanner.nextLine();
                                if (alugar == 1) {
                                    disponiveis.set(i, false);
                                    System.out.println("Livro alugado com sucesso!");
                                }
                            } else {
                                System.out.println("Status: Indisponível (já está alugado).");
                            }
                            System.out.println("----------------------------------------");
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Nenhum livro encontrado com o nome: " + pesquisa);
                    }

                } else if (escolha == 4) {
                    System.out.println("Saindo...");
                    rodando = false;

                } else {
                    System.out.println("Opção inválida.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Escreva corretamente: não coloque letras onde só deve ter número ou o contrario.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}