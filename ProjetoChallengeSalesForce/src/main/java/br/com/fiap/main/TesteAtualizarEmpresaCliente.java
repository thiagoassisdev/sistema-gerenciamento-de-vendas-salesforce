package br.com.fiap.main;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.fiap.beans.EmpresaCliente;
import br.com.fiap.dao.EmpresaClienteDAO;

public class TesteAtualizarEmpresaCliente {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Scanner scanner = new Scanner(System.in);
		EmpresaClienteDAO empresaClienteDAO = new EmpresaClienteDAO();

		System.out.print("Digite o nome da empresa que deseja atualizar: ");
		String nome = scanner.nextLine();

		EmpresaCliente empresa = empresaClienteDAO.buscarPorNome(nome);

		if (empresa != null) {
			System.out.println("Dados atuais da empresa:");
			System.out.println("Numero de Funcionarios: " + empresa.getNumeroFuncionarios());
			System.out.println("Renda Mensal: " + empresa.getRendaMensal());
			System.out.println("Setor atuação: " + empresa.getSetorAtuacao());

			System.out.println("Selecione os dados que deseja atualizar:");
			System.out.println("1 - Numero de Funcionarios");
			System.out.println("2 - Renda Mensal");
			System.out.println("3 - Setor atuação");

			int opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
			case 1:
				System.out.print("Digite o novo numero de funcionarios: ");
				int novoNumeroFuncionarios = scanner.nextInt();
				scanner.nextLine();
				empresa.setNumeroFuncionarios(novoNumeroFuncionarios);
				break;
			case 2:
				System.out.print("Digite a nova renda mensal: ");
				double novaRendaMensal = scanner.nextDouble();
				scanner.nextLine();
				empresa.setRendaMensal(novaRendaMensal);
				break;
			case 3:
				System.out.print("Digite o novo setor de atuação: ");
				String novoSetorAtuacao = scanner.nextLine();
				empresa.setSetorAtuacao(novoSetorAtuacao);
				break;

			default:
				System.out.println("Opção inválida. Nenhum dado será atualizado.");
			}

			String resultado = empresaClienteDAO.atualizar(empresa);
			System.out.println(resultado);
		} else {
			System.out.println("Empresa não encontrado.");
		}

		scanner.close();
	}
}