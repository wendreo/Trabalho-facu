package org.salao.beleza.backand.userpermission;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.salao.beleza.backand.z.utils.BaseEntity;

@Entity
@Table(name = "tb_user_permission")
public class UserPermissionEntity extends BaseEntity<UserPermissionKey> {

	private static final long serialVersionUID = 201602010251L;

}