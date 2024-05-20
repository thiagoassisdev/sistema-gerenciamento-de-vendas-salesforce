package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import br.com.fiap.beans.CadastroCliente;
import br.com.fiap.conexoes.ConexaoFactory;

public class CadastroClienteDAO {

	public Connection minhaConexao;

	public CadastroClienteDAO() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConexaoFactory().conexao();
	}

	
	//buscar CPF	
	public CadastroCliente buscarPorCpf(String cpf) throws SQLException {
	    CadastroCliente cliente = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;

	    try {
	        stmt = minhaConexao.prepareStatement("SELECT * FROM CADASTRO_CLIENTE WHERE CPF = ?");
	        stmt.setString(1, cpf);
	        rs = stmt.executeQuery();

	        if (rs.next()) {
	            cliente = new CadastroCliente();
	            cliente.setIdEmpresa(rs.getInt("ID_EMPRESA"));
	            cliente.setNome(rs.getString("NOME"));
	            cliente.setCpf(rs.getString("CPF"));
	            cliente.setTelefone(rs.getString("TELEFONE"));
	            cliente.setEmail(rs.getString("EMAIL"));
	            cliente.setSenha(rs.getString("SENHA"));
	        }
	    } finally {
	        if (rs != null) {
	            rs.close();
	        }
	        if (stmt != null) {
	            stmt.close();
	        }
	    }

	    return cliente;
	}
	
	
	
	// Inserir
	public String inserir(CadastroCliente cadastroCliente) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement(
				"INSERT INTO CADASTRO_CLIENTE (ID_EMPRESA, NOME, CPF, TELEFONE, EMAIL, SENHA) VALUES (?, ?, ?, ?, ?, ?)");
		stmt.setInt(1, cadastroCliente.getIdEmpresa());
		stmt.setString(2, cadastroCliente.getNome());
		stmt.setString(3, cadastroCliente.getCpf());
		stmt.setString(4, cadastroCliente.getTelefone());
		stmt.setString(5, cadastroCliente.getEmail());
		stmt.setString(6, cadastroCliente.getSenha());

		stmt.execute();
		stmt.close();

		return "Cadastro realizado com sucesso!";
	}
	
	
	// Atualizar
	public String atualizar(CadastroCliente cadastroCliente) throws SQLException {
	    String cpf = cadastroCliente.getCpf();
	    CadastroCliente cadastroCliente1 = buscarPorCpf(cpf);

	    if (cadastroCliente1 != null) {
	        PreparedStatement stmt = null;

	        try {
	            stmt = minhaConexao.prepareStatement(
	                    "UPDATE CADASTRO_CLIENTE SET ID_EMPRESA = ?, NOME = ?, TELEFONE = ?, EMAIL = ?, SENHA = ? WHERE CPF = ?");
	            stmt.setInt(1, cadastroCliente.getIdEmpresa());
	            stmt.setString(2, cadastroCliente.getNome());
	            stmt.setString(3, cadastroCliente.getTelefone());
	            stmt.setString(4, cadastroCliente.getEmail());
	            stmt.setString(5, cadastroCliente.getSenha());
	            stmt.setString(6, cpf);

	            int linhasAfetadas = stmt.executeUpdate();

	            if (linhasAfetadas > 0) {
	                return "Cadastro atualizado com sucesso!";
	            } else {
	                return "Não foi possível atualizar o cadastro. Verifique se os dados estão corretos.";
	            }
	        } finally {
	            if (stmt != null) {
	                stmt.close();
	            }
	        }
	    } else {
	        return "Cliente não encontrado.";
	    }
	}
	
	
	
	
	// Deletar
	public String deletar(String cpf) throws SQLException {
	    CadastroCliente cadastroCliente = buscarPorCpf(cpf);

	    if (cadastroCliente != null) {
	        PreparedStatement stmt = null;

	        try {
	            stmt = minhaConexao.prepareStatement(
	                    "DELETE FROM CADASTRO_CLIENTE WHERE CPF = ?");
	            stmt.setString(1, cpf);
	            int linhasAfetadas = stmt.executeUpdate();

	            if (linhasAfetadas > 0) {
	                return "Cliente deletado com sucesso!";
	            } else {
	                return "Não foi possível deletar o cliente. Verifique se o CPF está correto.";
	            }
	        } finally {
	            if (stmt != null) {
	                stmt.close();
	            }
	        }
	    } else {
	        return "Cliente não encontrado.";
	    }
	}

	


	// Selecionar
	public List<CadastroCliente> selecionar() throws SQLException {
	    List<CadastroCliente> listaCadastroCliente = new ArrayList<CadastroCliente>();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;

	    try {
	        stmt = minhaConexao.prepareStatement("SELECT * FROM CADASTRO_CLIENTE");
	        rs = stmt.executeQuery();

	        while (rs.next()) {
	            CadastroCliente cadastroCliente = new CadastroCliente();
	            cadastroCliente.setIdEmpresa(rs.getInt("ID_EMPRESA"));
	            cadastroCliente.setNome(rs.getString("NOME"));
	            cadastroCliente.setCpf(rs.getString("CPF"));
	            cadastroCliente.setTelefone(rs.getString("TELEFONE"));
	            cadastroCliente.setEmail(rs.getString("EMAIL"));
	            cadastroCliente.setSenha(rs.getString("SENHA"));
	            listaCadastroCliente.add(cadastroCliente);
	        }
	    } finally {
	        if (rs != null) {
	            rs.close();
	        }
	        if (stmt != null) {
	            stmt.close();
	        }
	    }

	    return listaCadastroCliente;
	}
}

