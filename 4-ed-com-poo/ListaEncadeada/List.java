/**
 * Implementação da classe List, baseada na referência C.
 * A classe Node é definida como uma classe interna (inner class) privada,
 * pois ela só precisa ser acessada pela própria classe List.
 */
public class List {

    /**
     * A classe Node é estática e privada.
     * Estática: porque não precisa acessar nenhum membro da instância da classe
     * List.
     * Privada: porque é um detalhe de implementação que o usuário da classe List
     * não precisa saber.
     */
    private static class Node {
        int value;
        Node next;

        // Construtor do Node
        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node head;
    private int size;

    /**
     * Construtor da classe List.
     * Inicializa a lista como vazia.
     */
    public List() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Retorna o número de elementos na lista.
     * 
     * @return o tamanho da lista.
     */
    public int size() {
        return this.size;
    }

    /**
     * Adiciona um novo elemento na frente da lista.
     * 
     * @param data O valor a ser adicionado.
     */
    public void push_front(int data) {
        // O novo nó aponta para o antigo 'head'
        Node newNode = new Node(data, this.head);
        // O 'head' da lista agora é o novo nó
        this.head = newNode;
        this.size++;
    }

    /**
     * Mostra os elementos da lista na tela, no formato [val1, val2, ...].
     */
    public void print() {
        Node n = this.head;
        System.out.print("[");
        while (n != null) {
            System.out.print(n.value);
            n = n.next;
            if (n != null) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    /**
     * Remove o elemento da frente da lista e retorna seu valor.
     * Lança uma exceção se a lista estiver vazia (equivalente ao exit() em C).
     * 
     * @return o valor do nó removido.
     */
    public int pop_front() {
        if (this.head == null) {
            // Em Java, é idiomático lançar uma exceção em vez de sair.
            throw new RuntimeException("Error: pop_front(): list is empty.");
        }

        // Guarda o valor a ser retornado
        int data = this.head.value;

        // Avança o 'head' para o próximo nó
        this.head = this.head.next;

        // Decrementa o tamanho (o Garbage Collector do Java cuida de liberar a memória)
        this.size--;

        return data;
    }

    /**
     * Retorna uma cópia (deep) da lista, PRESERVANDO A ORDEM.
     * 
     * @return uma nova lista que é o clone da atual.
     */
    public List clone() {
        List copy = new List();
        Node n = this.head;
        Node tail = null; // Um ponteiro para o último nó da nova lista (copy)

        while (n != null) {
            // Cria o novo nó
            Node newNode = new Node(n.value, null);

            if (copy.head == null) {
                // Se for o primeiro nó, o head e o tail apontam para ele
                copy.head = newNode;
                tail = newNode;
            } else {
                // Se não, o antigo 'tail' aponta para o novo nó
                tail.next = newNode;
                // O novo nó se torna o 'tail'
                tail = newNode;
            }

            copy.size++; // Incrementa o tamanho da cópia
            n = n.next; // Avança na lista original
        }
        return copy;
    }
}