package org.salao.beleza.backand.dia;



import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.salao.beleza.backand.disponibilidade.DisponibilidadeEntity;
import org.salao.beleza.backand.z.utils.BaseEntity;



@Entity
@Table(name = "tb_dia")
@AttributeOverride(name = "id", column = @Column (name= "id_dia"))
public class Dia extends BaseEntity<Long> {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "dia", length = 45, nullable = false)
	private String dia;
	
	
	@ManyToOne
	@JoinColumn(name = "id_disponibilidade")
	private DisponibilidadeEntity disponibilidade;


	public Dia() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Dia(String dia, DisponibilidadeEntity disponibilidade) {
		super();
		this.dia = dia;
		this.disponibilidade = disponibilidade;
	}


	public String getDia() {
		return dia;
	}


	public void setDia(String dia) {
		this.dia = dia;
	}


	public DisponibilidadeEntity getDisponibilidade() {
		return disponibilidade;
	}


	public void setDisponibilidade(DisponibilidadeEntity disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	
	
	
	
	
	

}


