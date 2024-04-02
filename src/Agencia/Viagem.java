package Agencia;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Viagem {
    private Cliente cliente;
    private Passagem passagem;
    private ArrayList<Atracao> atracoes;
    private Hospedagem hospedagem;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private String Feedback;
    private String origem;
    private Destino destino;
    private int numeroPessoas;

    public Viagem(Cliente cliente, Passagem passagem, ArrayList<Atracao> atracoes, Hospedagem hospedagem,
                  LocalDate dataInicial, LocalDate dataFinal, String origem, Destino destino,
                  int numeroPessoas) {
        this.cliente = cliente;
        this.passagem = passagem;
        this.atracoes = atracoes;
        this.hospedagem = hospedagem;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.origem = origem;
        this.destino = destino;
        this.numeroPessoas = numeroPessoas;
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
            // Implemente a lógica para confirmar a viagem
            System.out.println("Viagem confirmada com sucesso.");
        } else {
            System.out.println("Não é possível confirmar uma viagem que não foi requisitada.");
        }
    }

    public double calcularPrecoPassagem() {
        double preco = 100.0; // Preço base.
        return preco;
    }

    public String obterTipoPassagem() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(3); // um número aleatório entre 0 e 2
        String tipoPassagem;

        switch (numeroAleatorio) {
            case 0:
                tipoPassagem = "Econômica";
                break;
            case 1:
                tipoPassagem = "Executiva";
                break;
            default:
                tipoPassagem = "Primeira Classe";
        }

        return tipoPassagem;
    }


    public String obterTipoTransporte() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(4); // Um número aleatório entre 0 e 3
        String tipoTransporte;

        switch (numeroAleatorio) {
            case 0:
                tipoTransporte = "Avião";
                break;
            case 1:
                tipoTransporte = "Ônibus";
                break;
            case 2:
                tipoTransporte = "Carro";
                break;
            default:
                tipoTransporte = "Moto";
        }

        return tipoTransporte;
    }

    public void visualizarCatalogoAtracoes(ArrayList<Atracao> catalogoAtracoes) {
        System.out.println("Catálogo de Atrações:");
        for (Atracao atracao : catalogoAtracoes) {
            System.out.println(atracao.getNomeAtracao() + " - " + atracao.getDescricao());
        }
    }

    public void visualizarFeedback(String feedback) {
        // Exibir feedback da viagem
        System.out.println("Feedback da Viagem:");
        System.out.println(feedback);
    }

//Get e Set

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Passagem getPassagem() {
        return passagem;
    }

    public void setPassagem(Passagem passagem) {
        this.passagem = passagem;
    }

    public ArrayList<Atracao> getAtracoes() {
        return atracoes;
    }

    public void setAtracoes(ArrayList<Atracao> atracoes) {
        this.atracoes = atracoes;
    }

    public Hospedagem getHospedagem() {
        return hospedagem;
    }

    public void setHospedagem(Hospedagem hospedagem) {
        this.hospedagem = hospedagem;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }


    public String getFeedback() {
        return Feedback;
    }

    public void setFeedback(String feedback) {
        this.Feedback = feedback;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getNumeroPessoas() {
        return numeroPessoas;
    }

    public void setNumeroPessoas(int numeroPessoas) {
        this.numeroPessoas = numeroPessoas;
    }

}

