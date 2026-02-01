public class Pix implements MetodoPagamento {
    @Override
    public double calcularValorFinal(double valorTotalComFrete) {
        return valorTotalComFrete * 0.90; // 10% desconto
    }
}