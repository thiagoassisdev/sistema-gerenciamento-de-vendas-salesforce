package br.com.fiap.main;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.beans.CadastroCliente;
import br.com.fiap.dao.CadastroClienteDAO;

public class TesteSelecionarCadastroCliente {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Instanciar objetos
        CadastroClienteDAO dao = new CadastroClienteDAO();

        List<CadastroCliente> listaCadastroCliente = dao.selecionar();

        if (listaCadastroCliente != null && !listaCadastroCliente.isEmpty()) {
            // foreach
            for (CadastroCliente cadastroCliente : listaCadastroCliente) {
                System.out.println(cadastroCliente.getIdEmpresa() + " " + cadastroCliente.getNome() + " "
                        + cadastroCliente.getCpf() + " " + cadastroCliente.getTelefone() + " "
                        + cadastroCliente.getEmail() + " " + cadastroCliente.getSenha());
            }
        } else {
            System.out.println("Nenhum cadastro de cliente encontrado.");
        }
    }
}