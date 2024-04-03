package Agencia;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Cliente {

    private String nome;
    private String email;
    private String senha;
    private Destino destinoEscolhido;
    private Passagem passagemEscolhida;
    private Hospedagem hospedagemEscolhida;
    private ArrayList<Atracao> atracaosEscolhidas;
    private LocalDate dataNascimento;
    private ArrayList <Viagem> historicoViagens;
    private ArrayList <PreferenciaViagem> preferenciasViagens;
    private static Cliente clienteLogado;


    public Cliente(String nome, String email, String senha, LocalDate dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.historicoViagens = new ArrayList<>();
        this.preferenciasViagens = new ArrayList<>();

    }

    public void adicionarPreferenciaViagem(PreferenciaViagem preferencia) {
        preferenciasViagens.add(preferencia);
    }

    public void removerPreferenciaViagem(int indice) {
        preferenciasViagens.remove(indice);
    }

    public ArrayList<PreferenciaViagem> getPreferenciasViagem() {
        return preferenciasViagens;
    }

    public static void setClienteLogado(Cliente cliente) {
        clienteLogado = cliente;
    }

    // Método para obter o cliente logado
    public static Cliente getClienteLogado() {
        return clienteLogado;
    }

    public String relatorio(){

        String x = getAtracaosEscolhidas().toString() + getHospedagemEscolhida().relatorioHospedagem() + getPassagemEscolhida().relatorioPassagem();

        return x;
    }



//GET E SET


    public ArrayList<Atracao> getAtracaosEscolhidas() {
        return atracaosEscolhidas;
    }

    public void setAtracaosEscolhidas(ArrayList<Atracao> atracaosEscolhidas) {
        this.atracaosEscolhidas = atracaosEscolhidas;
    }

    public Passagem getPassagemEscolhida() {
        return passagemEscolhida;
    }

    public void setPassagemEscolhida(Passagem passagemEscolhida) {
        this.passagemEscolhida = passagemEscolhida;
    }

    public Hospedagem getHospedagemEscolhida() {
        return hospedagemEscolhida;
    }

    public void setHospedagemEscolhida(Hospedagem hospedagemEscolhida) {
        this.hospedagemEscolhida = hospedagemEscolhida;
    }



    public Destino getDestinoEscolhido() {
        return destinoEscolhido;
    }

    public void setDestinoEscolhido(Destino destinoEscolhido) {
        this.destinoEscolhido = destinoEscolhido;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Viagem> getHistoricoViagens() {
        return historicoViagens;
    }

    public void setHistoricoViagens(ArrayList<Viagem> historicoViagens) {
        this.historicoViagens = historicoViagens;
    }

    public ArrayList<PreferenciaViagem> getPreferenciasViagens() {
        return preferenciasViagens;
    }

    public void setPreferenciasViagens(ArrayList<PreferenciaViagem> preferenciasViagens) {
        this.preferenciasViagens = preferenciasViagens;
    }
}
