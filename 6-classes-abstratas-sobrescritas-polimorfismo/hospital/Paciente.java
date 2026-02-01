public class Paciente {
    private String nome;
    private int cpf;
    private int senha;

    public Paciente(String nome, int cpf, int senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public int getSenha() {
        return senha;
    }
}