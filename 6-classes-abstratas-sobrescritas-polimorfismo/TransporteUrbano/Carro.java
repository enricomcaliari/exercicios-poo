public class Carro extends Transporte {
    private double taxaDesvalorizacao;
    private double distanciaPercorrida;
    private double precoGasolinaPorKm;
    private double precoManutencaoPorKm;

    public Carro(double custoBase, double taxaDesvalorizacao, double distanciaPercorrida, double precoGasolinaPorKm, double precoManutencaoPorKm) {
        super(custoBase);
        this.taxaDesvalorizacao = taxaDesvalorizacao;
        this.distanciaPercorrida = distanciaPercorrida;
        this.precoGasolinaPorKm = precoGasolinaPorKm;
        this.precoManutencaoPorKm = precoManutencaoPorKm;
    }

    @Override
    public String nome() {
        return "Carro";
    }

    @Override
    public double lucratividade() {
        return this.custoBase * this.taxaDesvalorizacao
                * (this.custoBase + this.distanciaPercorrida * this.precoGasolinaPorKm
                        + this.distanciaPercorrida * this.precoManutencaoPorKm);
    }
}
