package com.resplatf.users.mutations;

import com.resplatf.users.models.user.UserModel;
import com.resplatf.users.repositories.UsersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
class UsersMutationsResolverTest {

   @Mock
   private UsersRepository usersRepository;

   @InjectMocks
   private UsersMutationsResolver usersMutationsResolver;

   private UserModel userModel;

   @BeforeEach
   void setUp() {
      MockitoAnnotations.openMocks(this);

      userModel = new UserModel();
      userModel.setName("Roberto");
   }

   @Test
   void createUsers() {
      when(usersRepository.save(userModel)).thenReturn(userModel);
      assertNotNull(usersMutationsResolver.createUsers(userModel));
      assertEquals(usersMutationsResolver.createUsers(userModel), userModel);
   }
}