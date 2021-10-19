package com.platform.researchers.services;

import com.platform.researchers.dtos.userdto.UserAuthRequestDto;
import com.platform.researchers.dtos.userdto.UserRequestDto;
import com.platform.researchers.dtos.userdto.UserResponseDto;

import java.util.List;

public interface UserService {

   public List<UserResponseDto> findAll();

   public UserResponseDto findById(String _id);

   public UserResponseDto verifyAuth(UserAuthRequestDto userAuthDto);

   public UserResponseDto createUser(UserRequestDto userDto);

}
