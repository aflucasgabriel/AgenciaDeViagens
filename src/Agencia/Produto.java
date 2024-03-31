package Agencia;


public class Produto{
    private double preco;
    private Hospedagem hospedagem;
    private Atracao atracoes;
    private Destino destino;


    public Produto(double preco, Destino destino, Hospedagem hospedagem, Atracao atracoes) {
        this.preco = preco;
        this.hospedagem = hospedagem;
        this.atracoes = atracoes;
        this.destino = destino;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }



    public double calcularPrecoTotal() {

        double total = hospedagem.calcularPreco() + atracoes.getPreco() + destino.getPreco();
        return total;
    }
    
}
