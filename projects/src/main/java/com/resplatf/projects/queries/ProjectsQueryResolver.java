package com.resplatf.projects.queries;

import com.resplatf.projects.models.project.ProjectModel;
import com.resplatf.projects.repositories.ProjectsRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjectsQueryResolver implements GraphQLQueryResolver {

   @Autowired
   private ProjectsRepository projectsRepository;

   public List<ProjectModel> projects(){
      return projectsRepository.findAll();
   }

}
