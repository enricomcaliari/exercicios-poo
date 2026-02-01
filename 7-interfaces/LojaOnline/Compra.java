import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Compra {
    private Carrinho carrinho;
    private Cliente cliente;
    private MeioEntrega entrega;
    private MetodoPagamento pagamento;
    private List<Notificador> notificadores = new ArrayList<>();

    public Compra(Cliente cliente, Carrinho carrinho) {
        this.cliente = cliente;
        this.carrinho = carrinho;
    }

    public void setEntrega(MeioEntrega entrega) {
        this.entrega = entrega;
    }

    public void setPagamento(MetodoPagamento pagamento) {
        this.pagamento = pagamento;
    }

    public void addNotificador(Notificador notificador) {
        notificadores.add(notificador);
    }

    public void finalizar() {
        // 1. Cálculos
        double somaItens = carrinho.total();
        double valorFrete = entrega.calcularFrete(somaItens, cliente.getDistancia());
        double totalComFrete = somaItens + valorFrete;
        double valorFinal = pagamento.calcularValorFinal(totalComFrete);
        int prazo = entrega.getPrazo();

        // 2. Notificações
        for (Notificador n : notificadores) {
            n.notificar(cliente, valorFinal, prazo);
        }

        // 3. Nota Fiscal (Impressão na tela)
        for (Produto p : carrinho.getProdutos()) {
            System.out.printf(Locale.US, "%s %.2f%n", p.getNome(), p.getValor());
        }
        
        System.out.printf(Locale.US, "soma dos itens: %.2f%n", somaItens);
        System.out.printf(Locale.US, "frete: %.2f%n", valorFrete);
        System.out.printf(Locale.US, "total com frete: %.2f%n", totalComFrete);
        System.out.printf(Locale.US, "valor total: %.2f%n", valorFinal);
    }
}