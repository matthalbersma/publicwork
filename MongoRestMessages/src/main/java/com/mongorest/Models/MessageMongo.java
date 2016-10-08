package com.mongorest.Models;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by walter on 10/7/16.
 */
@RepositoryRestResource(collectionResourceRel = "messages", path="messages")
public interface MessageMongo extends MongoRepository<Message, String>{

}
