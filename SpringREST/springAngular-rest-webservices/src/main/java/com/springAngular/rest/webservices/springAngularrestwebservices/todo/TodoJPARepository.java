package com.springAngular.rest.webservices.springAngularrestwebservices.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface TodoJPARepository extends JpaRepository<Todo, Long> {

	List<Todo> findByUsername(String username);
}
