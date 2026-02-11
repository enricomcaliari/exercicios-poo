public class Hospital {
    private double custoTotal;

    public Hospital() {
        this.custoTotal = 0;
    }

    public void atualizaCustoTotal(double valor) {
        this.custoTotal += valor;
    }

    public double getCustoTotal() {
        return custoTotal;
    }
}