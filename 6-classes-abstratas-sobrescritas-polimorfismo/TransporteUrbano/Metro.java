public class Metro extends Transporte {
    private int numeroPassageiros;
    private double receitaPorPassageiro;

    public Metro(double custoBase, int numeroPassageiros, double receitaPorPassageiro) {
        super(custoBase);
        this.numeroPassageiros = numeroPassageiros;
        this.receitaPorPassageiro = receitaPorPassageiro;
    }

    @Override
    public String nome() {
        return "Metro";
    }

    @Override
    public double lucratividade() {
        return this.receitaPorPassageiro * this.numeroPassageiros - this.custoBase;
    }
}
