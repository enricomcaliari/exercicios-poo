import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int altura = sc.nextInt();
        int largura = sc.nextInt();

        Retangulo retangulo = new Retangulo(altura, largura);

        System.out.printf("%d\n", retangulo.getAltura());
        System.out.printf("%d\n", retangulo.getLargura());
        System.out.printf("%d\n", retangulo.area());
        System.out.printf("%d\n", retangulo.perimetro());

        sc.close();
    }
}
