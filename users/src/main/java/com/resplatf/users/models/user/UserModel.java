package com.resplatf.users.models.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="users")
public class UserModel {

   private ObjectId _id;
   private String name;
   private String identification;
   private String password;
   private String career;
   private String cellPhoneNumber;
   private String dateAdmission;
   private String email;
   private int hoursWorked;
   private ArrayList<ObjectId> projects;
   private ArrayList<Roles> roles;

}
