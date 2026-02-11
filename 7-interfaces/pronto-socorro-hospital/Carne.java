public class Carne implements MetodoPagamento {
    @Override
    public double custoMetodoPagamento(double custoBase) {
        return 0.25 * custoBase + custoBase;
    }
}
