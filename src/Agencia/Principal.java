package Agencia;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
                                System.out.println("Que bom que escolheu planejar sua viagem com a gente!");
                                System.out.println("Qual data deseja viajar? (Formato DD/MM/YYYY)");
                                String dataString = sc.nextLine();

                                DateTimeFormatter formatar = DateTimeFormatter.ofPattern("DD/MM/YYYY");
                                try {
                                    LocalDate data = LocalDate.parse(dataString, formatar);
                                    System.out.println("Data lida: " + data.format(formatar));
                                } catch (Exception e) {
                                    System.out.println("Formato de data inválido. Certifique-se de que está no formato (DD/MM/YYYY).");
                                }

                                System.out.println("Ótima data! Temos os seguintes destinos disponíveis: ");
                                System.out.println("1 - Paris");
                                System.out.println("2 - Estados Unidos");
                                System.out.println("3 - Espanha");
                                System.out.println("4 - Canadá");
                                System.out.println("5 - Grécia");
                                op2 = sc.nextInt();
                                sc.nextLine();

                                switch (op2){
                                    case 1:
                                        System.out.println("Excelente destino! Temos as seguintes opções de Pacotes");
                                        System.out.println("1 - Pacote A: Roteiro: Hotel A; Atrações A; Tantos dias");
                                        System.out.println("3 - Pacote B: Roteiro: Hotel B; Atrações B; Tantos dias");
                                        System.out.println("4 - Pacote C: Roteiro: Hotel C; Atrações C; Tantos dias");
                                        break;
                                    case 2:
                                        System.out.println("Excelente destino! Temos as seguintes opções de Pacotes");
                                        System.out.println("1 - Pacote A: Roteiro: Hotel A; Atrações A; Tantos dias");
                                        System.out.println("3 - Pacote B: Roteiro: Hotel B; Atrações B; Tantos dias");
                                        System.out.println("4 - Pacote C: Roteiro: Hotel C; Atrações C; Tantos dias");
                                        break;
                                    case 3:
                                        System.out.println("Excelente destino! Temos as seguintes opções de Pacotes");
                                        System.out.println("1 - Pacote A: Roteiro: Hotel A; Atrações A; Tantos dias");
                                        System.out.println("3 - Pacote B: Roteiro: Hotel B; Atrações B; Tantos dias");
                                        System.out.println("4 - Pacote C: Roteiro: Hotel C; Atrações C; Tantos dias");
                                        break;
                                    case 4:
                                        System.out.println("Excelente destino! Temos as seguintes opções de Pacotes");
                                        System.out.println("1 - Pacote A: Roteiro: Hotel A; Atrações A; Tantos dias");
                                        System.out.println("3 - Pacote B: Roteiro: Hotel B; Atrações B; Tantos dias");
                                        System.out.println("4 - Pacote C: Roteiro: Hotel C; Atrações C; Tantos dias");
                                        break;
                                    case 5:
                                        System.out.println("Excelente destino! Temos as seguintes opções de Pacotes");
                                        System.out.println("1 - Pacote A: Roteiro: Hotel A; Atrações A; Tantos dias");
                                        System.out.println("3 - Pacote B: Roteiro: Hotel B; Atrações B; Tantos dias");
                                        System.out.println("4 - Pacote C: Roteiro: Hotel C; Atrações C; Tantos dias");
                                        break;
                                }


                                break;
                        }

                    }while (op1 != 0);
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
            System.out.print("Digite seu email: ");
            String email = sc.next();
            System.out.print("Digite sua senha: ");
            String senha = sc.next();

            System.out.println("Obrigado!");

            String print = nome + ";" + email + ";" + senha;

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
}

