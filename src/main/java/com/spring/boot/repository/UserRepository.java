package com.spring.boot.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.model.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByUserName(String username);
	
	
}