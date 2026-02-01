public interface MeioEntrega {
    int getPrazo();

    double calcularFrete(double valorCarrinho, double distancia);
}