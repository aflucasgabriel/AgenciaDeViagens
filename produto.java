
public class Produto{
    private double preco;
    private String hospedagem;
    private String atracoes;
    private String passagem;
    private int capacidadePessoas;
    
    public Produto(double preco, String hospedagem, String atracoes, String passagem, int capacidadePessoas){
        this.preco = preco;
        this.hospedagem = hospedagem;
        this.atracoes = atracoes;
        this.passagem = passagem;
        this.capacidadePessoas = capacidadePessoas;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getHospedagem() {
        return hospedagem;
    }

    public void setHospedagem(String hospedagem) {
        this.hospedagem = hospedagem;
    }

    public String getAtracoes() {
        return atracoes;
    }

    public void setAtracoes(String atracoes) {
        this.atracoes = atracoes;
    }

    public String getPassagem() {
        return passagem;
    }

    public void setPassagem(String passagem) {
        this.passagem = passagem;
    }

    public int getCapacidadePessoas() {
        return capacidadePessoas;
    }

    public void setCapacidadePessoas(int capacidadePessoas) {
        this.capacidadePessoas = capacidadePessoas;
    }
    
    public double calcularPrecoTotal() {
        return preco * capacidadePessoas;
    }
    
}
