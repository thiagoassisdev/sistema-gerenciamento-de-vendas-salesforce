package br.com.fiap.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EmpresaCliente {

	private String nome;
	private int numeroFuncionarios;
	private double rendaMensal;
	private String setorAtuacao;

	// construtor vazio
	public EmpresaCliente() {
		super();
	}

	// construtor cheio
	public EmpresaCliente(String nome, int numeroFuncionarios, double rendaMensal, String setorAtuacao) {
		super();
		this.nome = nome;
		this.numeroFuncionarios = numeroFuncionarios;
		this.rendaMensal = rendaMensal;
		this.setorAtuacao = setorAtuacao;
	}

	// getters and setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumeroFuncionarios() {
		return numeroFuncionarios;
	}

	public void setNumeroFuncionarios(int numeroFuncionarios) {
		this.numeroFuncionarios = numeroFuncionarios;
	}

	public double getRendaMensal() {
		return rendaMensal;
	}

	public void setRendaMensal(double rendaMensal) {
		this.rendaMensal = rendaMensal;
	}

	public String getSetorAtuacao() {
		return setorAtuacao;
	}

	public void setSetorAtuacao(String setorAtuacao) {
		this.setorAtuacao = setorAtuacao;
	}

	// to string
	@Override
	public String toString() {
		return "EmpresaCliente [nome=" + nome + ", numeroFuncionarios=" + numeroFuncionarios + ", rendaMensal="
				+ rendaMensal + ", setorAtuacao=" + setorAtuacao + ", getNome()=" + getNome()
				+ ", getNumeroFuncionarios()=" + getNumeroFuncionarios() + ", getRendaMensal()=" + getRendaMensal()
				+ ", getSetorAtuacao()=" + getSetorAtuacao() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
