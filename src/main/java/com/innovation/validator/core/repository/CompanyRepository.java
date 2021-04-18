package com.innovation.validator.core.repository;

import com.innovation.validator.core.model.mongo.Company;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CompanyRepository extends MongoRepository<Company, UUID> {

    Company findCNPJById(UUID id);

    Company findCNPJByNumber(String cnpjNumber);

}