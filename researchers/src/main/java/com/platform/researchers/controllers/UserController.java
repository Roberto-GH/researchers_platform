package com.platform.researchers.controllers;

import com.platform.researchers.dtos.userdto.UserAuthDto;
import com.platform.researchers.dtos.userdto.UserAuthResponseDto;
import com.platform.researchers.dtos.userdto.UserDto;
import com.platform.researchers.dtos.userdto.UserNoPassDto;
import com.platform.researchers.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping(UserController.API)
public class UserController {


   public static  final String API = "/api";
   public static  final String USERS = "/users";
   public static  final String AUTH = "/auth";
   public static  final String ID_ID = "/{_id}";


   @Autowired
   private UserService userService;


   @GetMapping(USERS)
   public List<UserNoPassDto> findAll(){
      List<UserNoPassDto> userDtos = userService.findAll();
      return userDtos;
   }


   @GetMapping(USERS+ID_ID)
   public UserNoPassDto findById(@PathVariable String _id) {
      UserNoPassDto userDto = userService.findById(_id);
      return userDto;
   }


   @PostMapping(USERS)
   public UserNoPassDto createUser(@RequestBody UserDto userDto){
      UserNoPassDto userNoPassDto = userService.createUser(userDto);
      return userNoPassDto;
   }

   @PostMapping(USERS+AUTH)
   public ResponseEntity<?> varifyAuth(@RequestBody UserAuthDto userAuthDto){
      UserAuthResponseDto userAuthResponseDto = userService.verifyAuth(userAuthDto);

      if (userAuthResponseDto == null){
         Map<String, String> jsonResponse = new HashMap<>();
         jsonResponse.put("error", "Usuario o contraseña incorrecto");
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonResponse);
      }
      return ResponseEntity.ok(userAuthResponseDto);
   }

}
