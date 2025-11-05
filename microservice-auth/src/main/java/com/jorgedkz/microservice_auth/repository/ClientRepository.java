package com.jorgedkz.microservice_auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jorgedkz.microservice_auth.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("Select c From Client c where c.userName = :userName")
    public Client findByName(String userName);

}
