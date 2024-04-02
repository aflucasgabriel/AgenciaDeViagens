package Agencia;


import java.util.Random;

public class Produto {
    Random r = new Random();
    private Passagem passagem;
    private Destino destino;
    private Hospedagem hospedagem;
    private Atracao atracao;
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private TipoProduto tipo;


    public Produto(String nome, String descricao, double preco, Passagem passagem, Hospedagem hospedagem, Atracao atracao) {
        this.id = r.nextInt(100, 1000);
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.tipo = tipo;
        this.passagem = passagem;
        this.hospedagem = hospedagem;
        this.atracao = atracao;
    }

    public Passagem getPassagem() {
        return passagem;
    }

    public void setPassagem(Passagem passagem) {
        this.passagem = passagem;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public Hospedagem getHospedagem() {
        return hospedagem;
    }

    public void setHospedagem(Hospedagem hospedagem) {
        this.hospedagem = hospedagem;
    }

    public Atracao getAtracao() {
        return atracao;
    }

    public void setAtracao(Atracao atracao) {
        this.atracao = atracao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public TipoProduto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProduto tipo) {
        this.tipo = tipo;
    }


    public double calculaPreco() {

        double total = 0;
        total = atracao.getPreco() + passagem.getPreco() + destino.getPreco() + hospedagem.calcularPreco();
        return total;


    }


    public String relatorio() {
        return "Id=" + id +
                "\nNome='" + nome +
                "\nDescricao='" + descricao +
                "\nPreco=" + preco +
                "\nTipo=" + tipo;

    }


}
