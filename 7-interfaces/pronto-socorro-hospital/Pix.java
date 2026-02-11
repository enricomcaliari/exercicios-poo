public class Pix implements MetodoPagamento {
    @Override
    public double custoMetodoPagamento(double custoBase) {
        return custoBase - (0.15 * custoBase);
    }
}
