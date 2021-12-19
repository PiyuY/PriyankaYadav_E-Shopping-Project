package com.eshopping.ewallet.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eshopping.ewallet.models.Statement;

public interface StatementRepository extends MongoRepository<Statement, String>{

}
