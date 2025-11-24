import java.util.Scanner;
import java.util.Locale;

/**
 * Classe do programa principal, contendo o método main.
 * Esta lógica replica o main.c fornecido.
 */
public class Main {
    public static void main(String[] args) {
        // Usar Locale.US garante que o Scanner use '.' como separador decimal
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        int n, val;

        List l = new List();

        // Lê o número de elementos
        n = sc.nextInt();

        // Lê 'n' elementos e os insere na frente da lista 'l'
        for (int i = 0; i < n; i++) {
            val = sc.nextInt();
            l.push_front(val);
        }

        // Clona a lista 'l' para 'm' (replicando a lógica de inversão do C)
        List m = l.clone();

        // Pega o tamanho da lista clonada
        n = m.size();

        // Remove e imprime todos os elementos da lista 'm'
        for (int i = 0; i < n; i++) {
            System.out.println(m.pop_front());
        }

        // Não é necessário chamar 'destroy' em Java,
        // o Garbage Collector cuida disso.
        sc.close();
    }
}