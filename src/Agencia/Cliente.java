import java.util.List;
import java.util.ArrayList;

//Atributos na classe Cliente nome, email, senha,data de nascimento, historico das viagens, preferencias de viagens.

public class Cliente {

    private String nome;
    private String email;
    private String senha;
    private String dataNascimento;
    private List <Viagem> historicoViagens; 
    private List <String> preferenciasViagens;


    public Cliente(String nome, String email, String senha){
        this.nome = nome;
        this.email= email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.historicoViagens = new ArrayList<>();
        this.preferenciasViagens = new ArrayList<>();
        

    }

// Metódos responsáveis 
    
    public static Cliente cadastrarCliente(String nome, String email, String senha){
        return new Cliente( nome, email, senha);
    }

    public void editar(String novoNome,String novaSenha, List<Viagem> novohistoricoViagens, List<String> novaspreferenciadViagens){
        this.nome = novoNome;
        this.senha= novaSenha;
        this.historicoViagens = novohistoricoViagens;
        this.preferenciasViagens = novaspreferenciadViagens;
    }

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

//GET E SET

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

public void setHistoricoViagens(List<Viagem> historicoViagens) {
    this.historicoViagens = historicoViagens;
}

public List<String> getPreferenciasViagens() {
    return preferenciasViagens;
}

public void setPreferenciasViagens(List<String> preferenciasViagens) {
    this.preferenciasViagens = preferenciasViagens;
}
}
