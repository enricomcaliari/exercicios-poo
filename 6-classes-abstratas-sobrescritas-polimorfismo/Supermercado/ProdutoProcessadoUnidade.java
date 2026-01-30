public class ProdutoProcessadoUnidade extends ProdutoProcessado {
    private double precoUnidade;
    private int unidadesVendidas;

    public ProdutoProcessadoUnidade(String nome, double qtdProduzida, double custoMateria, double custoFunc,
            double precoUnidade, int unidadesVendidas) {
        super(nome, qtdProduzida, custoMateria, custoFunc);
        this.precoUnidade = precoUnidade;
        this.unidadesVendidas = unidadesVendidas;
    }

    @Override
    public double entrada() {
        return precoUnidade * unidadesVendidas;
    }
}