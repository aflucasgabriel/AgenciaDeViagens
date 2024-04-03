package Agencia;

import java.util.ArrayList;

public class AtracaoGratuita extends Atracao {
    private ArrayList<String> avaliacoes;

    public AtracaoGratuita(String nomeAtracao, String descricao, String horario, float preco, String tipo, Destino destino) {
        super(nomeAtracao, descricao, horario, preco, tipo, destino);
        this.setPreco(0);
        this.avaliacoes = new ArrayList<>();
    }

    @Override
    public void relatorioAvaliacao(String avaliacao){
        avaliacoes.add(avaliacao);
    }


}
