public class Credito implements MetodoPagamento {
    public double custoMetodoPagamento(double custoBase) {
        return 0.1 * custoBase + custoBase;
    }
}
