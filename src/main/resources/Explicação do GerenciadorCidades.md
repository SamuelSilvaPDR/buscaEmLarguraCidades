## Classe GerenciadorCidades

### Atributos
```java
private Map<String, Cidade> cidades;
```
- Um mapa que associa nomes de cidades aos seus objetos correspondentes

### Métodos Principais

#### inicializarCidades()
```java
public void inicializarCidades() {
    String[] nomesCidades = {
        "São Paulo", "Campinas", "Santos", "Sorocaba", 
        "Ribeirão Preto", "São José dos Campos"
    };
    
    for (String nome : nomesCidades) {
        cidades.put(nome, new Cidade(nome));
    }
    // Adiciona conexões iniciais
}
```
- Cria as cidades iniciais do sistema
- Estabelece algumas conexões padrão entre as cidades

#### listarCidades()
```java
public void listarCidades() {
    // Lista todas as cidades e suas conexões
}
```
- Mostra todas as cidades cadastradas e suas conexões

#### realizarBFS()
```java
public void realizarBFS(String nomeCidadeInicial) {
    // Implementação do algoritmo de Busca em Largura
}
```
- Implementa o algoritmo de Busca em Largura (BFS)
- Usa uma fila para processar as cidades em ordem
- Mantém registro das cidades visitadas
- Guarda o caminho percorrido usando um mapa de predecessoras