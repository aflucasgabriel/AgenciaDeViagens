package Agencia;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

public class PassagemAerea extends Passagem{
    Random r = new Random();
    private ArrayList<String> avaliacoes;
    private String companhiaAerea;
    private String classe;
    private int numVoo;
    private int numAssento;
    private int quantAssentos = 0;

    public PassagemAerea(String origem, Destino destino, LocalDate dataIda, LocalDate dataVolta, double preco, String companhiaAerea, int numAssento) {
        super(origem, destino, dataIda, dataVolta, numAssento);
        this.companhiaAerea = companhiaAerea;
        this.classe = classe;
        this.numVoo = r.nextInt(1000 ,8000);
        this.quantAssentos++;
        this.avaliacoes = new ArrayList<>();

    }



    public int getNumVoo() {
        return numVoo;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }



    @Override
    public void calculaPreco(){
        double valorTotal = getPreco();
        if (getClasse().equalsIgnoreCase("economica")){
            valorTotal = super.getPreco() + (super.getPreco() * 0.5);
            valorTotal += calculaTarifa();
            super.setPreco(valorTotal);

        } else if (classe.equalsIgnoreCase("executiva")) {
            valorTotal = super.getPreco() + (super.getPreco() * 1.2);
            valorTotal += calculaTarifa();
            super.setPreco(valorTotal);

        }

    }

    public int getNumAssento() {
        return numAssento;
    }

    public void setNumAssento(int numAssento) {
        this.numAssento = numAssento;
    }

    @Override
    public boolean verificaDisponibilidade(){
        if (quantAssentos < 25){
            return true;
        }
        return false;
    }

    public void adicionarBagagemExtra(int quantidadeBags) {

        double precoBagagemExtra = 50.0;
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

        String relatorio = "Companhia Aera: " + companhiaAerea +
        "\nOrigem: " + getOrigem() +
        "\nDestino: " + getDestino() +
        "\nNumero Assento = " + numAssento +
        "\nData Ida: " + getDataIda() +
        "\nData Volta: " + getDataVolta() +
        "\nPreço Passagem + Tarifas: R$" + getPreco();

        return relatorio;
    }



}
