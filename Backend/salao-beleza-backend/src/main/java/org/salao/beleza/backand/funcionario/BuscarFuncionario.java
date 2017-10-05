package org.salao.beleza.backand.funcionario;

import org.salao.beleza.backand.z.utils.BaseBean;

public class BuscarFuncionario extends BaseBean{
	
	
	
	private static final long serialVersionUID = 1L;
	String funcionario;
	public BuscarFuncionario() {
		super();
		
	}
	
	
	public BuscarFuncionario(String funcionario) {
		super();
		this.funcionario = funcionario;
	}


	public String getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}
	
	
	
	
	

}
