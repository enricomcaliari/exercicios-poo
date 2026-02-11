public class Paciente {
    private String nome;
    private int cpf;
    private int senha;
    private ProvedorDeSaude provedor;
    private Enfermeiro enfermeiroResponsavel;
    private String gravidade;
    private MetodoPagamento metodoPagamento;

    public Paciente(String nome, int cpf, int senha, ProvedorDeSaude provedor, Enfermeiro enfermeiroResponsavel,
            String gravidade, MetodoPagamento metodoPagamento) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.provedor = provedor;
        this.enfermeiroResponsavel = enfermeiroResponsavel;
        this.gravidade = gravidade;
        this.metodoPagamento = metodoPagamento;
    }

    public String getNome() {
        return nome;
    }

    public int getSenha() {
        return senha;
    }

    public Enfermeiro getEnfermeiroResponsavel() {
        return enfermeiroResponsavel;
    }

    public ProvedorDeSaude getProvedor() {
        return provedor;
    }

    public String getGravidade() {
        return gravidade;
    }

    public MetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }
}