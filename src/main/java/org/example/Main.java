package org.example;

import java.util.Scanner;

public class Main {
    private static final GerenciadorCidades gerenciador = new GerenciadorCidades();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        gerenciador.inicializarCidades();

        while (true) {
            exibirMenu();
            try {
                int escolha = Integer.parseInt(scanner.nextLine());
                processarEscolha(escolha);

                if (escolha == 4) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido.");
            }
        }

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n=== Sistema de Navegação de Cidades ===");
        System.out.println("1. Listar todas as cidades");
        System.out.println("2. Adicionar conexão entre cidades");
        System.out.println("3. Realizar busca em largura (BFS)");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void processarEscolha(int escolha) {
        switch (escolha) {
            case 1:
                gerenciador.listarCidades();
                break;

            case 2:
                adicionarConexao();
                break;

            case 3:
                realizarBFS();
                break;

            case 4:
                System.out.println("Encerrando o programa...");
                break;

            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void adicionarConexao() {
        System.out.print("Digite o nome da primeira cidade: ");
        String cidade1 = scanner.nextLine();

        System.out.print("Digite o nome da segunda cidade: ");
        String cidade2 = scanner.nextLine();

        if (!gerenciador.cidadeExiste(cidade1) || !gerenciador.cidadeExiste(cidade2)) {
            System.out.println("Uma ou ambas as cidades não existem no sistema!");
            return;
        }

        if (gerenciador.adicionarConexao(cidade1, cidade2)) {
            System.out.println("Conexão adicionada com sucesso!");
        } else {
            System.out.println("Não foi possível adicionar a conexão.");
        }
    }

    private static void realizarBFS() {
        System.out.print("Digite o nome da cidade inicial para a busca: ");
        String cidadeInicial = scanner.nextLine();

        if (!gerenciador.cidadeExiste(cidadeInicial)) {
            System.out.println("Cidade não encontrada no sistema!");
            return;
        }

        gerenciador.realizarBFS(cidadeInicial);
    }
}