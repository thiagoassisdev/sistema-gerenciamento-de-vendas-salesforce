package br.com.fiap.main;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.beans.EmpresaCliente;
import br.com.fiap.dao.EmpresaClienteDAO;

public class TesteSelecionarEmpresaCadastro {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Instanciar objetos
		EmpresaClienteDAO dao = new EmpresaClienteDAO();

		List<EmpresaCliente> listaEmpresaCliente = dao.selecionar();

		if (listaEmpresaCliente != null && !listaEmpresaCliente.isEmpty()) {
			// fore ach
			for (EmpresaCliente empresaCliente : listaEmpresaCliente) {
				System.out.println(empresaCliente.getNome() + " " + empresaCliente.getNumeroFuncionarios() + " "
						+ empresaCliente.getRendaMensal() + " " + empresaCliente.getSetorAtuacao());
			}
		} else {
			System.out.println("Nenhum cadastro de empresa encontrado.");
		}
	}
}