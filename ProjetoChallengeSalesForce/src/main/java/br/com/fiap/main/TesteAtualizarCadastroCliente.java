package br.com.fiap.main;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.fiap.beans.CadastroCliente;
import br.com.fiap.dao.CadastroClienteDAO;

public class TesteAtualizarCadastroCliente {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        CadastroClienteDAO cadastroClienteDAO = new CadastroClienteDAO();

        System.out.print("Digite o CPF do cliente que deseja atualizar: ");
        String cpf = scanner.nextLine();

        CadastroCliente cliente = cadastroClienteDAO.buscarPorCpf(cpf);

        if (cliente != null) {
            System.out.println("Dados atuais do cliente:");
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Email: " + cliente.getEmail());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("Senha: " + cliente.getSenha());

            System.out.println("Selecione os dados que deseja atualizar:");
            System.out.println("1 - Nome");
            System.out.println("2 - Email");
            System.out.println("3 - Telefone");
            System.out.println("4 - Senha");
            System.out.println("5 - Todos os dados");

            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Digite o novo nome: ");
                    String novoNome = scanner.nextLine();
                    cliente.setNome(novoNome);
                    break;
                case 2:
                    System.out.print("Digite o novo email: ");
                    String novoEmail = scanner.nextLine();
                    cliente.setEmail(novoEmail);
                    break;
                case 3:
                    System.out.print("Digite o novo telefone: ");
                    String novoTelefone = scanner.nextLine();
                    cliente.setTelefone(novoTelefone);
                    break;
                case 4:
                    System.out.print("Digite a nova senha: ");
                    String novaSenha = scanner.nextLine();
                    cliente.setSenha(novaSenha);
                    break;
                case 5:
                    System.out.print("Digite o novo nome: ");
                    novoNome = scanner.nextLine();
                    cliente.setNome(novoNome);

                    System.out.print("Digite o novo email: ");
                    novoEmail = scanner.nextLine();
                    cliente.setEmail(novoEmail);

                    System.out.print("Digite o novo telefone: ");
                    novoTelefone = scanner.nextLine();
                    cliente.setTelefone(novoTelefone);

                    System.out.print("Digite a nova senha: ");
                    novaSenha = scanner.nextLine();
                    cliente.setSenha(novaSenha);
                    break;
                default:
                    System.out.println("Opção inválida. Nenhum dado será atualizado.");
            }

            String resultado = cadastroClienteDAO.atualizar(cliente);
            System.out.println(resultado);
        } else {
            System.out.println("Cliente não encontrado.");
        }

        scanner.close();
    }
}