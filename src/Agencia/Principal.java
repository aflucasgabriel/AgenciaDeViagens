package Agencia;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Principal {

    public static void main(String[] args) {
        ArrayList<Cliente> cl = new ArrayList<>();
        ArrayList<Passagem> passagem = new ArrayList<>();
        ArrayList<Hospedagem> hospedagem = new ArrayList<>();
        ArrayList<Atracao> atracao = new ArrayList<>();


        PassagemTerrestre passagemT;
        PassagemAerea passagemA;
        double tarifaFixa = 1.5;


        Scanner sc = new Scanner(System.in);
        int op = 0, op1 = 0, op2 = 0;

        do {
            System.out.println("=========Menu=========");
            System.out.println("1 - Login");
            System.out.println("2 - Cadastro");
            System.out.println("0 - Sair");
            System.out.print("Opcao: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    if (loginCliente(cl)) {
                        do {
                            System.out.println("=========Menu=========");
                            System.out.println("1 - Nova Viagem(Inclui Passagem, Hospedagem e Atrações)");
                            System.out.println("3 - Hospedagem");
                            System.out.println("4 - Atração");
                            System.out.println("2 - Histórico");
                            System.out.println("5 - Avaliar");
                            System.out.println("0 - Sair");
                            System.out.print("Opcao: ");
                            op1 = sc.nextInt();
                            sc.nextLine();

                            switch (op1) {
                                case 1:
                                    LocalDate dataIda = dataCheckIn();
                                    LocalDate dataVolta = dataCheckOut();

                                    Destino[] dest = new Destino[7];

                                    dest[0] = new Destino("Paris", "Europa", "A cidade do Amor!", "Torre Eiffel, Arco do Triunfo", 2500);
                                    dest[1] = new Destino("Los Angeles", "America do Norte", "A cidade da diversão!!", "Hollywood, cassinos!", 1265.99);
                                    dest[2] = new Destino("Lisboa", "Europa", "A cidade histórica!", "Castelo de São Jorge, Praias paradisíacas!", 1899.99);
                                    dest[3] = new Destino("Ottawa", "America do Norte", "A cidade dos Festivais!!", "Colina do Parlamento, Inúmeros museus!", 679.59);
                                    dest[4] = new Destino("Atenas", "Europa", "A cidade eterna, repleta de história e arquitetura magnífica.", "Partenon, Acrópole!", 1689.89);
                                    dest[5] = new Destino("Rio de Janeiro", "America do Sul", "A cidade maravilhosa! Repleta de história e belezas naturais!", "Copacabana, Cristo Redentor, Pão de Açucar", 245.89);
                                    dest[6] = new Destino("Salvador", "America do Sul", "A capital da Alegria!", "Praia do Forte, Pelourinho", 250.99);


                                    System.out.println("Perfeito! Temos os seguintes destinos: ");
                                    for (int i = 0; i < dest.length; i++) {
                                        System.out.println("Destino: " + dest[i].getNome() + "\nLocalização" + dest[i].localizacao + "\nDescrição: " + dest[i].getDescricao() + "\nPontos Turísticos: " + dest[i].pontosTuristicos + "\nPreço: R$ " + dest[i].getPreco());
                                    }
                                    System.out.print("Qual deseja escolher?(Digite o nome: ): ");
                                    String destino = sc.next();
                                    sc.nextLine();

                                    for (int i = 0; i < dest.length; i++) {
                                        if (dest[i].getNome().equalsIgnoreCase(destino)) {
                                            System.out.println("Destino: " + dest[i].getNome());
                                            System.out.println("Descrição: " + dest[i].getDescricao());
                                            System.out.println("Preço: " + dest[i].getPreco());

                                        }
                                        obterClienteLogado().setDestinoEscolhido(dest[i]);

                                    }


                                    System.out.println("Excelente escolha!");
                                    System.out.println("Agora vamos escolher sua passagem!");
                                    String companhia;
                                    double taxaEmbarqueRio = obterClienteLogado().getDestinoEscolhido().getPreco() + 100.0;
                                    double taxaEmbarqueSal = obterClienteLogado().getDestinoEscolhido().getPreco() + 200.0;
                                    double passTotalRio = taxaEmbarqueRio + (taxaEmbarqueRio * tarifaFixa);
                                    double passTotalSal = taxaEmbarqueSal + (taxaEmbarqueSal * tarifaFixa);
                                    double tarifaAerea = obterClienteLogado().getDestinoEscolhido().getPreco() * tarifaFixa;

                                    if (obterClienteLogado().getDestinoEscolhido().getLocalizacao().equalsIgnoreCase("America do Sul")) {
                                        System.out.println("Deseja viajar via Terrestre ou Aerea?");
                                        String transporte = sc.next();

                                        if (transporte.equalsIgnoreCase("Terrestre")) {
                                            System.out.print("\nQual a origem?: ");
                                            String origem = sc.next();


                                            System.out.println("Por qual companhia deseja viajar? ");
                                            if (obterClienteLogado().getDestinoEscolhido().getNome().equalsIgnoreCase("Rio de Janeiro")) {
                                                System.out.println("Guanabara - R$" + passTotalRio);
                                                System.out.println("Rode Rotas - R$" + passTotalRio);
                                                System.out.println("Platina - R$" + passTotalRio + "\n");
                                                companhia = sc.next();


                                                System.out.print("Qual assento deseja reservar?(1 a 60): ");
                                                int assento = sc.nextInt();

                                                System.out.println("Deseja adicionar bagagem extra? R$5.00 por bagagem extra(s/n) ");
                                                String bag = sc.next();

                                                if (bag.equalsIgnoreCase("s")) {
                                                    System.out.print("Quantas bagagens extras deseja adicionar?: ");
                                                    int quantBag = sc.nextInt();

                                                    passagemT = new PassagemTerrestre(origem, obterClienteLogado().getDestinoEscolhido(), dataIda, dataVolta, passTotalRio, companhia, assento);
                                                    passagemT.adicionarBagagemExtra(quantBag);
                                                    passagem.add(passagemT);
                                                }
                                            } else if (obterClienteLogado().getDestinoEscolhido().getNome().equalsIgnoreCase("Salvador")) {
                                                System.out.println("Guanabara - R$" + passTotalSal);
                                                System.out.println("Rode Rotas - R$" + passTotalSal);
                                                System.out.println("Platina - R$" + passTotalSal);
                                                companhia = sc.next();


                                                System.out.print("Qual assento deseja reservar?(1 a 60): ");
                                                int assento = sc.nextInt();

                                                System.out.println("Deseja adicionar bagagem extra? R$5.00 por bagagem extra(s/n) ");
                                                String bag = sc.next();

                                                if (bag.equalsIgnoreCase("s")) {
                                                    System.out.print("Quantas bagagens extras deseja adicionar?: ");
                                                    int quantBag = sc.nextInt();

                                                    passagemT = new PassagemTerrestre(origem, obterClienteLogado().getDestinoEscolhido(), dataIda, dataVolta, passTotalSal, companhia, assento);
                                                    passagemT.adicionarBagagemExtra(quantBag);
                                                    passagem.add(passagemT);


                                                } else {
                                                    passagemT = new PassagemTerrestre(origem, obterClienteLogado().getDestinoEscolhido(), dataIda, dataVolta, passTotalSal, companhia, assento);
                                                    passagem.add(passagemT);

                                                }
                                            }
                                        } else {
                                            System.out.print("\nQual a origem?: ");
                                            String origem = sc.next();

                                            System.out.println("Qual classe deseja viajar? (Economica/Executiva)");
                                            String classe = sc.next();

                                            System.out.println("Por qual companhia deseja viajar? ");
                                            if (obterClienteLogado().getDestinoEscolhido().getNome().equalsIgnoreCase("Rio de Janeiro")) {
                                                double totalRio = (obterClienteLogado().getDestinoEscolhido().getPreco() * tarifaFixa) + obterClienteLogado().getDestinoEscolhido().getPreco();
                                                System.out.println("Latam - R$" + totalRio);
                                                System.out.println("Azul - R$" + totalRio);
                                                System.out.println("GOL - R$" + totalRio);
                                                companhia = sc.next();


                                                System.out.print("Qual assento deseja reservar?(1 a 60): ");
                                                int assento = sc.nextInt();

                                                System.out.println("Deseja adicionar bagagem extra? R$50.00 por bagagem extra(s/n) ");
                                                String bag = sc.next();

                                                if (bag.equalsIgnoreCase("s")) {
                                                    System.out.print("Quantas bagagens extras deseja adicionar?: ");
                                                    int quantBag = sc.nextInt();

                                                    passagemA = new PassagemAerea(origem, obterClienteLogado().getDestinoEscolhido(), dataIda, dataVolta, totalRio, companhia, assento);
                                                    passagemA.calculaPreco();
                                                    passagemA.adicionarBagagemExtra(quantBag);
                                                    passagem.add(passagemA);
                                                } else {
                                                    passagemA = new PassagemAerea(origem, obterClienteLogado().getDestinoEscolhido(), dataIda, dataVolta, totalRio, companhia, assento);
                                                    passagemA.calculaPreco();
                                                    passagem.add(passagemA);
                                                }
                                            }
                                        }

                                    } else {
                                        System.out.println("Como seu destino não está na América do Sul, temos disponível somente passagens aéreas!");
                                        System.out.print("\nQual a origem?: ");
                                        String origem = sc.next();

                                        System.out.println("Qual classe deseja viajar? (Economica/Executiva)");
                                        String classe = sc.next();

                                        System.out.println("Por qual companhia deseja viajar? ");
                                        if (obterClienteLogado().getDestinoEscolhido().getLocalizacao().equalsIgnoreCase("America do Norte")) {
                                            double totalAme = (obterClienteLogado().getDestinoEscolhido().getPreco() * tarifaFixa) + obterClienteLogado().getDestinoEscolhido().getPreco();
                                            System.out.println("Latam - R$" + totalAme);
                                            System.out.println("Azul - R$" + totalAme);
                                            System.out.println("GOL - R$" + totalAme);
                                            companhia = sc.next();


                                            System.out.print("Qual assento deseja reservar?(1 a 60): ");
                                            int assento = sc.nextInt();

                                            System.out.println("Deseja adicionar bagagem extra? R$50.00 por bagagem extra(s/n) ");
                                            String bag = sc.next();

                                            if (bag.equalsIgnoreCase("s")) {
                                                System.out.print("Quantas bagagens extras deseja adicionar?: ");
                                                int quantBag = sc.nextInt();

                                                passagemA = new PassagemAerea(origem, obterClienteLogado().getDestinoEscolhido(), dataIda, dataVolta, totalAme, companhia, assento);
                                                passagemA.calculaPreco();
                                                passagemA.adicionarBagagemExtra(quantBag);
                                                passagem.add(passagemA);
                                            } else {
                                                passagemA = new PassagemAerea(origem, obterClienteLogado().getDestinoEscolhido(), dataIda, dataVolta, totalAme, companhia, assento);
                                                passagemA.calculaPreco();
                                                passagem.add(passagemA);
                                            }
                                        }
                                    }

                                    System.out.println("Tudo certo!\nAgora vamos escolher sua hospedagem!");

                                    List<String> servicosHotelLotus = new ArrayList<>();
                                    servicosHotelLotus.add("Wi-Fi");
                                    servicosHotelLotus.add("Café da manhã");

                                    List<String> servicosHotelSavana = new ArrayList<>();
                                    servicosHotelSavana.add("Wi-Fi");
                                    servicosHotelSavana.add("Café da manhã");
                                    servicosHotelSavana.add("Piscina");
                                    servicosHotelSavana.add("Almoço e Janta");

                                    List<String> servicosHotelCarlton = new ArrayList<>();
                                    servicosHotelCarlton.add("Wi-Fi");
                                    servicosHotelCarlton.add("Café da manhã");
                                    servicosHotelCarlton.add("Piscina");
                                    servicosHotelCarlton.add("Academia");
                                    servicosHotelCarlton.add("Almoço e Janta");
                                    servicosHotelCarlton.add("Estacionamento");

                                    Hospedagem[] hosp = new Hospedagem[3];
                                    hosp[0] = new Hospedagem("Lotus", "Rua das Palmeiras, 103", dataCheckIn(), dataCheckOut(), 150, 15, servicosHotelLotus);
                                    hosp[1] = new Hospedagem("Savana", "Avenida Principal, 6384", dataCheckIn(), dataCheckOut(), 200, 3, servicosHotelSavana);
                                    hosp[2] = new Hospedagem("Carlton", "Avenida Doutor Hans Chucrute, 257", dataCheckIn(), dataCheckOut(), 300, 8, servicosHotelCarlton);


                                    for (int i = 0; i < hosp.length; i++) {
                                        System.out.println("Nome do Hotel: " + hosp[i].getNomeHotel() +
                                                "\nPreço Diária: " + hosp[i].getPrecoDiario() + "\nServiços: " + hosp[i].getServicosInclusos());
                                    }

                                    System.out.print("Qual deseja escolher?(Digite o nome do Hotel): ");
                                    String hotel = sc.next();
                                    sc.nextLine();

                                    for (int i = 0; i < dest.length; i++) {
                                        if (hosp[i].getNomeHotel().equalsIgnoreCase(hotel)) {
                                            System.out.println("Destino: " + hosp[i].getNomeHotel());
                                            System.out.println("Endereço: " + hosp[i].getLocalizacao());
                                            System.out.println("Preço: " + hosp[i].getPrecoDiario());

                                        }
                                        obterClienteLogado().setHospedagemEscolhida(hosp[i]);

                                        // Criando um produto com a hospedagem escolhida
                                        //Produto produto = new Produto("Hospedagem", "Reserva de hospedagem de hotel", h.calcularPreco(), Produto.TipoProduto.HOSPEDAGEM);
                                        //System.out.println("Produto criado: " + produto);
                                    }
                                    double total = obterClienteLogado().getHospedagemEscolhida().calcularPreco(dias());
                                    Hospedagem hosped = new Hospedagem(obterClienteLogado().getHospedagemEscolhida().getNomeHotel(), obterClienteLogado().getHospedagemEscolhida().getLocalizacao(), dataIda, dataVolta, obterClienteLogado().getHospedagemEscolhida().getPrecoDiario(), obterClienteLogado().getHospedagemEscolhida().getQuartosDisponiveis(), obterClienteLogado().getHospedagemEscolhida().getServicosInclusos());
                                    hospedagem.add(hosped);
                                    System.out.println("Total da Hospedagem: R$" + total);

                                    System.out.println("Excelente escolha!");
                                    System.out.println("Para finalizar, iremos escolher algumas atrações!");


                                    break;

                                case 2:
                                    novaHospedagem();
                                    break;
                                case 3:
                                    novaAtracao();
                                    break;
                                case 4:
                                    break;
                                case 5:
                                    break;
                            }
                        } while (op1 != 0);
                    } else {
                        break;
                    }
                    break;
                case 2:
                    cadastraCliente(cl);
                    break;
            }

        } while (op != 0);

    }

    public static boolean cadastraCliente(ArrayList<Cliente> cl) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Digite seu nome completo: ");
            String nome = sc.next();
            System.out.print("Digite sua data de nascimento (dd/MM/yyyy): ");
            String data = sc.next();
            DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataNasc = LocalDate.parse(data, formatar);

            System.out.print("Digite seu email: ");
            String email = sc.next();
            System.out.print("Digite sua senha: ");
            String senha = sc.next();

            System.out.println("Obrigado!");

            Cliente cliente = new Cliente(nome, email, senha, dataNasc);
            cl.add(cliente);

            return true;
        } catch (InputMismatchException ex) {
            System.out.println("Erro ao inserir dados! Tente novamente!");
            sc.next();
            return false;
        }

    }

    public static boolean loginCliente(ArrayList<Cliente> cl) {
        Scanner sc = new Scanner(System.in);


        try {
            System.out.print("Digite seu email: ");
            String email = sc.next();
            System.out.print("Digite sua senha: ");
            String senha = sc.next();

            if (verificaCredenciais(email, senha, cl)) {
                System.out.println("Login Efetuado!");

                return true;
            } else {
                throw new IllegalArgumentException("Email ou senha incorretos!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("ERRO! Email ou senha incorretos!" + e.getMessage());
            sc.nextLine();
            return false;
        }

    }


    public static boolean verificaCredenciais(String email, String senha, ArrayList<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            if (cliente.getEmail().equals(email) && cliente.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }

    private static Cliente obterClienteLogado() {
        return Cliente.getClienteLogado();
    }

    public static LocalDate dataCheckIn() {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Que bom que escolheu planejar sua viagem com a gente!");
        System.out.println("Qual data de ida? (Formato DD/MM/YYYY): ");
        String dataIdaString = sc.nextLine();

        return LocalDate.parse(dataIdaString, formatar);

    }

    public static LocalDate dataCheckOut() {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Qual data de ida? (Formato DD/MM/YYYY): ");
        String dataVoltaString = sc.nextLine();

        return LocalDate.parse(dataVoltaString, formatar);
    }

    public static int dias() {
        long diferencaEmDias = Math.abs(ChronoUnit.DAYS.between(dataCheckIn(), dataCheckOut()));
        int diferenca = (int) diferencaEmDias;

        return diferenca;
    }


    public static boolean novaViagem() {
        ArrayList<Produto> produtos = new ArrayList<>();

        boolean destinoCriado = novoDestino();
        novaHospedagem();
        boolean atracaoCriada = novaAtracao();

        if (destinoCriado && hospedagemCriada && atracaoCriada) {
            Produto produto = new Produto("Pacote de Viagem!", "Pacote de viagens que inclui, Passagem, Hospedagem e Atrações!", produtos.get(0).calculaPreco(), Produto.TipoProduto.VIAGEM);
            produtos.add(produto);

            System.out.println("Perfeito, sua viagem foi criada!");

            return true;
        } else {
            System.out.println("Falha ao criar a viagem. Verifique as etapas anteriores.");
            return false;
        }
    }

    public static ArrayList<Hospedagem> novaHospedagem() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Hospedagem> hospedagens = new ArrayList<>();

        System.out.println("Agora vamos escolher qual hotel deseja se hospedar para ter a melhor experiência!");

        try {

        } catch (Exception ex) {
            System.out.println("Algo deu errado!");
        }
        return hospedagens;
    }

    public static boolean novaAtracao() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList<>();


        try {


            System.out.print("Deseja incluir atrações na sua viagem?\nTemos atrações como museus, restaurantes, cachoeiras etc(sim/nao): ");
            String escolhaAtracao = sc.nextLine();
            sc.nextLine();

            if (escolhaAtracao.equals("sim")) {

                System.out.println("Vamos as atrações que você pode adquirir!");

                ArrayList<Atracao> atracoes = new ArrayList<>();

                Atracao[] at = new Atracao[9];

                at[0] = new AtracaoPaga("Pontos Turísticos Premium", "Um passeio incrível por todos os pontos turísticos da cidade!", "8h às 15h", 150, "Ponto Turistico");
                at[1] = new AtracaoGratuita("Museus, Exposições de arte e Feiras de artesanato", "Roteiro de passeios culturais ideal para conhecer a cultura da cidade!", "13h às 22h", 120, "Cultural");
                at[2] = new AtracaoPaga("Teatros, Concertos e Óperas Premium", "Ingressos para eventos culturais que estão acontecendo na cidade!", "15h às 23h", 200, "Cultural");
                at[3] = new AtracaoPaga("Restaurantes Premium", "Uma mesa reservada nos 2 melhores restaurantes para você conhecer a culinaria local!", "17h às 23h", 80, "Gastronômico");
                at[4] = new AtracaoGratuita("Padarias e Cafes", "Um guia das melhores padarias e cafés para você apreciar!", "6h às 18h", 150, "Gastronômico");
                at[5] = new AtracaoGratuita("Cachoeiras, Parques, Praias", "Um rolê mais natural? Que tal visitar as belezas naturais da cidade?", "8h às 15h", 250, "Natureza");
                at[6] = new AtracaoPaga("Spa Premium", "Quer algo mais tranquilo pra relaxar? Um dia de spa para voce!", "8h às 21h", 100, "Bem estar");
                at[7] = new AtracaoPaga("Esportes Radicais Premium", "Um roteiro com os melhores pontos de esportes radicais presentes na cidade!", "6h às 16h", 80, "Esportes");
                at[8] = new AtracaoGratuita("Aventura", "Ideal para você que curte um paraquedismo ou uma tirolesa!", "8h às 15h", 250, "Esportes");


                atracoes.addAll(Arrays.asList(at));

                for (int i = 0; i < atracoes.size(); i++) {
                    System.out.println((i) + atracoes.get(i).getNomeAtracao() +
                            "\nPreço: " + atracoes.get(i).getPreco() + "\nDescrição: " + atracoes.get(i).getDescricao());
                }


                int indiceEscolhido;
                String resposta;
                List<Atracao> atracoesEscolhidas = new ArrayList<>();
                do {
                    System.out.print("Qual deseja escolher (digite o número do índice ou 'sair' para terminar)?: ");
                    resposta = sc.nextLine();

                    try {
                        indiceEscolhido = Integer.parseInt(resposta);
                        if (indiceEscolhido >= 0 && indiceEscolhido < atracoes.size()) {
                            Atracao atracaoEscolhida = atracoes.get(indiceEscolhido);
                            atracoesEscolhidas.add(atracaoEscolhida);
                        } else {
                            System.out.println("Índice inválido. Por favor, digite um número de índice válido.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida. Por favor, digite um número de índice ou 'sair' para terminar.");
                    }
                } while (!resposta.equalsIgnoreCase("sair"));

                double precoTotal = 0.0;
                for (Atracao a : atracoesEscolhidas) {
                    precoTotal += a.getPreco();
                }
                for (Atracao a : atracoesEscolhidas) {
                    System.out.println("Nome: " + a.getNomeAtracao());
                    System.out.println("Horario: " + a.getHorario());
                    System.out.println("Preço: " + a.getPreco());
                    System.out.println();
                }
                System.out.println("-----Preço total das atrações-----");
                System.out.println("R$ :" + precoTotal);
            }
            Produto produto = new Produto("Atração", "Escolha de uma atração", produtos.get(0).calculaPreco(), Produto.TipoProduto.HOSPEDAGEM);

            return true;
        } catch (Exception ex) {
            System.out.println("Algo deu errado!");
            return false;
        }
    }

    public static boolean novoDestino() {
        Scanner sc = new Scanner(System.in);

        try {
            ArrayList<Destino> destinos = new ArrayList<>();
            Destino[] dest = new Destino[5];

            dest[0] = new Destino("Paris", "Europa", "A cidade do Amor!", "Torre Eiffel, Arco do Triunfo", 5500);
            dest[1] = new Destino("Los Angeles", "America do Norte", "A cidade da diversão!!", "Hollywood, cassinos!", 3265.99);
            dest[2] = new Destino("Lisboa", "Europa", "A cidade histórica!", "Castelo de São Jorge, Praias paradisíacas!", 3899.99);
            dest[3] = new Destino("Ottawa", "America do Norte", "A cidade dos Festivais!!", "Colina do Parlamento, Inúmeros museus!", 1879.59);
            dest[4] = new Destino("Atenas", "Europa", "A cidade eterna, repleta de história e arquitetura magnífica.", "Partenon, Acrópole!", 4689.89);

            destinos.addAll(Arrays.asList(dest));

            dataCheckIn();
            dataCheckOut();

            System.out.println("Ótima data! Temos os seguintes destinos disponíveis: ");
            for (int i = 0; i < destinos.size(); i++) {
                System.out.println((i) + destinos.get(i).getNome() +
                        "\nPreço: " + destinos.get(i).getPreco() + "\nDescrição: " + destinos.get(i).getDescricao());
            }
            System.out.print("Qual deseja escolher?: ");
            String destino = sc.next();
            sc.nextLine();

            for (Destino d : destinos) {
                if (d.getNome().equalsIgnoreCase(destino)) {
                    System.out.println("Destino: " + d.getNome());
                    System.out.println("Descrição: " + d.getDescricao());
                    System.out.println("Preço: " + d.getPreco());

                }
            }
            System.out.println("Excelente escolha!");
            return true;

        } catch (Exception e) {
            System.out.println("ERRO! TENTE NOVAMENTE");
            sc.nextLine();
            return false;
        }
    }
    /*
    public static boolean novaPassagem(){
        Scanner sc = new Scanner(System.in);

        ArrayList<Passagem> passagem = new ArrayList<>();
        Passagem[] pass = new Passagem[10];

        pass[0] = new PassagemAerea()
        pass[0]
        pass[0]
        pass[0]
        pass[0]
        pass[0]
        pass[0]
        pass[0]
        pass[0]
        pass[0]


}
        */

    public static double calcularPrecoPassagem(String classe) {


        double valorTotal;
        if (classe.equalsIgnoreCase("economica")) {
            valorTotal = obterClienteLogado().getDestinoEscolhido().getPreco() + (obterClienteLogado().getDestinoEscolhido().getPreco() * 0.5);
            return valorTotal;

        } else if (classe.equalsIgnoreCase("executiva")) {
            valorTotal = obterClienteLogado().getDestinoEscolhido().getPreco() + (obterClienteLogado().getDestinoEscolhido().getPreco() * 1.2);
            valorTotal += calculaTarifa();
            return valorTotal;

        }

        return valorTotal;
    }


    public static boolean avaliacao() {
        System.out.println("Bem vindo(a) a nossa área de avaliação!");
        int op;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("O que deseja avaliar?");
            System.out.println("1 - Destino");
            System.out.println("2 - Hospedagem");
            System.out.println("3 - Atrações");
            System.out.println("0 - Sair");
            System.out.print("Opcao: ");
            op = sc.nextInt();

            switch (op) {
                case 1:

                    break;
                case 2:
                    break;
                case 3:
                    break;
            }

        } while (op != 0);


        return true;
    }


}

