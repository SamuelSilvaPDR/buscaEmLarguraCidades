package org.example;

import java.util.*;

class GerenciadorCidades {
    private final Map<String, Cidade> cidades;

    public GerenciadorCidades() {
        this.cidades = new HashMap<>();
    }

    public void inicializarCidades() {
        String[] nomesCidades = {
                "Pires do Rio", "Ipameri","Orizona", "Urutai", "Palmelo",
                "Santa Cruz", "Caldas Novas", "Catalao", "Vianopolis"
        };

        for (String nome : nomesCidades) {
            cidades.put(nome, new Cidade(nome));
        }

        // Conexões iniciais
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

    public void listarCidades() {
        System.out.println("\nLista de cidades e suas conexões:");
        for (Cidade cidade : cidades.values()) {
            System.out.print(cidade.getNome() + " → ");
            List<String> vizinhas = cidade.getVizinhas().stream()
                    .map(Cidade::getNome)
                    .toList();
            System.out.println(vizinhas.isEmpty() ? "Sem conexões" : String.join(", ", vizinhas));
        }
    }

    public boolean adicionarConexao(String nomeCidade1, String nomeCidade2) {
        Cidade cidade1 = cidades.get(nomeCidade1);
        Cidade cidade2 = cidades.get(nomeCidade2);

        if (cidade1 != null && cidade2 != null) {
            cidade1.adicionarVizinha(cidade2);
            cidade2.adicionarVizinha(cidade1);
            return true;
        }
        return false;
    }

    public void realizarBFS(String nomeCidadeInicial) {
        Cidade inicio = cidades.get(nomeCidadeInicial);
        if (inicio == null) {
            System.out.println("Cidade não encontrada!");
            return;
        }

        Queue<Cidade> fila = new LinkedList<>();
        Set<Cidade> visitadas = new HashSet<>();
        Map<Cidade, Cidade> predecessoras = new HashMap<>();

        fila.offer(inicio);
        visitadas.add(inicio);

        System.out.println("\nOrdem de visitação:");
        while (!fila.isEmpty()) {
            Cidade atual = fila.poll();
            System.out.println("Visitando: " + atual.getNome());

            for (Cidade vizinha : atual.getVizinhas()) {
                if (!visitadas.contains(vizinha)) {
                    fila.offer(vizinha);
                    visitadas.add(vizinha);
                    predecessoras.put(vizinha, atual);
                }
            }
        }

        // Imprimir todos os caminhos
        System.out.println("\nCaminhos a partir de " + inicio.getNome() + ":");
        for (Cidade cidade : visitadas) {
            if (!cidade.equals(inicio)) {
                System.out.print(cidade.getNome() + ": ");
                imprimirCaminho(predecessoras, cidade);
                System.out.println();
            }
        }
    }

    private void imprimirCaminho(Map<Cidade, Cidade> predecessoras, Cidade fim) {
        List<String> caminho = new ArrayList<>();
        Cidade atual = fim;
        while (atual != null) {
            caminho.add(0, atual.getNome());
            atual = predecessoras.get(atual);
        }
        System.out.print(String.join(" → ", caminho));
    }

    public boolean cidadeExiste(String nome) {
        return cidades.containsKey(nome);
    }
}