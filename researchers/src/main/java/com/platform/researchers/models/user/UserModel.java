package com.platform.researchers.models.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="users")
public class UserModel {

   @Id
   private String _id;
   private String name;
   private String identification;
   private String password;
   private String career;
   private String cellPhoneNumber;
   private String dateAdmission;
   private String email;
   private int hoursWorked;
   private ArrayList<String> projects;
   private ArrayList<Roles> roles;

}
