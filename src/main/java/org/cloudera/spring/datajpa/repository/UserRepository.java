package org.cloudera.spring.datajpa.repository;

import org.cloudera.spring.datajpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByName(String name);

	/**
	 * 根据email做模糊查询
	 * @param email
	 * @return
	 */
	List<User> findByEmailContaining(String email);
}
