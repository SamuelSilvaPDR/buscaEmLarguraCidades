## Classe Main

### Atributos Estáticos
```java
private static final GerenciadorCidades gerenciador = new GerenciadorCidades();
private static final Scanner scanner = new Scanner(System.in);
```
- `gerenciador`: Instância única do gerenciador de cidades
- `scanner`: Objeto para ler entrada do usuário

### Método main
```java
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
}
```
- Inicializa o sistema
- Executa um loop infinito mostrando o menu
- Processa as escolhas do usuário
- Trata erros de entrada

### Processamento de Escolhas
```java
private static void processarEscolha(int escolha) {
    switch (escolha) {
        case 1: // Listar cidades
        case 2: // Adicionar conexão
        case 3: // Realizar BFS
        case 4: // Sair
    }
}
```
- Usa um switch-case para direcionar as ações do usuário
- Cada caso corresponde a uma funcionalidade específica