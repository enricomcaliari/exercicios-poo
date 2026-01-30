public class RendaFixa extends Investimento {
    private int tempoMeses;
    private double taxaMensal;

    public RendaFixa(String nome, double investimentoInicial, int tempoMeses, double taxaMensal) {
        super(nome, investimentoInicial);
        this.tempoMeses = tempoMeses;
        this.taxaMensal = taxaMensal;
    }

    @Override
    public double retorno() {
        return this.investimentoInicial * Math.pow(1 + taxaMensal, tempoMeses);
    }
}