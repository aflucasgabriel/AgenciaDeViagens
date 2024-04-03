package Agencia;

import java.util.ArrayList;

public class AtracaoPaga extends Atracao {
    private ArrayList<String> avaliacoes;

    public AtracaoPaga(String nomeAtracao, String descricao, String horario, float preco, String tipo, Destino destino) {
        super(nomeAtracao, descricao, horario, preco, tipo, destino);
        this.avaliacoes = new ArrayList<>();
    }

    @Override
    public void relatorioAvaliacao(String avaliacao){
        avaliacoes.add(avaliacao);
    }


}
