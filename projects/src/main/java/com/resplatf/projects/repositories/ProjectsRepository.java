package com.resplatf.projects.repositories;

import com.resplatf.projects.models.project.ProjectModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectsRepository extends MongoRepository<ProjectModel, ObjectId> {


}
