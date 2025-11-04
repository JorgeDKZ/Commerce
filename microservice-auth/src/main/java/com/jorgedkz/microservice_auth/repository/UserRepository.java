package com.jorgedkz.microservice_auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jorgedkz.microservice_auth.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
