public class Enfermeiro extends Funcionario {
    public Enfermeiro(String nome, int cpf) {
        super(nome, cpf);
        this.pagamento = 90;
    }

    public void atualizaPagamento() {
        this.pagamento += 20;
    }
}
