package com.example.trabalho;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Hospedagem {
    // atributos 
    private String nomeHotel;
    private String localizacao;
    private int NumPessoasQuarto;
    private int QuartosDisponiveis;
    private List<String> servicosInclusos;
    private List<String> avaliacoes;
    private Date dataInicial;
    private Date dataFinal;
    private double PrecoDiario;



    public Hospedagem(String nomeHotel,String localizacao,int NumPessoasQuarto, int QuartosDisponiveis, List<String> servicosInclusos, Date dataInicial, Date dataFinal,double PrecoDiario){

        this.nomeHotel = nomeHotel;
        this.localizacao = localizacao;
        this.NumPessoasQuarto = NumPessoasQuarto;
        this.QuartosDisponiveis = QuartosDisponiveis;
        this.servicosInclusos = servicosInclusos;
        this.avaliacoes = new ArrayList<>();
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.PrecoDiario = PrecoDiario;


    }

    //método calcular preço

    public double calcularPreco(int numDias) {
        return PrecoDiario * numDias;
    }

    //método reservar 

    public boolean reservar(int numQuartos){
        if (QuartosDisponiveis >= numQuartos){
        QuartosDisponiveis -= numQuartos;
            return true;
        }
        return false;
    }

    //cancelar 

    public void cancelar(int numQuartos){
        QuartosDisponiveis += numQuartos;
    }

    public void relatotioAvaliacao(String avaliacao){
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

