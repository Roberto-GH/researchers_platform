package com.platform.researchers.modelmappers;

import com.platform.researchers.dtos.userdto.UserAuthResponseDto;
import com.platform.researchers.dtos.userdto.UserDto;
import com.platform.researchers.dtos.userdto.UserNoPassDto;
import com.platform.researchers.models.user.UserModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserModelMapper {

   @Autowired
   private ModelMapper modelMapper;


   public UserAuthResponseDto UserAuthResponseDtoMapper(UserModel userModel){
      UserAuthResponseDto userAuthResponseDto = modelMapper.map(userModel, UserAuthResponseDto.class);
      return userAuthResponseDto;
   }


   public UserModel userModelMapper(UserDto userDto){
      UserModel userModel = modelMapper.map(userDto, UserModel.class);
      return userModel;
   }


   public UserNoPassDto userNoPassMapper(UserModel userModel){
      UserNoPassDto userDto = modelMapper.map(userModel, UserNoPassDto.class);
      return userDto;
   }


   public List<UserNoPassDto> UserListDtoMapper(List<UserModel> userModels){
      List<UserNoPassDto> userListDto = modelMapper.map(userModels, new TypeToken<List<UserNoPassDto>>() {}.getType());
      return userListDto;
   }

}
