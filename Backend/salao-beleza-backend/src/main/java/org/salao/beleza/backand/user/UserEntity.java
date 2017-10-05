package org.salao.beleza.backand.user;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.salao.beleza.backand.agendamento.Agendamento;
import org.salao.beleza.backand.permission.PermissionEntity;
import org.salao.beleza.backand.z.utils.BaseEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "tb_user")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class UserEntity extends BaseEntity<Long> {

	private static final long serialVersionUID = 201602010251L;

	@Column(name = "name", length = 120, nullable = false)
	private String name;

	@Column(name = "email", length = 255, nullable = false, unique = true)
	private String email;
	
	@Column(name = "telefone", length = 255, nullable = false, unique = true)
	private String telefone;

	@Column(name = "password", length = 128, nullable = false)
	private String password;

	

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_user_permission", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "permission_id"))
	private List<PermissionEntity> permissions;
	
	
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "idUser")
	private List<Agendamento> agendamendoId;

	public UserEntity() {
	}

	public UserEntity(String name, String email,String telefone, String password) {
		super();
		this.name = name;
		this.email = email;
		this.telefone = telefone;
		this.password = password;
		

	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@JsonIgnore
	public String getPassword() {
		return this.password;
	}

	@JsonProperty("password")
	public void setPassword(String password) {
		this.password = password;
	}

	public List<PermissionEntity> getPermissions() {
		return this.permissions;
	}

	public void setPermissions(List<PermissionEntity> permissions) {
		this.permissions = permissions;
	}

	

	
}
