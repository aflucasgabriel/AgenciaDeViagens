package Agencia;

public class Destino {
    String nome;
    String localizacao;
    String descricao;
    String pontosTuristicos;

    public Destino(String nome, String localizacao, String descricao, String pontosTuristicos) {
        this.nome = nome;
        this.localizacao = localizacao;
        this.descricao = descricao;
        this.pontosTuristicos = pontosTuristicos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalização(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescrição(String descricao) {
        this.descricao = descricao;
    }

    public String getPontosTuristicos() {
        return pontosTuristicos;
    }

    public void setPontosTuristicos(String pontosTuristicos) {
        this.pontosTuristicos = pontosTuristicos;
    }
}
