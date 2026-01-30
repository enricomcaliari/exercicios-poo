public abstract class ProdutoProcessado extends Produto {
    protected double qtdProduzida;
    protected double custoMateriaPrimaPorQtd;
    protected double custoFuncionario;

    public ProdutoProcessado(String nome, double qtdProduzida, double custoMateria, double custoFunc) {
        super(nome);
        this.qtdProduzida = qtdProduzida;
        this.custoMateriaPrimaPorQtd = custoMateria;
        this.custoFuncionario = custoFunc;
    }

    @Override
    public double custo() {
        return (qtdProduzida * custoMateriaPrimaPorQtd) + custoFuncionario;
    }
}