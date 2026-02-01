public class Product implements Comparable<Product> {
    private String nome;
    private double preco;

    public Product(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public int compareTo(Product other) {
        int comparacaoPreco = Double.compare(this.preco, other.preco);

        if (comparacaoPreco != 0) {
            return comparacaoPreco;
        }

        return this.nome.compareTo(other.nome);
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", nome, preco);
    }
}