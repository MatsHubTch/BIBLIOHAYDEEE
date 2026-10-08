```java
package br.escola.bibliohaydee.app;

import br.escola.bibliohaydee.model.Usuario;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        Usuario[] usuarios = new Usuario[100];
        int quantidade = 0;

        String continuar = "S";

        while (continuar.equalsIgnoreCase("S")) {

            if (quantidade >= usuarios.length) {
                System.out.println("Limite de cadastros atingido.");
                break;
            }

            System.out.println("\n=== CADASTRO DE USUÁRIO ===");

            String nome;

            do {
                System.out.print("Digite o nome: ");
                nome = entrada.nextLine();

                if (nome.trim().isEmpty()) {
                    System.out.println("Erro: o nome não pode ser vazio.");
                }

            } while (nome.trim().isEmpty());

            System.out.print("Digite a matrícula: ");
            String matricula = entrada.nextLine();

            String tipo;

            do {
                System.out.print("Digite o tipo (ALUNO ou PROFESSOR): ");
                tipo = entrada.nextLine().trim().toUpperCase();

                if (!tipo.equals("ALUNO") && !tipo.equals("PROFESSOR")) {
                    System.out.println(
                            "Erro: digite ALUNO ou PROFESSOR.");
                }

            } while (!tipo.equals("ALUNO") && !tipo.equals("PROFESSOR"));

            int limite = -1;

            while (limite < 0) {

                System.out.print("Digite o limite de empréstimos: ");
                String valor = entrada.nextLine();

                try {
                    limite = Integer.parseInt(valor);

                    if (limite < 0) {
                        System.out.println(
                                "Erro: o limite não pode ser negativo.");
                    }

                } catch (NumberFormatException erro) {
                    System.out.println("Erro: digite um número inteiro.");
                    limite = -1;
                }
            }

            Usuario usuario = new Usuario(
                    nome, matricula, tipo, limite);

            usuarios[quantidade] = usuario;
            quantidade++;

            System.out.println("\nUsuário cadastrado com sucesso!");
            System.out.println("Nome: " + usuario.getNome());
            System.out.println("Matrícula: " + usuario.getMatricula());
            System.out.println("Tipo: " + usuario.getTipo());
            System.out.println("Limite: " + usuario.getLimiteEmprestimos());
            System.out.println("Empréstimos ativos: "
                    + usuario.getEmprestimosAtivos());

            System.out.print("\nDeseja cadastrar outro usuário? (S/N): ");
            continuar = entrada.nextLine();
        }

        System.out.println("\n=== USUÁRIOS CADASTRADOS ===");

        for (int i = 0; i < quantidade; i++) {
            System.out.println("\nUsuário " + (i + 1));
            System.out.println("Nome: " + usuarios[i].getNome());
            System.out.println("Matrícula: " + usuarios[i].getMatricula());
            System.out.println("Tipo: " + usuarios[i].getTipo());
        }

        System.out.println("\nPrograma encerrado.");

        entrada.close();
    }
}
```
