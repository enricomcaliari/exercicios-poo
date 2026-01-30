public abstract class Investimento {
    protected String nome;
    protected double investimentoInicial;

    public Investimento(String nome, double investimentoInicial) {
        this.nome = nome;
        this.investimentoInicial = investimentoInicial;
    }

    public String getNome() {
        return nome;
    }

    public abstract double retorno();
}