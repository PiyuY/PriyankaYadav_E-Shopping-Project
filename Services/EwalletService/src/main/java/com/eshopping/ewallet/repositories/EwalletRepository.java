package com.eshopping.ewallet.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eshopping.ewallet.models.Ewallet;

public interface EwalletRepository extends MongoRepository<Ewallet, String>{

}
