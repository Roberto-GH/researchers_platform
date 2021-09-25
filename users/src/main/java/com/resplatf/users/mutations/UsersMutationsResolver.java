package com.resplatf.users.mutations;

import com.resplatf.users.models.user.UserModel;
import com.resplatf.users.repositories.UsersRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsersMutationsResolver implements GraphQLMutationResolver {

   @Autowired
   private UsersRepository usersRepository;

   public UserModel createUsers(UserModel usersModel){
      return usersRepository.save(usersModel);
   }

}
