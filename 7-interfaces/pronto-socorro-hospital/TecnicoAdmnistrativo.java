public class TecnicoAdmnistrativo extends Funcionario {
    private int tempoCasa;

    public TecnicoAdmnistrativo(String nome, int cpf, int tempoCasa) {
        super(nome, cpf);
        this.tempoCasa = tempoCasa;
        this.pagamento = 100 + 5 * tempoCasa;
    }

    void atualizaPagamento() {

    }
}