package com.platform.researchers.repositories;

import com.platform.researchers.models.project.ProjectModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends MongoRepository<ProjectModel, String> {



}
