package Agencia;

import java.util.ArrayList;

public class Atracao {
    private Destino destino;
    private String nomeAtracao;
    private String descricao;
    private String horario;
    private double preco;
    private String tipo;
    private int lotacao;
    private ArrayList<String> avaliacoes;
    int lotacaoMaxima = 25;

    public Atracao(String nomeAtracao, String descricao, String horario, double preco, String tipo, Destino destino) {
        this.nomeAtracao = nomeAtracao;
        this.descricao = descricao;
        this.horario = horario;
        this.preco = preco;
        this.tipo = tipo;
        this.destino = destino;
        this.avaliacoes = new ArrayList<>();

    }

    public String getNomeAtracao() {
        return nomeAtracao;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getHorario() {
        return horario;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean verificarDisponibilidade(){

        if (lotacao < lotacaoMaxima){
            return true;
        }
        return false;
    }

    public boolean reservar(){

        if (lotacao < lotacaoMaxima) {
            lotacao++;
            return true;
        } else {
            return false;
        }
    }

    public boolean cancelar(){

        if (lotacao > 0) {
            lotacao--;
            return true;
        } else {
            return false;
        }
    }

    public void relatorioAvaliacao(String avaliacao){
        avaliacoes.add(avaliacao);
    }


    public String relatorioAtracao() {
        return "Nome: " + nomeAtracao +
                "\nHorario Funcionamento: " + horario +
                "\nDescrição: " + descricao +
                "\nPreco: R$" + preco  +
                "\nTipo de atração: " + tipo +
                "\nLotado: " + verificarDisponibilidade();
    }
}
