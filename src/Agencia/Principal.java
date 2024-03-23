package Agencia;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
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
                        System.out.println("1 - Nova Viagem");
                        System.out.println("2 - Histórico de Viagens");
                        System.out.println("0 - Sair");
                        System.out.print("Opcao: ");
                        op1 = sc.nextInt();
                        sc.nextLine();

                        switch (op1){
                            case 1:
                                novaViagem();
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


    public static boolean novaViagem(){
        Scanner sc = new Scanner(System.in);

        try {
            ArrayList<Destino> destinos = new ArrayList<>();
            destinos.add(new Destino("Paris", "Europa", "A cidade do Amor!", "Torre Eiffel, Arco do Triunfo"));
            destinos.add(new Destino("Los Angeles", "America do Norte", "A cidade da diversão!!", "Hollywood, cassinos!"));
            destinos.add(new Destino("Lisboa", "Europa", "A cidade histórica!", "Castelo de São Jorge, Praias paradisíacas!"));
            destinos.add(new Destino("Ottawa", "America do Norte", "A cidade dos Festivais!!", "Colina do Parlamento, Inúmeros museus!"));
            destinos.add(new Destino("Atenas", "Europa", "A cidade eterna, repleta de história e arquitetura magnífica.", "Partenon, Acrópole!"));

            dataCheckIn();
            dataCheckOut();

            System.out.println("Ótima data! Temos os seguintes destinos disponíveis: ");
            for (Destino value : destinos) {
                System.out.println(value.getNome());
            }
            System.out.print("Qual deseja escolher?: ");
            String destino = sc.next();
            sc.nextLine();

            for (Destino d : destinos) {
                if (d.getNome().equalsIgnoreCase(destino)) {
                    System.out.println("Destino: " + d.getNome());
                    System.out.println("Descrição: " + d.getDescricao());

                }
            }
            System.out.println("Excelente escolha!");
            System.out.println("Agora vamos escolher qual hotel deseja se hospedar para ter a melhor experiência!");

            ArrayList<Hospedagem> hospedagem = new ArrayList<>();

            hospedagem.add(new Hospedagem("Hotel Lotus", "Rua das Palmeiras, 103",
                    dataCheckIn(), dataCheckOut(), hospedagem.get(0).calcularEstadia(), 150));
            hospedagem.add(new Hospedagem("Hotel Savana", "Avenida Principal, 6384",
                    dataCheckIn(), dataCheckOut(), hospedagem.get(1).calcularEstadia(), 200));
            hospedagem.add(new Hospedagem("Hotel Carlton", "Avenida Doutor Hans Chucrute, 257",
                    dataCheckIn(), dataCheckOut(), hospedagem.get(2).calcularEstadia(), 300));


            for (int i = 0; i < hospedagem.size(); i++) {
                System.out.println("Nome do Hotel: " + hospedagem.get(i).getNomeHotel() +
                        "\nPreço Diária: " + hospedagem.get(i).getPrecoDiaria());
            }

            System.out.print("Qual deseja escolher?: ");
            String hotel = sc.next();
            sc.nextLine();

            for (Hospedagem h : hospedagem){
                if(h.getNomeHotel().equalsIgnoreCase(hotel)){
                    System.out.println("Nome: " + h.getNomeHotel());
                    System.out.println("Endereço: " + h.getLocalizacao());
                    System.out.println("Preço total: " + h.calcularPrecoEstadia());
                }
            }
            System.out.println("Excelente escolha!");

            System.out.println("Vamos as atrações que estão incluídas no pacote!");

            ArrayList<Atração> atracoes = new ArrayList<>();

            atracoes.add(new Atração("Pontos Turísticos", "Um passeio incrível por todos os pontos turísticos da cidade!", "8h às 15h", 150, "Ponto Turistico"));
            atracoes.add(new Atração("Museus, Exposições de arte e Feiras de artesanato", "Roteiro de passeios culturais ideal para conhecer a cultura da cidade!", "13h às 22h", 120, "Cultural"));
            atracoes.add(new Atração("Teatros, Concertos e Óperas", "Ingressos para eventos culturais que estão acontecendo na cidade!", "15h às 23h", 200, "Cultural"));
            atracoes.add(new Atração("Restaurantes", "Uma mesa reservada nos 2 melhores restaurantes para você conhecer a culinaria local!", "17h às 23h", 80, "Gastronômico"));
            atracoes.add(new Atração("Padarias e Cafes", "Um guia das melhores padarias e cafés para você apreciar!", "6h às 18h", 150, "Gastronômico"));
            atracoes.add(new Atração("Cachoeiras, Parques, Praias", "Um rolê mais natural? Que tal visitar as belezas naturais da cidade?", "8h às 15h", 250, "Natureza"));
            atracoes.add(new Atração("Spa", "Quer algo mais tranquilo pra relaxar? Um dia de spa para voce!", "8h às 21h", 100, "Bem estar"));
            atracoes.add(new Atração("Esportes Radicais", "Um roteiro com os melhores pontos de esportes radicais presentes na cidade!", "6h às 16h", 80, "Esportes"));
            atracoes.add(new Atração("Aventura", "Ideal para você que curte um paraquedismo ou uma tirolesa!", "8h às 15h", 250, "Esportes"));

            for (int i = 0; i < atracoes.size(); i++) {
                System.out.println((i) + atracoes.get(i).getNomeAtracao() +
                        "\nPreço Por Pessoa: " + atracoes.get(i).getPreco() + "\nDescrição: " + atracoes.get(i).getDescricao());
            }

            System.out.print("Qual deseja escolher?: ");
            String atracao = sc.next();
            sc.nextLine();

            for (Atração a : atracoes){
                if(a.getNomeAtracao().equalsIgnoreCase(atracao)){
                    System.out.println("Nome: " + a.getNomeAtracao());
                    System.out.println("Horario: " + a.getHorario());
                    System.out.println("Preço total: " + a.getPreco()); // calcular preço baseado na quantidade de pessoas
                }
            }




            return true;

        }catch (Exception e){
            System.out.println("ERRO! TENTE NOVAMENTE");
            sc.nextLine();
            return false;
        }
}


}

