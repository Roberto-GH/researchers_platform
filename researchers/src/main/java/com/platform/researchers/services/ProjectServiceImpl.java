package com.platform.researchers.services;

import com.platform.researchers.models.project.ProjectModel;
import com.platform.researchers.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService{

   @Autowired
   private ProjectRepository projectRepository;


   @Override
   public List<ProjectModel> findAll() {
      return projectRepository.findAll();
   }

   @Override
   public Optional<ProjectModel> findById(String _id) {
      return projectRepository.findById(_id);
   }
}
