package com.platform.researchers.repositories;

import com.platform.researchers.models.user.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserModel, String> {

   UserModel findByEmail(String email);

}
