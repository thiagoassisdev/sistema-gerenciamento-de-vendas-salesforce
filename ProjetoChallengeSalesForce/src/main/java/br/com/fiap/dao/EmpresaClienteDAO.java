
package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
	
import br.com.fiap.beans.EmpresaCliente;
import br.com.fiap.conexoes.ConexaoFactory;

public class EmpresaClienteDAO {

	public Connection minhaConexao;

	public EmpresaClienteDAO() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConexaoFactory().conexao();
	}

	// buscar nome
	public EmpresaCliente buscarPorNome(String nome) throws SQLException {
		EmpresaCliente empresa = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = minhaConexao.prepareStatement("SELECT * FROM EMPRESA_CLIENTE WHERE NOME = ?");
			stmt.setString(1, nome);
			rs = stmt.executeQuery();

			if (rs.next()) {
				empresa = new EmpresaCliente();
				empresa.setNome(rs.getString("NOME"));
				empresa.setNumeroFuncionarios(rs.getInt("NUMERO_FUNCIONARIOS"));
				empresa.setRendaMensal(rs.getDouble("RENDA_MENSAL"));
				empresa.setSetorAtuacao(rs.getString("SETOR_ATUACAO"));

			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}

		return empresa;
	}

	// Iserir
	public String inserir(EmpresaCliente empresaCliente) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement(
				"INSERT INTO EMPRESA_CLIENTE (NOME, NUMERO_FUNCIONARIOS, RENDA_MENSAL, SETOR_ATUACAO) VALUES (?, ?, ?, ?)");
		stmt.setString(1, empresaCliente.getNome());
		stmt.setInt(2, empresaCliente.getNumeroFuncionarios());
		stmt.setDouble(3, empresaCliente.getRendaMensal());
		stmt.setString(4, empresaCliente.getSetorAtuacao());

		stmt.execute();
		stmt.close();
		return "Cadastrado com Sucesso!";
	}

	// Atualizar
	public String atualizar(EmpresaCliente empresaCliente) throws SQLException {
		String nome = empresaCliente.getNome();
		EmpresaCliente empresaCliente1 = buscarPorNome(nome);

		if (empresaCliente1 != null) {
			PreparedStatement stmt = null;

			try {
				stmt = minhaConexao.prepareStatement(
						"UPDATE EMPRESA_CLIENTE SET NUMERO_FUNCIONARIOS = ?, RENDA_MENSAL = ?, SETOR_ATUACAO = ? WHERE NOME = ?");
				stmt.setInt(1, empresaCliente.getNumeroFuncionarios());
				stmt.setDouble(2, empresaCliente.getRendaMensal());
				stmt.setString(3, empresaCliente.getSetorAtuacao());
				stmt.setString(4, nome);

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
			return "Empresa não encontrada.";
		}
	}

	// Delete
	public String deletar(String nome) throws SQLException {
		EmpresaCliente empresaCliente = buscarPorNome(nome);

		if (empresaCliente != null) {
			PreparedStatement stmt = null;

			try {
				stmt = minhaConexao.prepareStatement("DELETE FROM EMPRESA_CLIENTE WHERE NOME = ?");
				stmt.setString(1, nome);
				int linhasAfetadas = stmt.executeUpdate();

				if (linhasAfetadas > 0) {
					return "Empresa deletado com sucesso!";
				} else {
					return "Não foi possível deletar a empresa. Verifique se o nome está correto.";
				}
			} finally {
				if (stmt != null) {
					stmt.close();
				}
			}
		} else {
			return "Empresa não encontrada.";
		}
	}

	// Selecionar

	public List<EmpresaCliente> selecionar() throws SQLException {
	    List<EmpresaCliente> listaEmpresaCliente = new ArrayList<EmpresaCliente>();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;

	    try {
	        stmt = minhaConexao.prepareStatement("SELECT * FROM EMPRESA_CLIENTE");
	        rs = stmt.executeQuery();

	        while (rs.next()) {
	            EmpresaCliente empresaCliente = new EmpresaCliente();
	            empresaCliente.setNome(rs.getString("NOME"));
	            empresaCliente.setNumeroFuncionarios(rs.getInt("NUMERO_FUNCIONARIOS"));
	            empresaCliente.setRendaMensal(rs.getDouble("RENDA_MENSAL")); 
	            empresaCliente.setSetorAtuacao(rs.getString("SETOR_ATUACAO"));

	            listaEmpresaCliente.add(empresaCliente); 
	        }
	    } finally {
	        if (rs != null) {
	            rs.close();
	        }
	        if (stmt != null) {
	            stmt.close();
	        }
	    }

	    return listaEmpresaCliente;
	}

}
