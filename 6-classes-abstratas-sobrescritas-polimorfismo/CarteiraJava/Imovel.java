public class Imovel extends Investimento {
    private double area; // Lido da entrada, mas não usado no cálculo financeiro direto
    private double taxaValorizacao;
    private double aluguelMensal;
    private int tempoMeses;

    public Imovel(String nome, double investimentoInicial, double area, double taxaValorizacao, double aluguelMensal, int tempoMeses) {
        super(nome, investimentoInicial);
        this.area = area;
        this.taxaValorizacao = taxaValorizacao;
        this.aluguelMensal = aluguelMensal;
        this.tempoMeses = tempoMeses;
    }

    @Override
    public double retorno() {
        double valorFinalImovel = this.investimentoInicial * Math.pow(1 + taxaValorizacao, tempoMeses);
        
        double totalAlugueis = aluguelMensal * tempoMeses;

        return (valorFinalImovel + totalAlugueis) - this.investimentoInicial;
    }
}