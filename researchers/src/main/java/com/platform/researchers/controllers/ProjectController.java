package com.platform.researchers.controllers;

import com.platform.researchers.models.project.ProjectModel;
import com.platform.researchers.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping(ProjectController.API)
public class ProjectController {

   public static  final String API = "/api";
   public static  final String PROJECTS = "/projects";
   public static  final String ID_ID = "/{_id}";

   @Autowired
   private ProjectService projectService;


   @GetMapping(PROJECTS)
   public ResponseEntity<?> findAll(){
      List<ProjectModel> projectModels = projectService.findAll();
      return ResponseEntity.ok(projectModels);
   }

   @GetMapping(PROJECTS+ID_ID)
   public ResponseEntity<?> findById(@PathVariable String _id){
      Optional<ProjectModel> projectModel = projectService.findById(_id);
      if (!projectModel.isPresent()){
         return ResponseEntity.notFound().build();
      }
      return ResponseEntity.ok(projectModel);
   }

}
