import java.util.Scanner;
import java.util.Locale;

public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        String nome = sc.nextLine();

        int estoque = sc.nextInt();
        if (estoque < 0) {
            System.out.println("VALOR INVALIDO");
            sc.close();
            return;
        }

        double valor = sc.nextDouble();
        if (valor <= 0) {
            System.out.println("VALOR INVALIDO");
            sc.close();
            return;
        }

        double desconto = sc.nextDouble();
        if (desconto < 0 || desconto > 1) {
            System.out.println("VALOR INVALIDO");
            sc.close();
            return;
        }

        Produto produto = new Produto(nome, estoque, valor, desconto);

        int interacoes = sc.nextInt();
        String operacao;
        int qtd;

        for (int i = 0; i < interacoes; i++) {
            operacao = sc.next();
            qtd = sc.nextInt();

            if (operacao.equals("C")) {
                produto.compra(qtd);
            } else if (operacao.equals("V")) {
                produto.venda(qtd);
            }
        }

        System.out.println(produto.getNome());
        System.out.println(produto.getEstoque());
        System.out.printf(Locale.US, "%.2f\n", produto.getValor());
        System.out.printf(Locale.US, "%.2f\n", produto.getDesconto());
        System.out.printf(Locale.US, "%.2f\n", produto.preco());
        System.out.printf(Locale.US, "%.2f\n", produto.valor_vendas());

        sc.close();
    }
}