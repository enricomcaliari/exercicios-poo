public class Retangulo {
    private int altura;
    private int largura;

    public Retangulo(int altura, int largura) {
        this.altura = altura;
        this.largura = largura;
    }

    public int area() {
        return this.altura * this.largura;
    }

    public int perimetro() {
        return (2 * this.altura) + (2 * this.largura);
    }

    public int getAltura() {
        return this.altura;
    }

    public int getLargura() {
        return this.largura;
    }
}
