package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma cidade e suas cidades vizinhas.
 * Esta classe permite gerenciar uma cidade e suas conexões com outras cidades.
 * @author Guilherme Costa Alves Duarte, Hiann Alexander Mendes de Oliveira e Samuel da Silva de Oliveira
 * @version 1.0
 * @since 2024-12-02
 */
public class Cidade {
    /** O nome da cidade */
    private final String nome;

    /** Lista de cidades vizinhas */
    private final List<Cidade> vizinhas;

    /**
     * Construtor que cria uma nova cidade.
     *
     * @param nome O nome da cidade a ser criada
     */
    public Cidade(String nome) {
        this.nome = nome.toUpperCase();
        this.vizinhas = new ArrayList<>();
    }

    /**
     * Retorna o nome da cidade.
     *
     * @return O nome da cidade
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna a lista de cidades vizinhas.
     *
     * @return Lista contendo todas as cidades vizinhas
     */
    public List<Cidade> getVizinhas() {
        return vizinhas;
    }

    /**
     * Adiciona uma cidade vizinha à lista de vizinhas.
     * Se a cidade já estiver na lista, ela não será adicionada novamente.
     *
     * @param vizinha A cidade a ser adicionada como vizinha
     */
    public void adicionarVizinha(Cidade vizinha) {
        if (!this.vizinhas.contains(vizinha)) {
            this.vizinhas.add(vizinha);
        }
    }

    /**
     * Sobrescreve o método toString para retornar o nome da cidade.
     *
     * @return O nome da cidade
     */
    @Override
    public String toString() {
        return nome;
    }
}