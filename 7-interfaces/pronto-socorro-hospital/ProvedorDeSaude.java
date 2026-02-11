public interface ProvedorDeSaude {
    double calculaPagamentoHospital(double custoBase);
    
    double calculaPagamentoPaciente(double custoBase, MetodoPagamento metodoPagamento);
}