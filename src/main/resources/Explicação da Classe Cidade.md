## Classe Cidade

```java
public class Cidade {
    private String nome;
    private List<Cidade> vizinhas;
```

- `nome`: Armazena o nome da cidade
- `vizinhas`: Uma lista que guarda referências para outras cidades conectadas

### Construtor
```java
public Cidade(String nome) {
    this.nome = nome;
    this.vizinhas = new ArrayList<>();
}
```
- Inicializa uma nova cidade com um nome
- Cria uma lista vazia de cidades vizinhas

### Métodos
```java
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
```
- `getNome()`: Retorna o nome da cidade
- `getVizinhas()`: Retorna a lista de cidades vizinhas
- `adicionarVizinha()`: Adiciona uma nova cidade vizinha, evitando duplicatas