package org.salao.beleza.backand.funcionario;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.salao.beleza.backand.agendamento.Agendamento;
import org.salao.beleza.backand.z.utils.BaseEntity;

@Entity
@Table(name = "tb_funcionario")
@AttributeOverride(name = "id", column = @Column(name = "id_funcionario") )
public class Funcionario extends BaseEntity<Long> {

	
	private static final long serialVersionUID = 201505091506L;
	
	
	
	
	@Column(name = "nome_funcionario", length = 120, nullable = false)
	private String funcionario;
	
	@Column(name = "email_funcionario", length = 255, nullable = false, unique = true)
	private String email;
	
	@Column(name = "fone_funcionario", length = 120, nullable = false)
	private String fone;
	
	@Column(name = "cpf_funcionario", length = 255, nullable = false, unique = true)
	private String cpf;
	
	@Column(name = "rg_funcionario", length = 255, nullable = false, unique = true)
	private String rg;
	
	@Column(name = "empresa_funcionario", length = 120, nullable = false)
	private String 	empresa;
	
	@Column(name = "funcao_funcionario", length = 120, nullable = false)
	private String funcao;

	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "ap")
	private List<Agendamento> agendamento;
	

	public Funcionario() {

	}



	public Funcionario(String funcionario, String email, String fone, String cpf, String rg, String empresa,
			String funcao) {
		super();
		this.funcionario = funcionario;
		this.email = email;
		this.fone = fone;
		this.cpf = cpf;
		this.rg = rg;
		this.empresa = empresa;
		this.funcao = funcao;
		
	}



	public String getFuncionario() {
		return funcionario;
	}



	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getFone() {
		return fone;
	}



	public void setFone(String fone) {
		this.fone = fone;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public String getRg() {
		return rg;
	}



	public void setRg(String rg) {
		this.rg = rg;
	}



	public String getEmpresa() {
		return empresa;
	}



	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}



	public String getFuncao() {
		return funcao;
	}



	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}



}
