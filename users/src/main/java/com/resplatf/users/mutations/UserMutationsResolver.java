package com.resplatf.users.mutations;

import com.resplatf.users.models.UsersModel;
import com.resplatf.users.repositories.UsersRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMutationsResolver implements GraphQLMutationResolver {

   @Autowired
   private UsersRepository usersRepository;

   public UsersModel createUsers(UsersModel usersModel){
      return usersRepository.save(usersModel);
   }

}
