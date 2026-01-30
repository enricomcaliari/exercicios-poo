public abstract class Produto {
    protected String nome;

    public Produto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public abstract double custo();

    public abstract double entrada(); // Receita

    public double lucro() {
        return entrada() - custo();
    }
}