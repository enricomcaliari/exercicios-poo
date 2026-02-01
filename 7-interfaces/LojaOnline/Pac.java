public class Pac implements MeioEntrega {
    @Override
    public int getPrazo() {
        return 15;
    }

    @Override
    public double calcularFrete(double valorCarrinho, double distancia) {
        // 5% do valor da compra + 0.05 * distância
        return (valorCarrinho * 0.05) + (0.05 * distancia);
    }
}