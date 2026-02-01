public class Sedex10 implements MeioEntrega {
    @Override
    public int getPrazo() {
        return 1;
    }

    @Override
    public double calcularFrete(double valorCarrinho, double distancia) {
        // 50% do valor da compra + 0.75 * distância
        return (valorCarrinho * 0.50) + (0.75 * distancia);
    }
}