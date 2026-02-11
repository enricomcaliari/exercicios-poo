public class PlanoParticipativo implements ProvedorDeSaude {
    @Override
    public double calculaPagamentoHospital(double custoBase) {
        return custoBase * 1.5;
    }

    @Override
    public double calculaPagamentoPaciente(double custoBase, MetodoPagamento metodoPagamento) {
        double totalBruto = 750 + (custoBase * 0.1);
        return metodoPagamento.custoMetodoPagamento(totalBruto);
    }
}