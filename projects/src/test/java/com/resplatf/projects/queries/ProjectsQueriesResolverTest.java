package com.resplatf.projects.queries;

import com.resplatf.projects.models.project.*;
import com.resplatf.projects.repositories.ProjectsRepository;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ProjectsQueriesResolverTest {

   @Mock
   private ProjectsRepository projectsRepository;

   @InjectMocks
   private ProjectsQueryResolver projectsQueryResolver;

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
   void findAll() {
      when(projectsRepository.findAll()).thenReturn(Arrays.asList(projectModel));
      assertNotNull(projectsQueryResolver.projects());
      assertEquals(projectsQueryResolver.projects(), Arrays.asList(projectModel));
   }

}
