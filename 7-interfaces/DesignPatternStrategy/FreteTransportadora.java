public class FreteTransportadora implements FreteStrategy {
    @Override
    public double calcularFrete(double pesoEmKg, double distanciaEmKm) {
        // Custo = (pesoEmKg * 1.8) + (distanciaEmKm * 0.5)
        return (pesoEmKg * 1.8) + (distanciaEmKm * 0.5);
    }
}