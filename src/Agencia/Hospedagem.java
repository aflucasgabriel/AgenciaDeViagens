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

    public int getNumDias() {
        return numDias;
    }

    public void setNumDias(int numDias) {
        this.numDias = numDias;
    }

    public int getQuartosDisponiveis() {
        return QuartosDisponiveis;
    }

    public void setQuartosDisponiveis(int quartosDisponiveis) {
        QuartosDisponiveis = quartosDisponiveis;
    }

    public void setServicosInclusos(List<String> servicosInclusos) {
        this.servicosInclusos = servicosInclusos;
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

    public void setPrecoDiario(double precoDiario) {
        PrecoDiario = precoDiario;
    }
    //método calcular preço

    public double calcularPreco() {
        return PrecoDiario * getNumDias();
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

    public String relatorioHospedagem(){
        String relatorio = "\nNome do Hotel: " + nomeHotel+
        "\nLocalizacao: " + localizacao+
        "\nServicos inclusos: " +servicosInclusos+
        "\nAvaliaçoes: " +avaliacoes+
        "\nData inicial: "+dataInicial+
        "\nData Final: " +dataFinal+
        "\nPreco diario:" + PrecoDiario;

        return relatorio;

    }



}

