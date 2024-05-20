package br.com.fiap.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.beans.CadastroCliente;

import br.com.fiap.dao.CadastroClienteDAO;

public class TesteDeletarCadastroCliente {

	static String texto(String j) {
		return JOptionPane.showInputDialog(j);
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Instanciar objetos
		CadastroCliente objCadastroCliente = new CadastroCliente();

		CadastroClienteDAO dao = new CadastroClienteDAO();

		objCadastroCliente.setCpf(texto("Digite o CPF do cliente a ser deletado"));

		System.out.println(dao.deletar(objCadastroCliente.getCpf()));

	}

}
	