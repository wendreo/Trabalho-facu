package org.salao.beleza.backand.agendamento;

import org.salao.beleza.backand.z.utils.BaseBean;

public class BuscaAgendamento extends BaseBean{

	
	private static final long serialVersionUID = 1L;
	
	String data;

	public BuscaAgendamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BuscaAgendamento(String data) {
		super();
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	

}
