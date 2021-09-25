package com.resplatf.users.repositories;

import com.resplatf.users.models.UsersModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<UsersModel,Long> {


}
