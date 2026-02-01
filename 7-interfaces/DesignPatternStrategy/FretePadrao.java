public class FretePadrao implements FreteStrategy {
    @Override
    public double calcularFrete(double pesoEmKg, double distanciaEmKm) {
        // Custo = 5.0 + (pesoEmKg * 1.0)
        return 5.0 + (pesoEmKg * 1.0);
    }
}