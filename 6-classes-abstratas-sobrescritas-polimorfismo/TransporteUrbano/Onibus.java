public class Onibus extends Transporte {
    private double distanciaPercorrida;
    private double precoGasolinaPorKm;
    private int numeroPassageiros;
    private double precoPassagem;

    public Onibus(double custoBase, double distanciaPercorrida, double precoGasolinaPorKm, int numeroPassageiros,
            double precoPassagem) {
        super(custoBase);
        this.distanciaPercorrida = distanciaPercorrida;
        this.precoGasolinaPorKm = precoGasolinaPorKm;
        this.numeroPassageiros = numeroPassageiros;
        this.precoPassagem = precoPassagem;
    }

    @Override
    public String nome() {
        return "Onibus";
    }

    @Override
    public double lucratividade() {
        return this.numeroPassageiros * this.precoPassagem
                * (this.custoBase + this.distanciaPercorrida * this.precoGasolinaPorKm);
    }
}
