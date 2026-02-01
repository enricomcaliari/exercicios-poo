import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Product> lista = new ArrayList<>();

        if (sc.hasNext()) {
            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                String nome = sc.next();
                double preco = sc.nextDouble();
                lista.add(new Product(nome, preco));
            }

            Collections.sort(lista);

            for (Product p : lista) {
                System.out.println(p);
            }
        }

        sc.close();
    }
}