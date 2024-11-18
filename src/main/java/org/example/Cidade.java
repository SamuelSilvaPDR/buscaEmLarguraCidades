package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cidade {
    private final String nome;
    private final List<Cidade> vizinhas;

    public Cidade(String nome) {
        this.nome = nome;
        this.vizinhas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Cidade> getVizinhas() {
        return vizinhas;
    }

    public void adicionarVizinha(Cidade vizinha) {
        if (!this.vizinhas.contains(vizinha)) {
            this.vizinhas.add(vizinha);
        }
    }

    @Override
    public String toString() {
        return nome;
    }
}