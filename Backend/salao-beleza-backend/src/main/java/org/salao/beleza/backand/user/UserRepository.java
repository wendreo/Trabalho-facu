package org.salao.beleza.backand.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<UserEntity, Long> {

	public UserEntity findByEmailAndPassword(String email,String password);

	public List<UserEntity> findByEmailOrName(String email, String name);
	
	public UserEntity findByEmail(String email);
	
	public List<UserEntity> findById(Long user);

}
