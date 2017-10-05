package org.salao.beleza.backand.test.repositories;

import java.util.List;

import org.apache.log4j.Logger;
import org.salao.beleza.backand.test.utils.AbstractTest;
import org.junit.Test;
import org.salao.beleza.backand.userpermission.UserPermissionEntity;
import org.salao.beleza.backand.userpermission.UserPermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserPermissionRepositoryTest extends AbstractTest {

	private static final Logger LOGGER = Logger.getLogger(UserPermissionRepositoryTest.class);

	@Autowired
	private UserPermissionRepository userPermissionRepository;

	@Test
	public void findAllTest() {
		List<UserPermissionEntity> userPermissions = this.userPermissionRepository.findAll();

		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("Test FindAll(): " + userPermissions);
		}
	}

}
