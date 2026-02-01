public class Medicacao {
    private String nome;
    private double custo;

    public Medicacao(String nome, double custo) {
        this.nome = nome;
        this.custo = custo;
    }

    public String getNome() {
        return nome;
    }

    public double getCusto() {
        return custo;
    }
}