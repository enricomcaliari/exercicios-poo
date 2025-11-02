public class Produto {
    private String nome;
    private int estoque;
    private double valor;
    private double desconto;
    private int total_vendas;

    public Produto(String nome, int estoque, double valor, double desconto) {
        this.nome = nome;
        this.estoque = estoque;
        this.valor = valor;
        this.desconto = desconto;
        this.total_vendas = 0;
    }

    public void compra(int qtd) {
        if (qtd <= 0) {
            System.out.println("VALOR INVALIDO");
            return;
        }
        this.estoque += qtd;
    }

    public void venda(int qtd) {
        if (qtd <= 0 || qtd > this.estoque) {
            System.out.println("VALOR INVALIDO");
            return;
        }
        this.estoque -= qtd;
        this.total_vendas += qtd;
    }

    public double preco() {
        return this.valor * (1 - this.desconto);
    }

    public double valor_vendas() {
        return this.total_vendas * preco();
    }

    public String getNome() {
        return nome;
    }

    public int getEstoque() {
        return estoque;
    }

    public double getValor() {
        return valor;
    }

    public double getDesconto() {
        return desconto;
    }
}