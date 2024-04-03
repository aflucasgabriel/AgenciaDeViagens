package Agencia;

import java.util.ArrayList;
import java.util.Scanner;

public class Autenticacao {

    private static Cliente clienteLogado;

    public static boolean fazerLogin(String email, String senha, ArrayList<Cliente> clientes) {

        // Suponha que você tenha uma lista de clientes
        for (Cliente cliente : clientes) {
            if (cliente.getEmail().equals(email) && cliente.getSenha().equals(senha)) {
                clienteLogado = cliente;
                return true;
            }
        }

        // Se nenhum cliente corresponder às credenciais fornecidas
        System.out.println("Email ou senha incorretos. Por favor, tente novamente.");
        return false;

    }

    public static Cliente obterClienteLogado() {
        return clienteLogado;
    }
}

