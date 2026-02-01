public class Cliente {
    private String nome;
    private String email;
    private String telefone;
    private double distEntrega;

    public Cliente(String nome, String email, String telefone, double distEntrega) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.distEntrega = distEntrega;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public double getDistancia() {
        return distEntrega;
    }
}