package com.platform.researchers.dtos.userdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthDto implements Serializable {

   private String name;
   private String password;
   private String email;

}
