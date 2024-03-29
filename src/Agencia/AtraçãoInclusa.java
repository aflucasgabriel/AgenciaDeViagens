package Agencia;

public class AtraçãoInclusa extends Atração{

    public AtraçãoInclusa(String nomeAtracao, String descricao, String horario, float preco, String tipo) {
        super(nomeAtracao, descricao, horario, preco, tipo);
        this.setPreco(0);
    }
}
