package Agencia;

public class AtracaoGratuita extends Atracao {

    public AtracaoGratuita(String nomeAtracao, String descricao, String horario, float preco, String tipo, Destino destino) {
        super(nomeAtracao, descricao, horario, preco, tipo, destino);
        this.setPreco(0);
    }
}
