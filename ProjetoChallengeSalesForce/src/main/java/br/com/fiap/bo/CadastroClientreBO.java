package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.CadastroCliente;
import br.com.fiap.dao.CadastroClienteDAO;

public class CadastroClientreBO {

	CadastroClienteDAO cadastroClienteDAO;

	public ArrayList<CadastroCliente> selecionarBo() throws ClassNotFoundException, SQLException {
		cadastroClienteDAO = new CadastroClienteDAO();

		// Regra de negocios

		return (ArrayList<CadastroCliente>) cadastroClienteDAO.selecionar();
	}

	public void inserirBo(CadastroCliente cadastroCliente) throws ClassNotFoundException, SQLException {
		CadastroClienteDAO cadastroClienteDAO = new CadastroClienteDAO();

		// regra de negocios

		cadastroClienteDAO.inserir(cadastroCliente);
	}

	public void atualizarBo(CadastroCliente cadastroCliente) throws ClassNotFoundException, SQLException {
		CadastroClienteDAO cadastroClienteDAO = new CadastroClienteDAO();

		// Regra de negocios

		cadastroClienteDAO.atualizar(cadastroCliente);
	}

	// Deletar
	public void deletarBo(String cpf) throws ClassNotFoundException, SQLException {
	    CadastroClienteDAO cadastroClienteDAO = new CadastroClienteDAO();
	    
	    
	    cadastroClienteDAO.deletar(cpf);
	}

		// REGRA DE NEGOCIOS


}
