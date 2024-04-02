package Agencia;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Hospedagem{
    // atributos 
    private String nomeHotel;
    private String localizacao;
    private int NumPessoasQuarto;
    private int QuartosDisponiveis;
    private List<String> servicosInclusos;
    private List<String> avaliacoes;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private int numDias;
    private double PrecoDiario;



    public Hospedagem(String nomeHotel, String localizacao, LocalDate dataInicial, LocalDate dataFinal, double PrecoDiario, int QuartosDisponiveis, List<String> servicosInclusos){
        //this.numDias = numDias;
        this.nomeHotel = nomeHotel;
        this.localizacao = localizacao;
        this.QuartosDisponiveis = QuartosDisponiveis;
        this.servicosInclusos = servicosInclusos;
        this.avaliacoes = new ArrayList<>();
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.PrecoDiario = PrecoDiario;
    }


    public String getNomeHotel() {
        return nomeHotel;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public List<String> getServicosInclusos() {
        return servicosInclusos;
    }

    public double getPrecoDiario() {
        return PrecoDiario;
    }

    //método calcular preço

    public double calcularPreco() {
        return PrecoDiario * numDias;
    }

    //método reservar 

    public boolean reservar(){
        if (QuartosDisponiveis >= 0){
        QuartosDisponiveis --;
            return true;
        }
        return false;
    }

    //cancelar 

    public boolean cancelar(){

        QuartosDisponiveis ++;
        boolean b = !reservar();

        return b;
    }

    public void relatorioAvaliacao(String avaliacao){
        avaliacoes.add(avaliacao);
    }

    public void relatorio(){
        System.out.println("Nome do Hotel: " + nomeHotel);
        System.out.println("Localizacao: " + localizacao);
        System.out.println("Numero de pessoas por quarto: " + NumPessoasQuarto);
        System.out.println("Quartos Disponíveis: "+ QuartosDisponiveis);
        System.out.println("Servicos inclusos: " +servicosInclusos);
        System.out.println("Avaliaçoes: " +avaliacoes);
        System.out.println("Data inicial: "+dataInicial);
        System.out.println("Data Final: " +dataFinal);
        System.out.println("Preco diario:" + PrecoDiario);
    }



}

