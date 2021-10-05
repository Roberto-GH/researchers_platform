package com.platform.researchers.services;

import com.platform.researchers.dtos.userdto.UserAuthDto;
import com.platform.researchers.dtos.userdto.UserAuthResponseDto;
import com.platform.researchers.dtos.userdto.UserDto;
import com.platform.researchers.dtos.userdto.UserNoPassDto;
import com.platform.researchers.modelmappers.UserModelMapper;
import com.platform.researchers.models.user.UserModel;
import com.platform.researchers.repositories.UserRepository;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{


   @Autowired
   private UserRepository userRepository;

   @Autowired
   private UserModelMapper userModelMapper;


   @Override
   public List<UserNoPassDto> findAll() {
      List<UserModel> userModels = userRepository.findAll();
      List<UserNoPassDto> userDtos = userModelMapper.UserListDtoMapper(userModels);
      return userDtos;
   }


   @Override
   public UserNoPassDto findById(String _id) {
      Optional<UserModel> userModelOptional = userRepository.findById(_id);
      UserModel userModel = userModelOptional.get();
      UserNoPassDto userDto = userModelMapper.userNoPassMapper(userModel);
      return userDto;
   }


   @Override
   public UserAuthResponseDto verifyAuth(UserAuthDto userAuthDtoToCheck) {
      UserModel userModel = userRepository.findByEmail(userAuthDtoToCheck.getEmail());
      if (userModel != null) {
         Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
         char[] charArrayPassword = userAuthDtoToCheck.getPassword().toCharArray();

         if (argon2.verify(userModel.getPassword(), charArrayPassword)) {
            return userModelMapper.UserAuthResponseDtoMapper(userModel);
         }
      }
      return null;
   }


   @Override
   public UserNoPassDto createUser(UserDto userDto) {
      Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
      char[] charArrayPassword = userDto.getPassword().toCharArray();
      String passwordHash = argon2.hash(1, 1024, 1, charArrayPassword);

      UserModel userModelToCreate = userModelMapper.userModelMapper(userDto);
      userModelToCreate.setPassword(passwordHash);

      UserModel userModel = userRepository.save(userModelToCreate);
      UserNoPassDto userNoPassDto = userModelMapper.userNoPassMapper(userModel);
      return userNoPassDto;
   }

}
