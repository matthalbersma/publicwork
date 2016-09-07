/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matthalbersma;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author walter
 */

@RepositoryRestResource(collectionResourceRel = "items", path = "items")

public interface ItemRepository extends MongoRepository<Item, Integer> {

 

}

    

