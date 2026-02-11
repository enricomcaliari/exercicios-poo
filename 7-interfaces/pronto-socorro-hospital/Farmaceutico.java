public class Farmaceutico extends Funcionario {
    private int tempoCasa;

    public Farmaceutico(String nome, int cpf, int tempoCasa) {
        super(nome, cpf);
        this.tempoCasa = tempoCasa;
        this.pagamento = 150;
        if (tempoCasa % 2 == 0) {
            this.pagamento += 10 * tempoCasa / 2;
        } else {
            this.pagamento += 10 * (tempoCasa - 1) / 2;
        }
    }

    public void atualizaPagamento() {
    }
}
