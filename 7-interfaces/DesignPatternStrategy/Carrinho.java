public class Carrinho {
    // Composição: O Carrinho TEM UMA estratégia de frete
    private FreteStrategy freteStrategy;

    // Injeção de dependência via construtor
    public Carrinho(FreteStrategy freteStrategy) {
        this.freteStrategy = freteStrategy;
    }

    // Permite trocar a estratégia em tempo de execução (Dynamic Behavior)
    public void setFreteStrategy(FreteStrategy freteStrategy) {
        this.freteStrategy = freteStrategy;
    }

    public double calcularTotalCompra(double valorItens, double peso, double distancia) {
        // O Carrinho delega o cálculo do frete para a estratégia atual
        double custoFrete = this.freteStrategy.calcularFrete(peso, distancia);
        return valorItens + custoFrete;
    }
}