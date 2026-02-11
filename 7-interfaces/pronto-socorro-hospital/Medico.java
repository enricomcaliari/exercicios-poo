public class Medico extends Funcionario {
    private int consultorio;
    private String formacao;

    public Medico(String nome, int cpf, int consultorio, String formacao) {
        super(nome, cpf);
        this.consultorio = consultorio;
        this.formacao = formacao;
    }

    public void atualizaPagamento() {
        this.pagamento += getValorConsulta();
    }

    public String getNome() {
        return nome;
    }

    public int getConsultorio() {
        return consultorio;
    }

    public double getValorConsulta() {
        if (this.formacao.equals("GRADUACAO")) {
            return 100.0;
        } else if (this.formacao.equals("POS")) {
            return 300.0;
        } else if (this.formacao.equals("ESPECIALIZACAO")) {
            return 150.0;
        } else {
            return 200.0;
        }
    }
}