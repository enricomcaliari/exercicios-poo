public class BicicletaCompartilhada extends Transporte {
    private int horasUtilizadas;
    private double precoPorHora;
    private double custoManutencaoPorHora;

    public BicicletaCompartilhada(double custoBase, int horasUtilizadas, double precoPorHora,
            double custoManutencaoPorHora) {
        super(custoBase);
        this.horasUtilizadas = horasUtilizadas;
        this.precoPorHora = precoPorHora;
        this.custoManutencaoPorHora = custoManutencaoPorHora;
    }

    @Override
    public String nome() {
        return "Bicicleta";
    }

    @Override
    public double lucratividade() {
        return this.horasUtilizadas * this.precoPorHora
                * (this.custoBase + this.custoManutencaoPorHora * this.horasUtilizadas);
    }

}
