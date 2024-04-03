package Agencia;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Passagem {

    private String origem;
    private Destino destino;
    private LocalDate dataIda;
    private LocalDate dataVolta;
    private double preco;
    private int numAssento;


    public Passagem(String origem, Destino destino, LocalDate dataIda, LocalDate dataVolta, int numAssento) {
        this.origem = origem;
        this.destino = destino;
        this.dataIda = dataIda;
        this.dataVolta = dataVolta;
        this.preco = destino.getPreco();
        this.numAssento = numAssento;
    }

    public int getNumAssento() {
        return numAssento;
    }

    public void setNumAssento(int numAssento) {
        this.numAssento = numAssento;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public LocalDate getDataIda() {
        return dataIda;
    }

    public void setDataIda(LocalDate dataIda) {
        this.dataIda = dataIda;
    }

    public LocalDate getDataVolta() {
        return dataVolta;
    }

    public void setDataVolta(LocalDate dataVolta) {
        this.dataVolta = dataVolta;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    public abstract void calculaPreco();
    public abstract boolean verificaDisponibilidade();

    public abstract double calculaTarifa();
    public abstract void relatorioAvaliacao(String avaliacao);
    public abstract String relatorioPassagem();

}
