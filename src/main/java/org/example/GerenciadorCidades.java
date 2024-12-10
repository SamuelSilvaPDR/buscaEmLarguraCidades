package org.example;

import java.util.*;

/**
 * Classe responsável pelo gerenciamento de cidades e suas conexões.
 * Implementa funcionalidades para adicionar, listar e buscar cidades,
 * além de gerenciar suas conexões e realizar busca em largura (BFS).
 *
 * @author Guilherme Costa Alves Duarte, Hiann Alexander Mendes de Oliveira e Samuel da Silva de Oliveira
 * @version 1.0
 * @since 2024-12-05
 */
public class GerenciadorCidades {
    /**
     * Mapa que armazena todas as cidades, usando o nome como chave
     */
    private final Map<String, Cidade> cidades;

    /**
     * Construtor que inicializa o mapa de cidades.
     */
    public GerenciadorCidades() {
        this.cidades = new HashMap<>();
    }

    /**
     * Inicializa o sistema com um conjunto predefinido de cidades e suas conexões.
     * Cria as cidades e estabelece as conexões iniciais entre elas.
     */
    public void inicializarCidades() {
        String[] nomesCidades = {
                "Pires do Rio", "Ipameri", "Orizona", "Urutai", "Palmelo",
                "Santa Cruz", "Caldas Novas", "Catalao", "Vianopolis"
        };

        for (String nome : nomesCidades) {
            cidades.put(nome.toUpperCase(), new Cidade(nome.toUpperCase()));
        }

        // Adiciona conexões iniciais entre as cidades
        adicionarConexao("Urutai", "Pires do Rio");
        adicionarConexao("Caldas Novas", "Pires do Rio");
        adicionarConexao("Palmelo", "Pires do Rio");
        adicionarConexao("Orizona", "Pires do Rio");
        adicionarConexao("Ipameri", "Catalao");
        adicionarConexao("Urutai", "Ipameri");
        adicionarConexao("Palmelo", "Santa Cruz");
        adicionarConexao("Orizona", "Vianopolis");
        adicionarConexao("Vianopolis", "Orizona");
        adicionarConexao("Pires do Rio", "Orizona");
    }

    /**
     * Lista todas as cidades cadastradas e suas respectivas conexões.
     * Para cada cidade, exibe suas cidades vizinhas.
     */
    public void listarCidades() {
        System.out.println("\nLista de cidades e suas conexões:");
        for (Cidade cidade : cidades.values()) {
            System.out.print(cidade.getNome() + " → ");
            List<String> vizinhas = cidade.getVizinhas().stream()
                    .map(Cidade::getNome)
                    .toList();
            System.out.println(vizinhas.isEmpty() ? "Sem conexões" : vizinhas);
        }
    }

    /**
     * Verifica se uma cidade existe no sistema.
     *
     * @param nomeCidade nome da cidade a ser verificada
     * @return true se a cidade existe, false caso contrário
     */
    public boolean cidadeExiste(String nomeCidade) {
        return cidades.containsKey(nomeCidade);
    }

    /**
     * Adiciona uma conexão bidirecional entre duas cidades.
     *
     * @param cidade1 nome da primeira cidade
     * @param cidade2 nome da segunda cidade
     * @return true se a conexão foi adicionada com sucesso, false caso contrário
     */
    public boolean adicionarConexao(String cidade1, String cidade2) {
        Cidade c1 = cidades.get(cidade1.toUpperCase());
        Cidade c2 = cidades.get(cidade2.toUpperCase());

        if (c1 == null || c2 == null) {
            return false;
        }

        c1.adicionarVizinha(c2);
        c2.adicionarVizinha(c1);
        return true;
    }


    /**
     * Trabalho EDII
     * Realiza uma busca em largura (Breadth-First Search - BFS) no grafo de cidades.
     *
     * Este método implementa o algoritmo BFS para percorrer todas as cidades conectadas
     * a partir de uma cidade inicial especificada. A busca em largura visita primeiro todos
     * os vértices adjacentes ao vértice atual antes de avançar para o próximo nível.
     *
     * @param cidadeInicial O nome da cidade onde a busca deve começar
     *
     * @throws NullPointerException Se a estrutura de cidades não foi inicializada
     *
     * Exemplo de uso:
     *     GrafoCidades grafo = new GrafoCidades();
     *     // ... adicionar cidades e conexões ...
     *     grafo.realizarBFS("São Paulo");
     *
     * Funcionamento:
     *     1. Verifica se a cidade inicial existe no grafo
     *     2. Inicializa uma fila para controlar a ordem de visitação
     *     3. Inicializa um conjunto para rastrear cidades já visitadas
     *     4. Enquanto houver cidades na fila:
     *         - Remove a primeira cidade da fila
     *         - Visita todas as cidades vizinhas não visitadas
     *         - Adiciona as cidades vizinhas não visitadas à fila
     *
     * Saída:
     *     - Imprime a ordem em que as cidades são visitadas
     *     - Se a cidade inicial não for encontrada, exibe uma mensagem de erro
     */
    public void realizarBFS(String cidadeInicial) {
        Cidade inicio = cidades.get(cidadeInicial);
        if (inicio == null) {
            System.out.println("Cidade inicial não encontrada!");
            return;
        }

        Queue<Cidade> fila = new LinkedList<>();
        Set<Cidade> visitadas = new HashSet<>();
        List<String> ordemVisitacao = new ArrayList<>();

        fila.offer(inicio);
        visitadas.add(inicio);

        System.out.println("\nOrdem de visitação BFS a partir de " + cidadeInicial + ":");
        while (!fila.isEmpty()) {
            Cidade atual = fila.poll();
            ordemVisitacao.add(atual.getNome());
            System.out.println("Visitando: " + atual.getNome());

            for (Cidade vizinha : atual.getVizinhas()) {
                if (!visitadas.contains(vizinha)) {
                    visitadas.add(vizinha);
                    fila.offer(vizinha);
                }
            }
        }

        System.out.println("\nLista final da ordem de visitação:");
        for (int i = 0; i < ordemVisitacao.size(); i++) {
            System.out.print(" " + (i + 1) +  "-" +ordemVisitacao.get(i));
        }
        System.out.println("\n");
    }
}
