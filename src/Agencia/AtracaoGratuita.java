package Agencia;

public class AtracaoGratuita extends Atracao {

    public AtracaoGratuita(String nomeAtracao, String descricao, String horario, float preco, String tipo) {
        super(nomeAtracao, descricao, horario, preco, tipo);
        this.setPreco(0);
    }
}
