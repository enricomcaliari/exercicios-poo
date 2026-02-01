public class FreteExpresso implements FreteStrategy {
    @Override
    public double calcularFrete(double pesoEmKg, double distanciaEmKm) {
        // Custo = 10.0 + (pesoEmKg * 2.5) + (distanciaEmKm * 0.1)
        return 10.0 + (pesoEmKg * 2.5) + (distanciaEmKm * 0.1);
    }
}