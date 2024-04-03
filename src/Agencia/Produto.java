package Agencia;


import java.util.ArrayList;
import java.util.Random;

public class Produto {
    Random r = new Random();
    private Passagem passagem;
    private Destino destino;
    private Hospedagem hospedagem;
    public ArrayList<Atracao> atracao;
    private int id;
    private String nome;
    private String descricao;
    private double preco;



    public Produto(String nome, String descricao, Passagem passagem, Hospedagem hospedagem, ArrayList<Atracao> atracao) {
        this.id = r.nextInt(100, 1000);
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
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

    public ArrayList<Atracao> getAtracao() {
        return atracao;
    }

    public void setAtracao(ArrayList<Atracao> atracao) {
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


    public double calculaPreco() {
        double total = 0;

        if (passagem == null) {
            passagem.setPreco(0);
        } else {
            total += passagem.getPreco();
        }

        if (hospedagem == null) {
            hospedagem.setPrecoDiario(0);
        } else {
            total += hospedagem.calcularPreco();
        }

        if (atracao != null) {
            for (Atracao a : atracao) {
                if (a != null) {
                    total += a.getPreco();
                }
            }
        }

        return total;
    }



    public String relatorio() {
        return "Id=" + id +
                "\nNome='" + nome +
                "\nDescricao='" + descricao +
                "\nPreco=" + calculaPreco();


    }


}
