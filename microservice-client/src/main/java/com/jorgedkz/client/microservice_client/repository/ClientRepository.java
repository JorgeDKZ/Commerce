package com.jorgedkz.client.microservice_client.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jorgedkz.client.microservice_client.entity.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

    @Query("Select c From Client c where c.name = :name")
    public Client findByName(String name);
    
}
