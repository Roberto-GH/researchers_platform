package com.resplatf.users.queries;

import com.resplatf.users.models.user.UserModel;
import com.resplatf.users.repositories.UsersRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsersQueryResolver implements GraphQLQueryResolver {

   @Autowired
   private UsersRepository usersRepository;


   public List<UserModel> users(){
      return usersRepository.findAll();
   }

}
