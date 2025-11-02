import java.util.Scanner;

public class Produto {

    private String nome;
    private int estoqueDiario;
    private int numVendas;
    private float custo;
    private float preco;

    Produto(String nome, int estoqueDiario, int numVendas, float custo, float preco) {

        this.nome = nome;
        this.estoqueDiario = estoqueDiario;
        this.numVendas = numVendas;
        this.custo = custo;
        this.preco = preco;
    }

    String get_nome() {

        return this.nome;
    }

    int get_numVendas() {

        return this.numVendas;
    }

    int qtd_vendas() {

        return this.numVendas;
    }

    float valor_vendas() {

        return this.numVendas * this.preco;
    }

    float custo_producao() {

        return this.estoqueDiario * this.custo;
    }

    float lucro() {

        return this.valor_vendas() - this.custo_producao();
    }
}
