package com.resplatf.users.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersModel {

   private Long _id;
   private String name;
   private String identification;
   private String password;
   private String career;
   private String cellPhoneNumber;
   private String dateAdmission;
   private String email;
   private int hoursWorked;
   private ArrayList<Long> projects;
   private ArrayList<Roles> roles;

}
