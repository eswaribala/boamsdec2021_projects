package com.eric.jwtsecurity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eric.jwtsecurity.models.User;

public interface UserRepository extends JpaRepository<User,String>{

}
