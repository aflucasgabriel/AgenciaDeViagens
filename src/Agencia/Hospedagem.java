package Agencia;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Hospedagem {

    private Hotel hotel1;
    private ArrayList<Hotel> hoteis;
    private LocalDate checkin;
    private LocalDate checkout;
    private float diasEstadia;
    private double precoDiaria;

    private boolean cancelarReserva;


    public Hospedagem(LocalDate checkin, LocalDate checkout, float diasEstadia, double precoDiaria) {
        this.checkin = checkin;
        this.checkout = checkout;
        this.diasEstadia = diasEstadia;
        this.precoDiaria = precoDiaria;
        this.cancelarReserva = false;
    }

    public Hospedagem() {

        this.hoteis = new ArrayList<>();
    }

    public boolean validarHospedagem(){
        if (checkout.isAfter(checkin)){
            System.out.println("Parabens, hospedagem no hotel " + hotel.getNomeHotel() +"!");
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

    public float calcularEstadia(){

        diasEstadia = ChronoUnit.DAYS.between(checkin, checkout);
        return diasEstadia;
    }


    public double calcularPrecoEstadia(){
        double x;
        x = calcularEstadia() * precoDiaria;
        return x;
    }

    public void adicionarHotel(Hotel hotel) {
        hoteis.add(hotel);
    }

    public Hotel consultarHotel(String nomeHotel) {
        for (Hotel hotel : hoteis) {
            if (hotel.getNomeHotel().equals(nomeHotel)) {
                return hotel;
            }
        }
        return null; // Retorna null se o hotel não for encontrado
    }

    public String relatorio(){
        String x = "";
        String y = "";



        x = "Nome do Hotel: " +  +"\nData Checkin: " + checkin + "\nData Checkout: " + checkout +
                "\nPreço Hospedagem: " + calcularEstadia() + "\nReserva ativa: " + cancelarReserva;


        return y + x;

    }





}
