import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        int n, value;

        BinaryTree bt = new BinaryTree();

        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            value = sc.nextInt();
            bt.add(value);
        }

        System.out.println(bt.min());
        System.out.println(bt.max());

        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            value = sc.nextInt();
            if (bt.exists(value)) {
                System.out.println("EXISTE");
            } else {
                System.out.println("NAO EXISTE");
            }
        }

        sc.close();
    }
}