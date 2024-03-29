package Agencia;

public class AtraçãoGratuita extends Atração{

    public AtraçãoGratuita(String nomeAtracao, String descricao, String horario, float preco, String tipo) {
        super(nomeAtracao, descricao, horario, preco, tipo);
        this.setPreco(0);
    }
}
