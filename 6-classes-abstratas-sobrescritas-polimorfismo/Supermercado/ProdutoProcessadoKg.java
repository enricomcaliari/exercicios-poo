public class ProdutoProcessadoKg extends ProdutoProcessado {
    private double precoKgVenda;
    private double kgVendidos;

    public ProdutoProcessadoKg(String nome, double qtdProduzida, double custoMateria, double custoFunc,
            double precoKgVenda, double kgVendidos) {
        super(nome, qtdProduzida, custoMateria, custoFunc);
        this.precoKgVenda = precoKgVenda;
        this.kgVendidos = kgVendidos;
    }

    @Override
    public double entrada() {
        return precoKgVenda * kgVendidos;
    }
}