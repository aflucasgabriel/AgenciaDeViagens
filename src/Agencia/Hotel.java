package Agencia;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hotel {
    private String nomeHotel;
    private String localizacao;
    private int numQuartos = 10;
    private int lotacaoMax = 20;
    private int lotacaoAtual = 0;
    private float avaliacao;
    private float numAvaliacao;

    private Map<Hotel, List<String>> servicos;

    public Hotel(String nomeHotel, String localizacao, int numQuartos, int lotacaoMax, int lotacaoAtual) {
        this.nomeHotel = nomeHotel;
        this.localizacao = localizacao;
        this.numQuartos = numQuartos;
        this.lotacaoMax = lotacaoMax;
        this.lotacaoAtual = lotacaoAtual;

    }

    public Hotel(Map<Hotel, List<String>> servicos) {
        this.servicos = new HashMap<>();
    }


    public String getNomeHotel() {
        return nomeHotel;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public int getNumQuartos() {
        return numQuartos;
    }

    public void avalie(float x) {

        numAvaliacao++;
        float y = (avaliacao + x) / numAvaliacao;

        avaliacao = y;

    }

    public void calculaLotacao(){
        if (lotacaoAtual >= lotacaoMax){
            System.out.println("Hotel lotado, desculpe!");
        }
        else{

        }
    }
}
