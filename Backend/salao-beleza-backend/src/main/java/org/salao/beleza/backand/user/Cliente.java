package org.salao.beleza.backand.user;



import org.salao.beleza.backand.permission.PermissionEntity;
import org.salao.beleza.backand.permission.PermissionRepository;
import org.salao.beleza.backand.userpermission.UserPermissionEntity;
import org.salao.beleza.backand.userpermission.UserPermissionKey;
import org.salao.beleza.backand.userpermission.UserPermissionRepository;
import org.salao.beleza.backand.z.utils.GenericService;
import org.salao.beleza.backand.z.utils.ServicePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = ServicePath.CLIENTES_PATH)
public class Cliente extends GenericService<UserEntity, Long> {

	

	@Autowired
	private UserRepository userRepository;

	@Autowired
	PermissionRepository permissaoRepository;

	@Autowired
	UserPermissionRepository userPermission;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserEntity insert(@RequestBody UserEntity user) {

		user.setPassword(this.passwordEncoder.encode(user.getPassword()));

		this.userRepository.saveAndFlush(user);

		PermissionEntity permissao = this.permissaoRepository.findByRole("ROLE_CLIENTE");

		if (permissao == null) {
			PermissionEntity permissao2 = new PermissionEntity();
			permissao2.setRole("ROLE_CLIENTE");

			permissao = this.permissaoRepository.save(permissao2);
		}
		
		UserPermissionKey userPermissionKey = new UserPermissionKey();
		userPermissionKey.setPermissionId(permissao.getId());
		userPermissionKey.setUserId(user.getId());

		UserPermissionEntity userPermission = new UserPermissionEntity();
		userPermission.setId(userPermissionKey);

		this.userPermission.save(userPermission);

		return this.userRepository.saveAndFlush(user);

	}

}
