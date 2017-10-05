package org.salao.beleza.backand.test.repositories;

import java.util.List;

import org.apache.log4j.Logger;
import org.salao.beleza.backand.test.utils.AbstractTest;
import org.junit.Test;
import org.salao.beleza.backand.user.UserEntity;
import org.salao.beleza.backand.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryTest extends AbstractTest {

	private static final Logger LOGGER = Logger.getLogger(UserRepositoryTest.class);

	@Autowired
	private UserRepository userRepository;

	@Test
	public void findAllTest() {
		List<UserEntity> users = this.userRepository.findAll();

		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("Test FindAll(): " + users);
		}
	}
	
	@Test
	public void findEmailPassword() {
		UserEntity users = this.userRepository.findByEmailAndPassword("admin@admin.com","1234");

		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("Test FindAll(): " + users);
		}
	}


	@Test
	public void find() {
		List<UserEntity> users = this.userRepository.findByEmailOrName("", "");

		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("Test FindAll(): " + users);
		}
	}
	
	
	

}
