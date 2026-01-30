public class ProdutoPorPeso extends Produto {
    protected double kgComprados;
    protected double kgVendidos;
    protected double precoPorKgCompra;
    protected double precoPorKgVenda;

    public ProdutoPorPeso(String nome, double kgComprados, double kgVendidos, double precoPorKgCompra, double precoPorKgVenda) {
        super(nome);
        this.kgComprados = kgComprados;
        this.kgVendidos = kgVendidos;
        this.precoPorKgCompra = precoPorKgCompra;
        this.precoPorKgVenda = precoPorKgVenda;
    }

    @Override
    public double entrada() {
        return kgVendidos * precoPorKgVenda;
    }

    @Override
    public double custo() {
        return kgComprados * precoPorKgCompra;
    }
}