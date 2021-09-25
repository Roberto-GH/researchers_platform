package com.resplatf.projects.models.project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Progress {

   private String stage;
   private String notes;
   private LocalDateTime stageStartDate;

}
