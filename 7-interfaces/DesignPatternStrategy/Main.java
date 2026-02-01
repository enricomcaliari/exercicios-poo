import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // 1. Ler o tipo de frete (Entrada do usuário)
        if (!sc.hasNext()) {
            sc.close();
            return;
        }
        String tipoFrete = sc.next();

        // 2. Ler os dados da compra
        double valorItens = sc.nextDouble();
        double peso = sc.nextDouble();
        double distancia = sc.nextDouble();

        // 3. Selecionar a estratégia correta baseada no nome
        // Note que o "switch" está aqui na criação, e NÃO na classe Carrinho.
        // Isso mantém a regra de negócio limpa.
        FreteStrategy estrategiaSelecionada = null;

        switch (tipoFrete) {
            case "FretePadrao":
                estrategiaSelecionada = new FretePadrao();
                break;
            case "FreteExpresso":
                estrategiaSelecionada = new FreteExpresso();
                break;
            case "RetiradaNaLoja":
                estrategiaSelecionada = new RetiradaNaLoja();
                break;
            case "FreteTransportadora":
                estrategiaSelecionada = new FreteTransportadora();
                break;
            default:
                // Estratégia padrão de segurança (opcional)
                estrategiaSelecionada = new FretePadrao();
                break;
        }

        // 4. Criar o contexto (Carrinho) passando a estratégia
        Carrinho carrinho = new Carrinho(estrategiaSelecionada);

        // 5. Calcular e exibir o total
        double total = carrinho.calcularTotalCompra(valorItens, peso, distancia);

        System.out.printf(Locale.US, "%.2f\n", total);

        sc.close();
    }
}