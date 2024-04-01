package Agencia;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Principal {
    public static void main(String[] args) {

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

            switch (op){
                case 1:
                    if(loginCliente()){
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

                        switch (op1){
                            case 1:
                                novaViagem();
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
                    }while (op1 != 0);
                    }else{
                        System.out.println("Email ou senha invalidos!");
                        break;
                    }
                    break;
                case 2:
                    cadastraCliente();
                    break;
            }

        }while(op != 0);

    }

    public static boolean cadastraCliente(){

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Digite seu nome completo: ");
            String nome = sc.next();
            System.out.print("Digite sua data de nascimento (dd/MM/yyyy): ");
            String dataNasc = sc.next();
            System.out.print("Digite seu email: ");
            String email = sc.next();
            System.out.print("Digite sua senha: ");
            String senha = sc.next();


            System.out.println("Obrigado!");

            String print = nome + ";" + email + ";" + senha + ";" + dataNasc;

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Clientes.txt"))) {
                writer.write(print);
            } catch (IOException e) {
                System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
            }

            return true;
        }catch (Exception ex){
            System.out.println("ERRO! TENTE NOVAMENTE");
            sc.nextLine();
            return false;
        }
    }

    public static boolean loginCliente(){
        Scanner sc = new Scanner(System.in);

        try {
        System.out.print("Digite seu email: ");
        String email = sc.next();
        System.out.print("Digite sua senha: ");
        String senha = sc.next();

        if(verificaCredencias(email, senha)){
            System.out.println("Login Efetuado!");
            return true;
        }
        }catch (Exception e){
            System.out.println("ERRO! TENTE NOVAMENTE");
            sc.nextLine();
            return false;
        }


        return false;

    }

    public static boolean verificaCredencias(String email, String senha) {

        try (BufferedReader br = new BufferedReader(new FileReader("Clientes.txt"))) {
            String linha; // usada para armazenar cada linha lida
            while ((linha = br.readLine()) != null) {//le cada linha do arquivo até que nao haja mais linhas
                String[] partes = linha.split(";"); //le até o ";" e armazena em uma array chamadas partes
                String emailSalvo = partes[1]; // salva a segunda parte na string que é o email
                String senhaSalva = partes[2]; // salva a terceira parte na string que é a senha
                if (email.equals(emailSalvo) && senha.equals(senhaSalva)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static LocalDate dataCheckIn(){
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Que bom que escolheu planejar sua viagem com a gente!");
        System.out.println("Qual data de ida? (Formato DD/MM/YYYY): ");
        String dataIdaString = sc.nextLine();

            return LocalDate.parse(dataIdaString, formatar);

    }

    public static LocalDate dataCheckOut(){
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Qual data de ida? (Formato DD/MM/YYYY): ");
        String dataVoltaString = sc.nextLine();

        return LocalDate.parse(dataVoltaString, formatar);
    }

    public static int dias(){
        long diferencaEmDias = Math.abs(ChronoUnit.DAYS.between(dataCheckIn(), dataCheckOut()));
        int diferenca = (int) diferencaEmDias;

        return diferenca;
    }


    public static boolean novaViagem(){

        novoDestino();
        novaHospedagem();
        novaAtracao();

        if (novoDestino() && novaHospedagem() && novaAtracao()){

            System.out.println("Perfeito, vamos revisar sua viagem!");
            //fazer relatorio do que foi escolhido
        }
        return false;
    }

public static boolean novaHospedagem(){
    Scanner sc = new Scanner(System.in);

    System.out.println("Agora vamos escolher qual hotel deseja se hospedar para ter a melhor experiência!");

    try {
        ArrayList<Hospedagem> hospedagem = new ArrayList<>();
        Hospedagem[] hosp = new Hospedagem[3];
        List<String> servicosHotelLotus = new ArrayList<>();
        servicosHotelLotus.add("Wi-Fi");
        servicosHotelLotus.add("Café da manhã");
        servicosHotelLotus.add("Almoço");

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
        servicosHotelSavana.add("Estacionamento");


        hosp[0] = new Hospedagem("Hotel Lotus", "Rua das Palmeiras, 103", dataCheckIn(), dataCheckOut(), 150, 15, servicosHotelLotus);
        hosp[1] = new Hospedagem("Hotel Savana", "Avenida Principal, 6384", dataCheckIn(), dataCheckOut(), 200, 3, servicosHotelSavana);
        hosp[2] = new Hospedagem("Hotel Carlton", "Avenida Doutor Hans Chucrute, 257", dataCheckIn(), dataCheckOut(), 300, 8, servicosHotelCarlton);

        hospedagem.addAll(Arrays.asList(hosp).subList(0, 3));


        for (int i = 0; i < hospedagem.size(); i++) {
            System.out.println("Nome do Hotel: " + hospedagem.get(i).getNomeHotel() +
                    "\nPreço Diária: " + hospedagem.get(i).getPrecoDiario() + "\nServiços: " + hospedagem.get(i).getServicosInclusos());
        }

        System.out.print("Qual deseja escolher?(Digite o nome do Hotel): ");
        String hotel = sc.next();
        sc.nextLine();

        for (Hospedagem h : hospedagem) {
            if (h.getNomeHotel().equalsIgnoreCase(hotel)) {
                System.out.println("Nome: " + h.getNomeHotel());
                System.out.println("Endereço: " + h.getLocalizacao());
                System.out.println("Preço total: " + h.calcularPreco());
            }
        }
        System.out.println("Excelente escolha!");
        return true;
    }catch (Exception ex){
        System.out.println("Algo deu errado!");
        return false;
    }
}

public static boolean novaAtracao(){
    Scanner sc = new Scanner(System.in);

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


            atracoes.addAll(Arrays.asList(at).subList(0, 9));

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
        return true;
    }catch (Exception ex){
        System.out.println("Algo deu errado!");
        return false;
    }
}

public static boolean novoDestino(){
    Scanner sc = new Scanner(System.in);

    try {
        ArrayList<Destino> destinos = new ArrayList<>();
        Destino[] dest = new Destino[5];

        dest[0] = new Destino("Paris", "Europa", "A cidade do Amor!", "Torre Eiffel, Arco do Triunfo", 5500);
        dest[1] = new Destino("Los Angeles", "America do Norte", "A cidade da diversão!!", "Hollywood, cassinos!", 3265.99);
        dest[2] = new Destino("Lisboa", "Europa", "A cidade histórica!", "Castelo de São Jorge, Praias paradisíacas!", 3899.99);
        dest[3] = new Destino("Ottawa", "America do Norte", "A cidade dos Festivais!!", "Colina do Parlamento, Inúmeros museus!", 1879.59);
        dest[4] = new Destino("Atenas", "Europa", "A cidade eterna, repleta de história e arquitetura magnífica.", "Partenon, Acrópole!", 4689.89);

        destinos.addAll(Arrays.asList(dest).subList(0,5));

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

    }catch (Exception e){
        System.out.println("ERRO! TENTE NOVAMENTE");
        sc.nextLine();
        return false;
    }
}

public static boolean avaliacao(){
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

        switch (op){
            case 1:

                break;
            case 2:
                break;
            case 3:
                break;
        }

    }while(op != 0);


    return true;
}


}

