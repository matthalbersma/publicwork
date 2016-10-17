package com.mongorest.Models;

/**
 * Created by walter on 10/7/16.
 */

import org.springframework.data.mongodb.repository.MongoRepository;
public interface MessageUserRepo extends MongoRepository<MessageUser, String> {
    MessageUser findByHandle(String handle);
    MessageUser findByEmail(String email);

}
