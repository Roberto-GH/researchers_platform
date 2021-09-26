package com.resplatf.users.queries;

import com.resplatf.users.models.user.UserModel;
import com.resplatf.users.repositories.UsersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
class UsersQueryResolverTest {

   @Mock
   private UsersRepository usersRepository;

   @InjectMocks
   private UsersQueryResolver usersQueryResolver;

   private UserModel userModel;

   @BeforeEach
   void setUp() {
      MockitoAnnotations.openMocks(this);

      userModel = new UserModel();
      userModel.setName("Roberto");
   }

   @Test
   void users() {
      when(usersRepository.findAll()).thenReturn(Arrays.asList(userModel));
      assertNotNull(usersQueryResolver.users());
      assertEquals(usersQueryResolver.users(), Arrays.asList(userModel));
   }
}