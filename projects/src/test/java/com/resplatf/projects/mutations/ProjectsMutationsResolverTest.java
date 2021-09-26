package com.resplatf.projects.mutations;

import com.resplatf.projects.models.project.*;
import com.resplatf.projects.repositories.ProjectsRepository;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class ProjectsMutationsResolverTest {

   @Mock
   private ProjectsRepository projectsRepository;

   @InjectMocks
   private ProjectsMutationsResolver projectsMutationsResolver;

   private ProjectModel projectModel;

   @BeforeEach
   void setUp() {
      MockitoAnnotations.openMocks(this);

      projectModel = new ProjectModel();

      projectModel.set_id(new ObjectId());
      projectModel.setName("Mi projecto");
      projectModel.setDescription("description");
      projectModel.setGeneralObjectives("generalObjectives");
      projectModel.setSpecificObjectives(new ArrayList<String>());
      projectModel.setTotalBudget(Long.parseLong("123"));
      projectModel.setInitialDate(LocalDateTime.now());
      projectModel.setFinalDate(LocalDateTime.now());
      projectModel.setCurrentStage("currentStage");
      projectModel.setProgress(new ArrayList<Progress>());
      projectModel.setType(new Type());
      projectModel.setStatus(new Status());
      projectModel.setUsers(new ArrayList<Users>());
   }

   @Test
   void createProject() {
      when(projectsRepository.save(projectModel)).thenReturn(projectModel);
      assertNotNull(projectsMutationsResolver.createProject(projectModel));
      assertEquals(projectsMutationsResolver.createProject(projectModel), projectModel);
   }
}