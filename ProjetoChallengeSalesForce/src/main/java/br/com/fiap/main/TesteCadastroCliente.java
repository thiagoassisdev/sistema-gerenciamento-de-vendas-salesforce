package br.com.fiap.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.beans.CadastroCliente;
import br.com.fiap.dao.CadastroClienteDAO;

public class TesteCadastroCliente {

	static String texto(String j) {
		return JOptionPane.showInputDialog(j);
	}

	static int inteiro(String j) {
		return Integer.parseInt(JOptionPane.showInputDialog(j));
	}

	static double real(String j) {
		return Double.parseDouble(JOptionPane.showInputDialog(j));
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Instanciar objetos
		CadastroCliente objCadastroCliente = new CadastroCliente();

		CadastroClienteDAO dao = new CadastroClienteDAO();

		objCadastroCliente.setIdEmpresa(inteiro("Insira o ID da empresa"));
		objCadastroCliente.setNome(texto("Insira o nome do cliente a ser cadastrado"));
		objCadastroCliente.setCpf(texto("Cpf do cliente"));
		objCadastroCliente.setTelefone(texto("Telefone do cliente"));
		objCadastroCliente.setEmail(texto("Email do cliente"));
		objCadastroCliente.setSenha(texto("Senha"));

		System.out.println(dao.inserir(objCadastroCliente));

	}

}
