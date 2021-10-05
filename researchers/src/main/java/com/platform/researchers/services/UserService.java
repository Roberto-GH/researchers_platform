package com.platform.researchers.services;

import com.platform.researchers.dtos.userdto.UserAuthDto;
import com.platform.researchers.dtos.userdto.UserAuthResponseDto;
import com.platform.researchers.dtos.userdto.UserDto;
import com.platform.researchers.dtos.userdto.UserNoPassDto;

import java.util.List;

public interface UserService {

   public List<UserNoPassDto> findAll();

   public UserNoPassDto findById(String _id);

   public UserAuthResponseDto verifyAuth(UserAuthDto userAuthDto);

   public UserNoPassDto createUser(UserDto userDto);

}
