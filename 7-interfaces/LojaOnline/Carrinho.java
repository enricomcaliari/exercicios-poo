import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<Produto> produtos = new ArrayList<>();

    public void add(Produto p) {
        produtos.add(p);
    }

    public double total() {
        double soma = 0;
        for (Produto p : produtos) {
            soma += p.getValor();
        }
        return soma;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}