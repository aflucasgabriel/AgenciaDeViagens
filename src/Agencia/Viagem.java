package Agencia;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Viagem {
    private Cliente cliente;
    private Produto produto;

    public Viagem(Cliente cliente, Produto produto) {
        this.cliente = cliente;
        this.produto = produto;
    }
    //Métodos
    private boolean viagemRequisitada = false;

    public void requisitarViagem() {
        if (viagemRequisitada) {
            System.out.println("Viagem requisitada com sucesso.");
        } else {
            System.out.println("Viagem não foi requisitada.");
            viagemRequisitada = true;
        }
    }

    public void alterarViagem() {
        if (viagemRequisitada) {

            System.out.println("Viagem alterada com sucesso.");
        } else {
            System.out.println("Não é possível alterar uma viagem que não foi requisitada.");
        }
    }

    public void excluirViagem() {
        if (viagemRequisitada) {
            // Implemente a lógica para permitir a exclusão da viagem
            System.out.println("Viagem excluída com sucesso.");
            viagemRequisitada = false; // Marcando a viagem como não requisitada após a exclusão
        } else {
            System.out.println("Não é possível excluir uma viagem que não foi requisitada.");
        }
    }

    public void confirmarViagem() {
        if (viagemRequisitada) {
            System.out.println("Viagem confirmada com sucesso.");
        } else {
            System.out.println("Não é possível confirmar uma viagem que não foi requisitada.");
        }
    }

    public String relatorio(){
        String relatorio = produto.relatorio();

        return relatorio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}

