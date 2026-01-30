public class ProdutoEmpacotado extends Produto {
    private int quantidadeComprada;
    private int quantidadeVendida;
    private double precoCompra;
    private double precoVenda;

    public ProdutoEmpacotado(String nome, int qtdComprada, int qtdVendida, double precoCompra, double precoVenda) {
        super(nome);
        this.quantidadeComprada = qtdComprada;
        this.quantidadeVendida = qtdVendida;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
    }

    @Override
    public double entrada() {
        return quantidadeVendida * precoVenda;
    }

    @Override
    public double custo() {
        return quantidadeComprada * precoCompra;
    }
}