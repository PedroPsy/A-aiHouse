package AcaiHouse;

public abstract class Produto {
    protected double valor;
    protected String descricao;

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public abstract double calculaPreco();

}
