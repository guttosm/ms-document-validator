package com.innovation.validator.core.repository;

import com.innovation.validator.core.model.mongo.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, UUID> {

    Customer findCPFById(UUID id);

    Customer findCPFByNumber(String numeroCPF);

}