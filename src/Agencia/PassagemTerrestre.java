package Agencia;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PassagemTerrestre extends Passagem{

    Random r = new Random();
    private String companhia;
    public int numRota;
    private Destino destino;
    private int numAssento;
    private int quantAssentos = 0;
    private List<String> avaliacoes;

    public PassagemTerrestre(String origem, Destino destino, LocalDate dataIda, LocalDate dataVolta, double preco, String companhia, int numAssento) {
        super(origem, destino, dataIda, dataVolta, numAssento);
        this.companhia = companhia;
        this.numRota = r.nextInt(1000, 8000);
        this.quantAssentos++;
        this.avaliacoes = new ArrayList<>();
        this.destino = destino;
        this.numAssento = numAssento;
    }

    @Override
    public Destino getDestino() {
        return destino;
    }

    @Override
    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    @Override
    public void calculaPreco(){
            double valorTotal = getPreco();

            super.setPreco(valorTotal);
    }

    @Override
    public boolean verificaDisponibilidade(){
        if (quantAssentos < 25){
            return true;
        }
        return false;
    }

    public int getNumAssento() {
        return numAssento;
    }

    public void setNumAssento(int numAssento) {
        this.numAssento = numAssento;
    }

    public void adicionarBagagemExtra(int quantidadeBags) {

        double precoBagagemExtra = 5.0;
        double precoTotalBagagemExtra = quantidadeBags * precoBagagemExtra;
        double novoPreco = super.getPreco() + precoTotalBagagemExtra;
        super.setPreco(novoPreco);
    }

    @Override
    public double calculaTarifa(){


        return getPreco() * 0.1;

    }

    public void cancelarVoo(){
        super.setPreco(0.0);
    }

    @Override
    public void relatorioAvaliacao(String avaliacao){
        avaliacoes.add(avaliacao);
    }

    @Override
    public String relatorioPassagem(){

        String relatorio = "Companhia: " + companhia +
                "\nOrigem: " + getOrigem() +
                "\nNumero Assento = " + numAssento +
                "\nData Ida: " + getDataIda() +
                "\nData Volta: " + getDataVolta() +
                "\nPreço Passagem + Tarifas: R$" + getPreco();

        return relatorio;

    }
}
