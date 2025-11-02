import java.util.Scanner;

public class Rede {

    private String nome;
    private Restaurante r1;
    private Restaurante r2;

    Rede(String nome, Restaurante r1, Restaurante r2) {

        this.nome = nome;
        this.r1 = r1;
        this.r2 = r2;
    }

    float valor_vendas() {

        return this.r1.valor_vendas() + this.r2.valor_vendas();
    }

    float custo() {

        return this.r1.custo() + this.r2.custo();
    }

    float lucro() {

        return this.r1.lucro() + this.r2.lucro();
    }

    Produto mais_vendido() {

        if (this.r1.mais_vendido().qtd_vendas() >= this.r2.mais_vendido().qtd_vendas()) {

            return this.r1.mais_vendido();
        }

        else {

            return this.r2.mais_vendido();
        }
    }

    Restaurante mais_lucrativo() {

        if (this.r1.lucro() >= this.r2.lucro()) {

            return this.r1;
        }

        else {

            return this.r2;
        }
    }
}