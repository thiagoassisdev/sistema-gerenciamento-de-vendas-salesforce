package br.com.fiap.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.beans.EmpresaCliente;
import br.com.fiap.dao.EmpresaClienteDAO;

public class TesteDeletarEmpresaCliente {

	static String texto(String j) {
		return JOptionPane.showInputDialog(j);
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Instanciar objetos
		EmpresaCliente objEmpresaCliente = new EmpresaCliente();

		EmpresaClienteDAO dao = new EmpresaClienteDAO();

		objEmpresaCliente.setNome(texto("Digite o nome da empresa a ser deletada"));

		System.out.println(dao.deletar(objEmpresaCliente.getNome()));

	}

}
