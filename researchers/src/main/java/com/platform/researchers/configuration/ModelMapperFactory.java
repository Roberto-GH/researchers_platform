package com.platform.researchers.configuration;

import com.platform.researchers.modelmappers.UserModelMapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperFactory {

   @Bean
   public ModelMapper modelMapper(){
      return new ModelMapper();
   }

   @Bean
   public UserModelMapper userModelMapper(){
      return new UserModelMapper();
   }

}
