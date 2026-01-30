public abstract class Transporte {
    protected double custoBase;

    public Transporte(double custoBase) {
        this.custoBase = custoBase;
    }

    public abstract String nome();

    public abstract double lucratividade();
}