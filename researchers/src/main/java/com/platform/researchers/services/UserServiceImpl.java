package com.platform.researchers.services;

import com.platform.researchers.dtos.userdto.UserAuthRequestDto;
import com.platform.researchers.dtos.userdto.UserRequestDto;
import com.platform.researchers.dtos.userdto.UserResponseDto;
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
   public List<UserResponseDto> findAll() {
      List<UserModel> userModels = userRepository.findAll();
      List<UserResponseDto> userDtos = userModelMapper.userResponseDtoListMapper(userModels);
      return userDtos;
   }


   @Override
   public UserResponseDto findById(String _id) {
      Optional<UserModel> userModelOptional = userRepository.findById(_id);
      UserModel userModel = userModelOptional.get();
      UserResponseDto userResponseDto = userModelMapper.userResponseDtoMapper(userModel);
      return userResponseDto;
   }


   @Override
   public UserResponseDto verifyAuth(UserAuthRequestDto userAuthRequestDtoToCheck) {
      UserModel userModel = userRepository.findByEmail(userAuthRequestDtoToCheck.getEmail());

      if (userModel != null) {
         Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
         char[] charArrayPassword = userAuthRequestDtoToCheck.getPassword().toCharArray();

         if (argon2.verify(userModel.getPassword(), charArrayPassword)) {
            return userModelMapper.userResponseDtoMapper(userModel);
         }
      }
      return null;
   }


   @Override
   public UserResponseDto createUser(UserRequestDto userRequestDto) {
      Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
      char[] charArrayPassword = userRequestDto.getPassword().toCharArray();
      String passwordHash = argon2.hash(1, 1024, 1, charArrayPassword);

      UserModel userModelToCreate = userModelMapper.userModelMapper(userRequestDto);
      userModelToCreate.setPassword(passwordHash);

      UserModel userModel = userRepository.save(userModelToCreate);
      UserResponseDto userResponseDto = userModelMapper.userResponseDtoMapper(userModel);
      return userResponseDto;
   }

}
