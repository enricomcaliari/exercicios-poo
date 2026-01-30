public class CarneAcougue extends ProdutoPorPeso {
    private double custoAcougueiro;

    public CarneAcougue(String nome, double kgComprados, double kgVendidos, double precoCompra, double precoVenda,
            double custoAcougueiro) {
        super(nome, kgComprados, kgVendidos, precoCompra, precoVenda);
        this.custoAcougueiro = custoAcougueiro;
    }

    @Override
    public double custo() {
        // Custo base (peso * preço) + custo do funcionário
        return super.custo() + custoAcougueiro;
    }
}