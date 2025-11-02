import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String nomeRede = s.nextLine();

        String nomeR1 = s.nextLine();

        String nomeP1 = s.next();
        int estoqueDiarioP1 = s.nextInt();
        int numVendasP1 = s.nextInt();
        float custoP1 = s.nextFloat();
        float precoP1 = s.nextFloat();
        Produto p1 = new Produto(nomeP1, estoqueDiarioP1, numVendasP1, custoP1, precoP1);

        String nomeP2 = s.next();
        int estoqueDiarioP2 = s.nextInt();
        int numVendasP2 = s.nextInt();
        float custoP2 = s.nextFloat();
        float precoP2 = s.nextFloat();
        Produto p2 = new Produto(nomeP2, estoqueDiarioP2, numVendasP2, custoP2, precoP2);

        String nomeP3 = s.next();
        int estoqueDiarioP3 = s.nextInt();
        int numVendasP3 = s.nextInt();
        float custoP3 = s.nextFloat();
        float precoP3 = s.nextFloat();
        Produto p3 = new Produto(nomeP3, estoqueDiarioP3, numVendasP3, custoP3, precoP3);

        s.nextLine();

        Restaurante r1 = new Restaurante(nomeR1, p1, p2, p3);

        String nomeR2 = s.nextLine();

        String nomeP4 = s.next();
        int estoqueDiarioP4 = s.nextInt();
        int numVendasP4 = s.nextInt();
        float custoP4 = s.nextFloat();
        float precoP4 = s.nextFloat();
        Produto p4 = new Produto(nomeP4, estoqueDiarioP4, numVendasP4, custoP4, precoP4);

        String nomeP5 = s.next();
        int estoqueDiarioP5 = s.nextInt();
        int numVendasP5 = s.nextInt();
        float custoP5 = s.nextFloat();
        float precoP5 = s.nextFloat();
        Produto p5 = new Produto(nomeP5, estoqueDiarioP5, numVendasP5, custoP5, precoP5);

        String nomeP6 = s.next();
        int estoqueDiarioP6 = s.nextInt();
        int numVendasP6 = s.nextInt();
        float custoP6 = s.nextFloat();
        float precoP6 = s.nextFloat();
        Produto p6 = new Produto(nomeP6, estoqueDiarioP6, numVendasP6, custoP6, precoP6);

        Restaurante r2 = new Restaurante(nomeR2, p4, p5, p6);

        Rede rede = new Rede(nomeRede, r1, r2);

        System.out.print(rede.mais_vendido().get_nome());
        System.out.printf(" %d\n", rede.mais_vendido().get_numVendas());
        System.out.print(rede.mais_lucrativo().get_nome());
        System.out.printf(" %.2f\n", rede.mais_lucrativo().lucro());
        System.out.printf("%.2f\n", rede.valor_vendas());
        System.out.printf("%.2f\n", rede.custo());
        System.out.printf("%.2f\n", rede.lucro());

        s.close();
    }
}