package com.platform.researchers.modelmappers;

import com.platform.researchers.dtos.userdto.UserAuthResponseDto;
import com.platform.researchers.dtos.userdto.UserRequestDto;
import com.platform.researchers.dtos.userdto.UserResponseDto;
import com.platform.researchers.models.user.UserModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserModelMapper {

   @Autowired
   private ModelMapper modelMapper;


   public UserAuthResponseDto userAuthResponseDtoMapper(UserModel userModel){
      UserAuthResponseDto userAuthResponseDto = modelMapper.map(userModel, UserAuthResponseDto.class);
      return userAuthResponseDto;
   }


   public UserModel userModelMapper(UserRequestDto userRequestDto){
      UserModel userModel = modelMapper.map(userRequestDto, UserModel.class);
      return userModel;
   }


   public UserResponseDto userResponseDtoMapper(UserModel userModel){
      UserResponseDto userDto = modelMapper.map(userModel, UserResponseDto.class);
      return userDto;
   }


   public List<UserResponseDto> userResponseDtoListMapper(List<UserModel> userModels){
      List<UserResponseDto> userListDto = modelMapper.map(userModels, new TypeToken<List<UserResponseDto>>() {}.getType());
      return userListDto;
   }

   public UserAuthResponseDto userDtoToAuthResponseDtoMapper(UserResponseDto userResponseDto){
      UserAuthResponseDto userAuthResponseDto = modelMapper.map(userResponseDto, UserAuthResponseDto.class);
      return userAuthResponseDto;
   }

}
