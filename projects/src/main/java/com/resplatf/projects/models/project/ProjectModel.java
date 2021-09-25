package com.resplatf.projects.models.project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="projects")
public class ProjectModel {

   private ObjectId _id;
   private String name;
   private String description;
   private String generalObjectives;
   private ArrayList<String> specificObjectives;
   private Long totalBudget;
   private LocalDateTime initialDate;
   private LocalDateTime finalDate;
   private String currentStage;
   private ArrayList<Progress> progress;
   private Type type;
   private Status status;
   private ArrayList<Users> users;
}

