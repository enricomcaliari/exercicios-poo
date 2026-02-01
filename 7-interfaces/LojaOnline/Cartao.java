public class Cartao implements MetodoPagamento {
    @Override
    public double calcularValorFinal(double valorTotalComFrete) {
        return valorTotalComFrete; // Não altera o preço
    }
}