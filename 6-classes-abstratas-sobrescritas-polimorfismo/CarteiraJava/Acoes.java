public class Acoes extends Investimento {
    private double taxaVariacao;

    public Acoes(String nome, double investimentoInicial, double taxaVariacao) {
        super(nome, investimentoInicial);
        this.taxaVariacao = taxaVariacao;
    }

    @Override
    public double retorno() {
        return this.investimentoInicial * taxaVariacao;
    }
}