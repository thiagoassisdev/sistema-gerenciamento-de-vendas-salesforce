package br.com.fiap.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.beans.EmpresaCliente;
import br.com.fiap.dao.EmpresaClienteDAO;

public class TesteCadastroEmpresaCliente {

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
		EmpresaCliente objEmpresaCliente = new EmpresaCliente();

		EmpresaClienteDAO dao = new EmpresaClienteDAO();

		objEmpresaCliente.setNome(texto("Insira o nome da empresa a ser cadastrado"));
		objEmpresaCliente.setNumeroFuncionarios(inteiro("Numero de funcionarios"));
		objEmpresaCliente.setRendaMensal(real("Renda mensal"));
		objEmpresaCliente.setSetorAtuacao(texto("Setor de atuação"));

		System.out.println(dao.inserir(objEmpresaCliente));

	}

}
