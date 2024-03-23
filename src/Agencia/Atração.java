package Agencia;

public class Atração {
    private String nomeAtracao;
    private String descricao;
    private String horario;
    private float preco;
    private String tipo;
    private int lotacao;

    public Atração(String nomeAtracao, String descricao, String horario, float preco, String tipo) {
        this.nomeAtracao = nomeAtracao;
        this.descricao = descricao;
        this.horario = horario;
        this.preco = preco;
        this.tipo = tipo;
        this.lotacao++;
    }

    public String getNomeAtracao() {
        return nomeAtracao;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getHorario() {
        return horario;
    }

    public float getPreco() {
        return preco;
    }

    public boolean verificarDisponibilidade(){

        if (lotacao >= 25){
            return true;
        }
        return false;
    }

    public boolean reservar(){

        return true;
    }

    public boolean cancelar(){

        boolean x = !reservar();

        return x;
    }

    public String relatorioAtracao() {
        return "Nome: " + nomeAtracao + "\nHorario Funcionamento: " + horario + "\nLotacao Atual: " +
                lotacao + "\nPreco/Hr: R$" + preco  + "\nTipo de atração: " + tipo;
    }
}
