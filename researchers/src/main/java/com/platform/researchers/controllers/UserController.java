package com.platform.researchers.controllers;

import com.platform.researchers.dtos.userdto.UserAuthRequestDto;
import com.platform.researchers.dtos.userdto.UserAuthResponseDto;
import com.platform.researchers.dtos.userdto.UserRequestDto;
import com.platform.researchers.dtos.userdto.UserResponseDto;
import com.platform.researchers.modelmappers.UserModelMapper;
import com.platform.researchers.services.UserService;
import com.platform.researchers.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api")
public class UserController {


   public static  final String API = "/api";
   public static  final String USERS = "/users";
   public static  final String AUTH = "/auth";
   public static  final String ID_ID = "/{_id}";


   @Autowired
   private UserService userService;

   @Autowired
   private UserModelMapper userModelMapper;

   @Autowired
   private JWTUtil jwtUtil;


   @GetMapping("/users")
   public List<UserResponseDto> findAll(){
      List<UserResponseDto> userResponseDtos = userService.findAll();
      return userResponseDtos;
   }


   @GetMapping(USERS+ID_ID)
   public UserResponseDto findById(@PathVariable String _id) {
      UserResponseDto userResponseDto = userService.findById(_id);
      return userResponseDto;
   }


   @PostMapping(USERS)
   public UserResponseDto createUser(@RequestBody UserRequestDto userDto){
      UserResponseDto userResponseDto = userService.createUser(userDto);
      return userResponseDto;
   }

   @PostMapping(USERS+AUTH)
   public ResponseEntity<?> verifyAuth(@RequestBody UserAuthRequestDto userAuthDto){
      UserResponseDto userResponseDto = userService.verifyAuth(userAuthDto);

      if (Objects.isNull(userResponseDto)){
         Map<String, String> jsonResponse = new HashMap<>();
         jsonResponse.put("error", "Usuario o contraseña incorrecto");
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonResponse);
      }

      String tokenJwt = jwtUtil.create(userResponseDto.get_id(),userResponseDto.getEmail());
      UserAuthResponseDto userAuthResponseDto = userModelMapper.userDtoToAuthResponseDtoMapper(userResponseDto);

      return ResponseEntity.status(HttpStatus.OK).header("Authorization", "Bearer "+tokenJwt).body(userAuthResponseDto);
   }

}
