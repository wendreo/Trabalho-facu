package org.salao.beleza.backand.agendamento;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.salao.beleza.backand.funcionario.Funcionario;
import org.salao.beleza.backand.user.UserEntity;
import org.salao.beleza.backand.z.utils.BaseEntity;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="tb_agendamento")
@AttributeOverride(name="id",column = @Column(name="pk_id"))
public class Agendamento extends BaseEntity<Long>{
	
	
	private static final long serialVersionUID = 1L;
	
	
	
	
	@JsonFormat(pattern="HH:mm")
	@Column(name="agenda_horario", length=255 , nullable=false)
	private String horario;
	
	@ManyToOne
	@JoinColumn(name = "id_user")
	private UserEntity idUser;
	
	@ManyToOne
	@JoinColumn(name = "ap_id")
	private Funcionario ap;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat (pattern="yyyy-MM-dd")
	@Column(name = "agenda_data", length = 20, nullable = false)
	private Date data;

	public Agendamento() {
		
	}

	


	public Agendamento(String horario, UserEntity idUser, Funcionario ap, Date data) {
		super();
		
		this.horario = horario;
		this.idUser = idUser;
		this.ap = ap;
		this.data = data;
	}




	




	public String getHorario() {
		return horario;
	}




	public void setHorario(String horario) {
		this.horario = horario;
	}




	public UserEntity getIdUser() {
		return idUser;
	}




	public void setIdUser(UserEntity idUser) {
		this.idUser = idUser;
	}




	public Funcionario getAp() {
		return ap;
	}




	public void setAp(Funcionario ap) {
		this.ap = ap;
	}




	public Date getData() {
		return data;
	}




	public void setData(Date data) {
		this.data = data;
	}


}

	
