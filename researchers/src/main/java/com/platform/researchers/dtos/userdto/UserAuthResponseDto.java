package com.platform.researchers.dtos.userdto;

import com.platform.researchers.models.user.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthResponseDto implements Serializable {

   private String name;
   private String email;
   private ArrayList<Roles> roles;

}
