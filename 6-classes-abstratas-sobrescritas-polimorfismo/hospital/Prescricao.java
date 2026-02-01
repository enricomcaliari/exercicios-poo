public class Prescricao {
    private Medicacao medicacao;
    private int doses;

    public Prescricao(Medicacao medicacao, int doses) {
        this.medicacao = medicacao;
        this.doses = doses;
    }

    public Medicacao getMedicacao() {
        return medicacao;
    }

    public int getDoses() {
        return doses;
    }
}