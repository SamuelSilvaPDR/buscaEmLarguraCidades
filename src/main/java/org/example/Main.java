package org.example;

import java.util.Scanner;

/**
 * Classe principal que implementa a interface do usuário para o sistema de navegação de cidades.
 * Permite interação com o usuário através de um menu de opções para gerenciar cidades e suas conexões.
 *
 * @author Guilherme Costa Alves Duarte, Hiann Alexander Mendes de Oliveira e Samuel da Silva de Oliveira
 * @version 1.0
 * @since 2024-12-02
 */
public class Main {
    /** Instância do gerenciador de cidades utilizada em toda a aplicação */
    private static final GerenciadorCidades gerenciador = new GerenciadorCidades();

    /** Scanner para leitura de entrada do usuário */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Método principal que inicia a aplicação.
     * Inicializa o sistema e apresenta um menu interativo ao usuário.
     *
     * @param args argumentos da linha de comando (não utilizados)
     */
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

    /**
     * Exibe o menu principal do sistema com todas as opções disponíveis.
     * As opções incluem listar cidades, adicionar conexões, realizar BFS e sair.
     */
    private static void exibirMenu() {
        System.out.println("\n=== Sistema de Navegação de Cidades ===");
        System.out.println("1. Listar todas as cidades");
        System.out.println("2. Adicionar conexão entre cidades");
        System.out.println("3. Realizar busca em largura (BFS)");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
    }

    /**
     * Processa a escolha do usuário e executa a ação correspondente.
     *
     * @param escolha número inteiro representando a opção escolhida pelo usuário
     */
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

    /**
     * Solicita ao usuário informações para adicionar uma nova conexão entre duas cidades.
     * Verifica se as cidades existem antes de tentar estabelecer a conexão.
     *
     * @throws RuntimeException se houver erro na leitura da entrada do usuário
     */
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

    /**
     * Solicita ao usuário uma cidade inicial e realiza uma busca em largura (BFS)
     * a partir desta cidade.
     *
     * @throws RuntimeException se houver erro na leitura da entrada do usuário
     */
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
