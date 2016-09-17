package com.matthalbersma;

import com.matthalbersma.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;



/**
 * Created by walter on 9/16/16.
 */
public interface UserRepository extends MongoRepository<Client, String> {
    public Client findByUsername(String username);
}
