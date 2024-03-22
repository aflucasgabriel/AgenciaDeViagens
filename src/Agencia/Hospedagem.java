package Agencia;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Hospedagem {
    private String nomeHotel;
    private String localizacao;
    double precoDiaria;
    private LocalDate checkin;
    private LocalDate checkout;
    private float diasEstadia;
    private boolean cancelarReserva;


    public Hospedagem(String nomeHotel, String localizacao, LocalDate checkin, LocalDate checkout, float diasEstadia, double precoDiaria) {
        this.nomeHotel = nomeHotel;
        this.localizacao = localizacao;
        this.checkin = checkin;
        this.checkout = checkout;
        this.diasEstadia = diasEstadia;
        this.precoDiaria = precoDiaria;
        this.cancelarReserva = false;
    }



    public boolean validarHospedagem(){
        if (checkout.isAfter(checkin)){
            System.out.println("Parabens, hospedagem no hotel " + nomeHotel +"!");
            return true;
        }else{
            return false;
        }
    }

    public void cancelar(){
        cancelarReserva = true;
    }
    public boolean isReservaCancelada(){
        return cancelarReserva;
    }




    public double calcularPrecoEstadia(){
        double x;
        x = calcularEstadia() * precoDiaria;
        return x;
    }

    public String relatorio(){
        String x = "";
        String y = "";

        x = "Nome do Hotel: " +  +"\nData Checkin: " + checkin + "\nData Checkout: " + checkout +
                "\nPreço Hospedagem: " + calcularEstadia() + "\nReserva ativa: " + cancelarReserva;
        return y + x;

    }





}
