public class PlanoPremium implements ProvedorDeSaude {
    @Override
    public double calculaPagamentoHospital(double custoBase) {
        return custoBase * 1.2;
    }

    @Override
    public double calculaPagamentoPaciente(double custoBase, MetodoPagamento metodoPagamento) {
        return metodoPagamento.custoMetodoPagamento(2500);
    }
}