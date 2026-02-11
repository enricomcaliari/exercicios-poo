public abstract class Funcionario {
    protected String nome;
    protected int cpf;
    protected double pagamento;

    protected Funcionario(String nome, int cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.pagamento = 0;
    }

    public String getNome() {
        return this.nome;
    }

    public double getPagamento() {
        return this.pagamento;
    }

    abstract void atualizaPagamento();
}
