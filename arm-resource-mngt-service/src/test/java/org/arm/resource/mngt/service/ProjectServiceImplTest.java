package org.arm.resource.mngt.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.arm.resource.mngt.entity.Priority;
import org.arm.resource.mngt.entity.Project;
import org.arm.resource.mngt.entity.Status;
import org.arm.resource.mngt.repository.ProjectRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest(classes = ArmRMSApplication.class)
//@Transactional
public class ProjectServiceImplTest {

	@InjectMocks
	ProjectService projectService;

	@Mock
	ProjectRepository projectRepository;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@DisplayName("Testing Project")
	public void getAllProjects() {
		List<Project> project = new ArrayList<>();
		Project projectS = new Project(1, "avi", "avinash", Timestamp.valueOf("2020-03-27 09:03:01"),
				Timestamp.valueOf("2020-04-27 09:03:01"), Priority.HIGH, Status.DEFINED,
				Timestamp.valueOf("2021-11-24 12:08:27"), Timestamp.valueOf("2021-11-24 12:08:27"), 0, "Avinash",
				"ayan", null, null);
		project.add(projectS);

		when(projectRepository.findAll()).thenReturn(project);
		List<Project> actual = projectService.getAllProject();

		assertEquals(actual.size(), 1);

	}

}
