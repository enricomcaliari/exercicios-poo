public class Carne implements MetodoPagamento {
    @Override
    public double calcularValorFinal(double valorTotalComFrete) {
        return valorTotalComFrete * 1.20; // 20% juros
    }
}