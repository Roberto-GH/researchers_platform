package com.resplatf.projects.mutations;

import com.resplatf.projects.models.project.ProjectModel;
import com.resplatf.projects.repositories.ProjectsRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectsMutationsResolver implements GraphQLMutationResolver {

   @Autowired
   private ProjectsRepository projectsRepository;

   public ProjectModel createProject(ProjectModel projectModel){
      return projectsRepository.save(projectModel);
   }

}
