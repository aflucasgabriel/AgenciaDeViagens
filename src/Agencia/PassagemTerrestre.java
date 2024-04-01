package Agencia;

import java.time.LocalDate;
import java.util.Random;

public class PassagemTerrestre extends Passagem{

    Random r = new Random();
    private String companhia;
    public int numRota;
    private int numAssento;
    private int quantAssentos = 0;

    public PassagemTerrestre(String origem, Destino destino, LocalDate dataIda, LocalDate dataVolta, double preco, String companhia, int numAssento) {
        super(origem, destino, dataIda, dataVolta, preco);
        this.companhia = companhia;
        this.numAssento = numAssento;
        this.numRota = r.nextInt(1000, 8000);
        this.quantAssentos++;
    }

    @Override
    public void calculaPreco(){
            double valorTotal = getPreco();

            valorTotal += calculaTarifa();
            super.setPreco(valorTotal);
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
    public void relatorio(){

        System.out.println("Companhia Aera: " + companhiaAerea);
        System.out.println("Origem: " + getOrigem());
        System.out.println("Destino: " + getDestino());
        System.out.println("Numero Assento = " + numAssento);
        System.out.println("Data Ida: " + getDataIda());
        System.out.println("Data Volta: " + getDataVolta());
        System.out.println("Preço Passagem + Tarifas: R$" + getPreco());

    }
}
