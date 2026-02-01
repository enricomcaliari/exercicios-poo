public class Medico {
    private String nome;
    private int cpf;
    private int consultorio;
    private double pagamento;

    public Medico(String nome, int cpf, int consultorio) {
        this.nome = nome;
        this.cpf = cpf;
        this.consultorio = consultorio;
        this.pagamento = 0;
    }

    public void atualizaPagamento(double valor) {
        this.pagamento += valor;
    }

    public String getNome() {
        return nome;
    }

    public int getConsultorio() {
        return consultorio;
    }

    public double getPagamento() {
        return pagamento;
    }
}