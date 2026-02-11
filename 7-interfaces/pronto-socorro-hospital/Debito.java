public class Debito implements MetodoPagamento {
    @Override
    public double custoMetodoPagamento(double custoBase) {
        return custoBase + 2;
    }
}
