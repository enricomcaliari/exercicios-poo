public class Sedex implements MeioEntrega {
    @Override
    public int getPrazo() {
        return 5;
    }

    @Override
    public double calcularFrete(double valorCarrinho, double distancia) {
        // 20% do valor da compra + 0.1 * distância
        return (valorCarrinho * 0.25) + (0.10 * distancia);
    }
}