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


        Hospedagem[] hosp = new Hospedagem[3];
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
                            System.out.println("2 - Hospedagem");
                            System.out.println("3 - Atração");
                            System.out.println("4 - Histórico");
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

                                    hosp = new Hospedagem[3];
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

                                    for (int i = 0; i < hosp.length; i++) {
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
                                    obterClienteLogado().getHospedagemEscolhida().setNumDias(dias());
                                    double total = obterClienteLogado().getHospedagemEscolhida().calcularPreco();
                                    Hospedagem hosped = new Hospedagem(obterClienteLogado().getHospedagemEscolhida().getNomeHotel(), obterClienteLogado().getHospedagemEscolhida().getLocalizacao(), dataIda, dataVolta, obterClienteLogado().getHospedagemEscolhida().getPrecoDiario(), obterClienteLogado().getHospedagemEscolhida().getQuartosDisponiveis(), obterClienteLogado().getHospedagemEscolhida().getServicosInclusos());
                                    hospedagem.add(hosped);
                                    System.out.println("Total da Hospedagem: R$" + total);

                                    System.out.println("Excelente escolha!");

                                    System.out.print("Deseja incluir atrações na sua viagem?\nTemos atrações como museus, restaurantes, cachoeiras etc(sim/nao): ");
                                    String escolhaAtracao = sc.nextLine();
                                    sc.nextLine();

                                    if (escolhaAtracao.equals("sim")) {

                                        System.out.println("Vamos às atrações que você pode adquirir!");

                                        ArrayList<Atracao> atracoes = new ArrayList<>();

                                        Atracao[] at = new Atracao[9];

                                        at[0] = new AtracaoPaga("Pontos Turísticos Premium", "Um passeio incrível por todos os pontos turísticos da cidade!", "8h às 15h", 150, "Ponto Turistico", obterClienteLogado().getDestinoEscolhido());
                                        at[1] = new AtracaoGratuita("Museus, Exposições de arte e Feiras de artesanato", "Roteiro de passeios culturais ideal para conhecer a cultura da cidade!", "13h às 22h", 120, "Cultural", obterClienteLogado().getDestinoEscolhido());
                                        at[2] = new AtracaoPaga("Teatros, Concertos e Óperas Premium", "Ingressos para eventos culturais que estão acontecendo na cidade!", "15h às 23h", 200, "Cultural", obterClienteLogado().getDestinoEscolhido());
                                        at[3] = new AtracaoPaga("Restaurantes Premium", "Uma mesa reservada nos 2 melhores restaurantes para você conhecer a culinária local!", "17h às 23h", 80, "Gastronômico", obterClienteLogado().getDestinoEscolhido());
                                        at[4] = new AtracaoGratuita("Padarias e Cafes", "Um guia das melhores padarias e cafés para você apreciar!", "6h às 18h", 150, "Gastronômico", obterClienteLogado().getDestinoEscolhido());
                                        at[5] = new AtracaoGratuita("Cachoeiras, Parques, Praias", "Um rolê mais natural? Que tal visitar as belezas naturais da cidade?", "8h às 15h", 250, "Natureza", obterClienteLogado().getDestinoEscolhido());
                                        at[6] = new AtracaoPaga("Spa Premium", "Quer algo mais tranquilo pra relaxar? Um dia de spa para você!", "8h às 21h", 100, "Bem estar", obterClienteLogado().getDestinoEscolhido());
                                        at[7] = new AtracaoPaga("Esportes Radicais Premium", "Um roteiro com os melhores pontos de esportes radicais presentes na cidade!", "6h às 16h", 80, "Esportes", obterClienteLogado().getDestinoEscolhido());
                                        at[8] = new AtracaoGratuita("Aventura", "Ideal para você que curte um paraquedismo ou uma tirolesa!", "8h às 15h", 250, "Esportes", obterClienteLogado().getDestinoEscolhido());


                                        for (int i = 0; i < at.length; i++) {
                                            if (at[i] instanceof AtracaoGratuita) {
                                                System.out.println("Essas são as Atrações Gratuitas que você tem direito!");
                                                System.out.println("Nome: " + at[i].getNomeAtracao() + "\nDescrição: " + at[i].getDescricao() +
                                                        "\nHorário de Funcionamento: " + at[i].getHorario() + "\nPreço: R$" + at[i].getPreco());
                                            } else {
                                                System.out.println("Essas são as Atrações Pagas que você pode escolher!");
                                                System.out.println("Nome: " + at[i].getNomeAtracao() + "\nDescrição: " + at[i].getDescricao() +
                                                        "\nHorário de Funcionamento: " + at[i].getHorario() + "\nPreço: R$" + at[i].getPreco());
                                            }
                                            atracoes.add(at[i]);
                                        }

                                        int indiceEscolhido;
                                        String resposta;
                                        ArrayList<Atracao> atracoesEscolhidas = new ArrayList<>();
                                        do {
                                            System.out.print("Qual deseja escolher (digite o número do índice ou 'sair' para terminar)?: ");
                                            resposta = sc.nextLine();

                                            try {
                                                if (resposta.equalsIgnoreCase("sair")) {
                                                    break;
                                                }
                                                indiceEscolhido = Integer.parseInt(resposta);
                                                if (indiceEscolhido >= 0 && indiceEscolhido < at.length) {
                                                    Atracao atracaoEscolhida = atracoes.get(indiceEscolhido);
                                                    if (atracaoEscolhida.verificarDisponibilidade()) {
                                                        atracoesEscolhidas.add(atracaoEscolhida);
                                                    }else{
                                                        System.out.println("Desculpe, Atração Indisponível!");
                                                    }
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
                                            System.out.println("Horário: " + a.getHorario());
                                            System.out.println("Preço: " + a.getPreco());
                                            System.out.println();
                                        }
                                        System.out.println("-----Preço total das atrações-----");
                                        System.out.println("R$ :" + precoTotal);

                                        obterClienteLogado().setAtracaosEscolhidas(atracoesEscolhidas);
                                    }

                                    System.out.println("Perfeito! \nCompra finalizada!\nVamos revisar seu pedido!");
                                    Produto produto = new Produto("Pacote de Viagem", "Escolha de Passagem, Hospedagem e Atrações para uma viagem!", obterClienteLogado().getPassagemEscolhida(), obterClienteLogado().getHospedagemEscolhida(), obterClienteLogado().getAtracaosEscolhidas());
                                    obterClienteLogado().getDestinoEscolhido().relatorioDestino();
                                    obterClienteLogado().getHospedagemEscolhida().relatorioHospedagem();
                                    obterClienteLogado().getPassagemEscolhida().relatorioPassagem();
                                    for (Atracao a : atracao){
                                        a.relatorioAtracao();
                                    }

                                    Viagem viagem = new Viagem(obterClienteLogado(), produto);

                                    System.out.println("Obrigado por comprar com a gente! Volte Sempre!!");

                                    break;

                                case 2:

                                    System.out.println("Perfeito! Vamos escolher sua hospedagem");
                                    LocalDate dataIdaH = dataCheckIn();
                                    LocalDate dataVoltaH = dataCheckOut();

                                    List<String> hotelLotus = new ArrayList<>();
                                    hotelLotus.add("Wi-Fi");
                                    hotelLotus.add("Café da manhã");

                                    List<String> hotelSavana = new ArrayList<>();
                                    hotelSavana.add("Wi-Fi");
                                    hotelSavana.add("Café da manhã");
                                    hotelSavana.add("Piscina");
                                    hotelSavana.add("Almoço e Janta");

                                    List<String> hotelCarlton = new ArrayList<>();
                                    hotelCarlton.add("Wi-Fi");
                                    hotelCarlton.add("Café da manhã");
                                    hotelCarlton.add("Piscina");
                                    hotelCarlton.add("Academia");
                                    hotelCarlton.add("Almoço e Janta");
                                    hotelCarlton.add("Estacionamento");

                                    hosp[0] = new Hospedagem("Lotus", "Rua das Palmeiras, 103", dataCheckIn(), dataCheckOut(), 150, 15, hotelLotus);
                                    hosp[1] = new Hospedagem("Savana", "Avenida Principal, 6384", dataCheckIn(), dataCheckOut(), 200, 3, hotelSavana);
                                    hosp[2] = new Hospedagem("Carlton", "Avenida Doutor Hans Chucrute, 257", dataCheckIn(), dataCheckOut(), 300, 8, hotelCarlton);


                                    for (int i = 0; i < hosp.length; i++) {
                                        System.out.println("Nome do Hotel: " + hosp[i].getNomeHotel() +
                                                "\nPreço Diária: " + hosp[i].getPrecoDiario() + "\nServiços: " + hosp[i].getServicosInclusos());
                                    }

                                    System.out.print("Qual deseja escolher?(Digite o nome do Hotel): ");
                                    String hotelh = sc.next();
                                    sc.nextLine();

                                    for (int i = 0; i < hosp.length; i++) {
                                        if (hosp[i].getNomeHotel().equalsIgnoreCase(hotelh)) {
                                            System.out.println("Destino: " + hosp[i].getNomeHotel());
                                            System.out.println("Endereço: " + hosp[i].getLocalizacao());
                                            System.out.println("Preço: " + hosp[i].getPrecoDiario());

                                        }
                                        obterClienteLogado().setHospedagemEscolhida(hosp[i]);

                                    }
                                    obterClienteLogado().getHospedagemEscolhida().setNumDias(dias());
                                    double totalA = obterClienteLogado().getHospedagemEscolhida().calcularPreco();
                                    Hospedagem hospeda = new Hospedagem(obterClienteLogado().getHospedagemEscolhida().getNomeHotel(), obterClienteLogado().getHospedagemEscolhida().getLocalizacao(), dataIdaH, dataVoltaH, obterClienteLogado().getHospedagemEscolhida().getPrecoDiario(), obterClienteLogado().getHospedagemEscolhida().getQuartosDisponiveis(), obterClienteLogado().getHospedagemEscolhida().getServicosInclusos());
                                    hospedagem.add(hospeda);
                                    System.out.println("Total da Hospedagem: R$" + totalA);

                                    Produto produtoHosp = new Produto("Hospedagem", "Escolha de uma hospedagem", null, obterClienteLogado().getHospedagemEscolhida(), null);
                                    Viagem vHosp = new Viagem(obterClienteLogado(), produtoHosp);

                                    obterClienteLogado().getHospedagemEscolhida().relatorioHospedagem();

                                    System.out.println("\nExcelente escolha! Volte sempre!");
                                    break;
                                case 3:
                                    System.out.println("Vamos às atrações que você pode adquirir!");

                                    ArrayList<Atracao> atracoes = new ArrayList<>();

                                    Atracao[] at = new Atracao[9];

                                    at[0] = new AtracaoPaga("Pontos Turísticos Premium", "Um passeio incrível por todos os pontos turísticos da cidade!", "8h às 15h", 150, "Ponto Turistico", obterClienteLogado().getDestinoEscolhido());
                                    at[1] = new AtracaoGratuita("Museus, Exposições de arte e Feiras de artesanato", "Roteiro de passeios culturais ideal para conhecer a cultura da cidade!", "13h às 22h", 120, "Cultural", obterClienteLogado().getDestinoEscolhido());
                                    at[2] = new AtracaoPaga("Teatros, Concertos e Óperas Premium", "Ingressos para eventos culturais que estão acontecendo na cidade!", "15h às 23h", 200, "Cultural", obterClienteLogado().getDestinoEscolhido());
                                    at[3] = new AtracaoPaga("Restaurantes Premium", "Uma mesa reservada nos 2 melhores restaurantes para você conhecer a culinária local!", "17h às 23h", 80, "Gastronômico", obterClienteLogado().getDestinoEscolhido());
                                    at[4] = new AtracaoGratuita("Padarias e Cafes", "Um guia das melhores padarias e cafés para você apreciar!", "6h às 18h", 150, "Gastronômico", obterClienteLogado().getDestinoEscolhido());
                                    at[5] = new AtracaoGratuita("Cachoeiras, Parques, Praias", "Um rolê mais natural? Que tal visitar as belezas naturais da cidade?", "8h às 15h", 250, "Natureza", obterClienteLogado().getDestinoEscolhido());
                                    at[6] = new AtracaoPaga("Spa Premium", "Quer algo mais tranquilo pra relaxar? Um dia de spa para você!", "8h às 21h", 100, "Bem estar", obterClienteLogado().getDestinoEscolhido());
                                    at[7] = new AtracaoPaga("Esportes Radicais Premium", "Um roteiro com os melhores pontos de esportes radicais presentes na cidade!", "6h às 16h", 80, "Esportes", obterClienteLogado().getDestinoEscolhido());
                                    at[8] = new AtracaoGratuita("Aventura", "Ideal para você que curte um paraquedismo ou uma tirolesa!", "8h às 15h", 250, "Esportes", obterClienteLogado().getDestinoEscolhido());


                                    for (int i = 0; i < at.length; i++) {
                                        if (at[i] instanceof AtracaoGratuita) {
                                            System.out.println("Essas são as Atrações Gratuitas que você tem direito!");
                                            System.out.println("Nome: " + at[i].getNomeAtracao() + "\nDescrição: " + at[i].getDescricao() +
                                                    "\nHorário de Funcionamento: " + at[i].getHorario() + "\nPreço: R$" + at[i].getPreco());
                                        } else {
                                            System.out.println("Essas são as Atrações Pagas que você pode escolher!");
                                            System.out.println("Nome: " + at[i].getNomeAtracao() + "\nDescrição: " + at[i].getDescricao() +
                                                    "\nHorário de Funcionamento: " + at[i].getHorario() + "\nPreço: R$" + at[i].getPreco());
                                        }
                                        atracoes.add(at[i]);
                                    }

                                    int indiceEscolhido;
                                    String resposta;
                                    ArrayList<Atracao> atracoesEscolhidas = new ArrayList<>();
                                    do {
                                        System.out.print("Qual deseja escolher (digite o número do índice ou 'sair' para terminar)?: ");
                                        resposta = sc.nextLine();

                                        try {
                                            if (resposta.equalsIgnoreCase("sair")) {
                                                break;
                                            }
                                            indiceEscolhido = Integer.parseInt(resposta);
                                            if (indiceEscolhido >= 0 && indiceEscolhido < at.length) {
                                                Atracao atracaoEscolhida = atracoes.get(indiceEscolhido);
                                                if (atracaoEscolhida.verificarDisponibilidade()) {
                                                    atracoesEscolhidas.add(atracaoEscolhida);
                                                }else{
                                                    System.out.println("Desculpe, Atração Indisponível!");
                                                }
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
                                        System.out.println("Horário: " + a.getHorario());
                                        System.out.println("Preço: " + a.getPreco());
                                        System.out.println();
                                    }
                                    System.out.println("-----Preço total das atrações-----");
                                    System.out.println("R$ :" + precoTotal);

                                    obterClienteLogado().setAtracaosEscolhidas(atracoesEscolhidas);

                                    Produto produtoAtr = new Produto("Compra de Atrações!", "Escolha de Atrações!", null, null, obterClienteLogado().getAtracaosEscolhidas());

                                    Viagem vAtracao = new Viagem(obterClienteLogado(), produtoAtr);

                                    break;
                                case 4:

                                    System.out.println("Bem vindo ao seu Histórito de Viagens!");

                                        obterClienteLogado().relatorio();


                                    break;
                                case 5:
                                    int opAv;
                                    System.out.println("Vamos avaliar sua experiência com a gente?");
                                    do {
                                        System.out.println("1 - Passagem");
                                        System.out.println("2 - Hospedagem");
                                        System.out.println("3 - Atrações");
                                        System.out.print("Opcao: ");
                                        opAv = sc.nextInt();

                                        switch (opAv){
                                            case 1:
                                                System.out.println("Vamos avaliar como foi sua experiência!");
                                                obterClienteLogado().getPassagemEscolhida().relatorioPassagem();

                                                System.out.print("Escreva sua avaliação: ");
                                                String avaliacaoP = sc.next();

                                                obterClienteLogado().getPassagemEscolhida().relatorioAvaliacao(avaliacaoP);


                                                break;
                                            case 2:
                                                System.out.println("Vamos avaliar como foi sua experiência!");
                                                obterClienteLogado().getHospedagemEscolhida().relatorioHospedagem();

                                                System.out.print("Escreva sua avaliação: ");
                                                String avaliacaoH = sc.next();

                                                obterClienteLogado().getHospedagemEscolhida().relatorioAvaliacao(avaliacaoH);

                                                break;
                                            case 3:
                                                System.out.println("Vamos avaliar como foi sua experiência!");

                                                for(int i = 0; i < obterClienteLogado().getAtracaosEscolhidas().size(); i++){
                                                    obterClienteLogado().getAtracaosEscolhidas().get(i).relatorioAtracao();
                                                }

                                                System.out.print("Escreva sua avaliação: ");
                                                String avaliacaoA = sc.next();

                                                for (int i = 0; i < obterClienteLogado().getAtracaosEscolhidas().size(); i++){
                                                    obterClienteLogado().getAtracaosEscolhidas().get(i).relatorioAvaliacao(avaliacaoA);
                                                }

                                                break;
                                        }

                                    }while(opAv != 0);
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

}

