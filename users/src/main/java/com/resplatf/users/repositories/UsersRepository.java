package com.resplatf.users.repositories;

import com.resplatf.users.models.user.UserModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<UserModel, ObjectId> {


}
