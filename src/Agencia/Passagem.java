package Agencia;

import java.time.LocalDate;

public abstract class Passagem {

    private String origem;
    private Destino destino;
    private LocalDate dataIda;
    private LocalDate dataVolta;
    private double preco;

    public Passagem(String origem, Destino destino, LocalDate dataIda, LocalDate dataVolta, double preco) {
        this.origem = origem;
        this.destino = destino;
        this.dataIda = dataIda;
        this.dataVolta = dataVolta;
        this.preco = preco;
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

    public abstract void relatorio();

    public abstract double calculaTarifa();

}
