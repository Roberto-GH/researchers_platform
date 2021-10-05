package com.platform.researchers.services;

import com.platform.researchers.models.project.ProjectModel;

import java.util.List;
import java.util.Optional;

public interface ProjectService {

   public List<ProjectModel> findAll();

   public Optional<ProjectModel> findById(String _id);

}
