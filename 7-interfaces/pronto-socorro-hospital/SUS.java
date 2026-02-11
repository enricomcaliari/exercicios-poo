public class SUS implements ProvedorDeSaude {
    @Override
    public double calculaPagamentoHospital(double custoBase) {
        return custoBase * 2;
    }

    @Override
    public double calculaPagamentoPaciente(double custoBase, MetodoPagamento metodoPagamento) {
        return 0;
    }
}