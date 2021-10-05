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
public class UserNoPassDto implements Serializable {

   private String _id;
   private String name;
   private String identification;
   private String career;
   private String cellPhoneNumber;
   private String dateAdmission;
   private String email;
   private int hoursWorked;
   private ArrayList<String> projects;
   private ArrayList<Roles> roles;

}
