import java.util.Scanner;

public class Restaurante {

    private String nome;
    private Produto p1;
    private Produto p2;
    private Produto p3;

    Restaurante(String nome, Produto p1, Produto p2, Produto p3) {

        this.nome = nome;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    String get_nome() {

        return this.nome;
    }

    float valor_vendas() {

        float valor = 0;

        valor += this.p1.valor_vendas();
        valor += this.p2.valor_vendas();
        valor += this.p3.valor_vendas();

        return valor;
    }

    float custo() {

        float valor = 0;

        valor += this.p1.custo_producao();
        valor += this.p2.custo_producao();
        valor += this.p3.custo_producao();

        return valor;
    }

    float lucro() {

        float valor = 0;

        valor += this.p1.lucro();
        valor += this.p2.lucro();
        valor += this.p3.lucro();

        return valor;
    }

    Produto mais_vendido() {

        if (this.p1.lucro() >= this.p2.lucro() && this.p1.lucro() >= this.p3.lucro()) {

            return this.p1;
        }

        else if (this.p2.lucro() >= this.p1.lucro() && this.p2.lucro() >= this.p3.lucro()) {

            return this.p2;
        }

        else {

            return this.p3;
        }
    }
}