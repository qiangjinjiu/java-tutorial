package org.cloudera.spring.datajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.cloudera.spring.datajpa.model.Tutorial;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
	List<Tutorial> findByPublished(boolean published);

	//TODO 当jhql模糊查询，第二次调用查询失败
	//解决办法，用NativeQuery
	@Query(value = "select * from tutorials where title like %?1%",nativeQuery = true)
	List<Tutorial> findByTitleContaining(String title);

	List<Tutorial> findByTitle(String title);

	@Modifying
	@Query(value = "delete from tutorials a where a.title = :title",nativeQuery = true)
	void deleteByTitle(String title);
}
