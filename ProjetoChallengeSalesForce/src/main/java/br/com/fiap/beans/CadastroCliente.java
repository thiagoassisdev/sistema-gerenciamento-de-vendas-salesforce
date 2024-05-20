package br.com.fiap.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CadastroCliente {

	private int idEmpresa;
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	private String senha;

	// construtor vazio
	public CadastroCliente() {
		super();
	}

	// construtor cheio
	public CadastroCliente(int idEmpresa, String nome, String cpf, String telefone, String email, String senha) {
		super();
		this.idEmpresa = idEmpresa;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
	}

	// getters e setters
	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	// to string
	@Override
	public String toString() {
		return "CadastroCliente [idEmpresa=" + idEmpresa + ", nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone
				+ ", email=" + email + ", senha=" + senha + ", getIdEmpresa()=" + getIdEmpresa() + ", getNome()="
				+ getNome() + ", getCpf()=" + getCpf() + ", getTelefone()=" + getTelefone() + ", getEmail()="
				+ getEmail() + ", getSenha()=" + getSenha() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
