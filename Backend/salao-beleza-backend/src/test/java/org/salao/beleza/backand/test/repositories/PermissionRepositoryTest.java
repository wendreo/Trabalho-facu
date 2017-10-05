package org.salao.beleza.backand.test.repositories;

import java.util.List;

import org.apache.log4j.Logger;
import org.salao.beleza.backand.test.utils.AbstractTest;
import org.junit.Test;
import org.salao.beleza.backand.permission.PermissionEntity;
import org.salao.beleza.backand.permission.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PermissionRepositoryTest extends AbstractTest {

	private static final Logger LOGGER = Logger.getLogger(UserRepositoryTest.class);

	@Autowired
	private PermissionRepository permissionRepository;

	@Test
	public void findAllTest() {
		List<PermissionEntity> permissions = this.permissionRepository.findAll();

		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("Test FindAll(): " + permissions);
		}
	}

}
