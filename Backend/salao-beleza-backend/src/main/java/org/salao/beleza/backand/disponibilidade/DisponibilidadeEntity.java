package org.salao.beleza.backand.disponibilidade;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import org.salao.beleza.backand.z.utils.BaseEntity;

@Entity
@Table(name = "tb_disponibilidade")
@AttributeOverride(name = "id", column = @Column(name = "id_disponibilidade") )
public class DisponibilidadeEntity extends BaseEntity<Long> {
	private static final long serialVersionUID = 1L;

	@Column(name = "horario_inicio", length = 255, nullable = false)
	private Date horarioInicio;

	@Column(name = "horario_final", length = 11, nullable = false)
	private Integer horarioFinal;
	
	@ManyToOne
	@JoinColumn(name = "id_funcionario")
	private DisponibilidadeEntity disponibilidade;

	public DisponibilidadeEntity() {

	}

	public Date getHorario_inicio() {
		return horarioInicio;
	}

	public void setHorario_inicio(Date horario_inicio) {
		this.horarioInicio = horario_inicio;
	}

	public Integer getHorario_final() {
		return horarioFinal;
	}

	public void setHorario_final(Integer horario_final) {
		this.horarioFinal = horario_final;
	}

}
