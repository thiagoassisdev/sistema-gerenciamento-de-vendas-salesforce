package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.EmpresaCliente;
import br.com.fiap.dao.EmpresaClienteDAO;

public class EmpresaClienteBO {

	EmpresaClienteDAO empresaClienteDAO;

	public ArrayList<EmpresaCliente> selecionarBo() throws ClassNotFoundException, SQLException {
		empresaClienteDAO = new EmpresaClienteDAO();

		// Regra de negocios

		return (ArrayList<EmpresaCliente>) empresaClienteDAO.selecionar();
	}

	public void inserirBo(EmpresaCliente empresaCliente) throws ClassNotFoundException, SQLException {
		EmpresaClienteDAO empresaClienteDAO = new EmpresaClienteDAO();

		// regra de negocios

		empresaClienteDAO.inserir(empresaCliente);
	}

	public void atualizarBo(EmpresaCliente empresaCliente) throws ClassNotFoundException, SQLException {
		EmpresaClienteDAO empresaClienteDAO = new EmpresaClienteDAO();

		// Regra de negocios

		empresaClienteDAO.atualizar(empresaCliente);
	}

	// Deletar
	public void deletarBo(String nome) throws ClassNotFoundException, SQLException {
		EmpresaClienteDAO empresaClienteDAO = new EmpresaClienteDAO();

		// REGRA DE NEGOCIOS

		empresaClienteDAO.deletar(nome);
	}

}
