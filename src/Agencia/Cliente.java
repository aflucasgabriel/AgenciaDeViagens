package Agencia;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

//Atributos na classe Cliente nome, email, senha,data de nascimento, historico das viagens, preferencias de viagens.

public class Cliente {

    private String nome;
    private String email;
    private String senha;
    private Destino destinoEscolhido;
    private Passagem passagemEscolhida;
    private Hospedagem hospedagemEscolhida;
    private Atracao atracaoEscolhida;
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

    /*

    public void editar(String novoNome,String novaSenha, List<Viagem> novohistoricoViagens, List<String> novaspreferenciadViagens){
        this.nome = novoNome;
        this.senha= novaSenha;
        this.historicoViagens = novohistoricoViagens;
        this.preferenciasViagens = novaspreferenciadViagens;
    }
*/
    /*
    public void relatorioViagens() {
        System.out.println("Histórico de viagens do cliente " + nome + ":");
        for (Viagem viagem : historicoViagens) {
            System.out.println("Data: " + viagem.getData());
            System.out.println("Destino: " + viagem.getDestino());
            System.out.println("Hospedagem: " + viagem.getHospedagem().getNomehotel());
            System.out.println("Atrações:");
            for (String atrações : viagem.getAtrações()) {
                System.out.println("- " + atrações);
            }
            System.out.println("Feedback: " + viagem.getFeedback());
            System.out.println();
        }
    }
*/

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




//GET E SET


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

    public Atracao getAtracaoEscolhida() {
        return atracaoEscolhida;
    }

    public void setAtracaoEscolhida(Atracao atracaoEscolhida) {
        this.atracaoEscolhida = atracaoEscolhida;
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
