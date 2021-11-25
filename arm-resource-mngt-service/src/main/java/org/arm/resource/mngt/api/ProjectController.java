package org.arm.resource.mngt.api;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.arm.resource.mngt.entity.Priority;
import org.arm.resource.mngt.entity.Project;
import org.arm.resource.mngt.entity.Status;
import org.arm.resource.mngt.service.IProjectService;
import org.arm.resource.mngt.vo.ProjectMapper;
import org.arm.resource.mngt.vo.ProjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

	@Autowired
	private IProjectService projectService;

	@GetMapping("/projects")
	ResponseEntity<List<Project>> getProjects() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get");
		List<Project> project = projectService.getAllProject();
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(project);
	}

	@GetMapping("/project")
	ResponseEntity<List<ProjectVO>> getProject() {
		List<ProjectVO> projectVO = new ArrayList<ProjectVO>();
		List<Project> allProject = projectService.getAllProject();
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get");
		for (Project project : allProject) {
			ProjectMapper mapper = ProjectMapper.INSTANCE;
			ProjectVO vo = mapper.fromProject(project);
			projectVO.add(vo);
		}

		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(projectVO);
	}

	@GetMapping("/project/create")
	public void createProject() {
		Project project = new Project();
		// project.setCampaignId(1);
		project.setCreateDate(new Timestamp(new Date().getTime()));
		project.setEndDate(new Timestamp(new Date().getTime() + 15 * 86400));
		project.setIsDeleted(0);
		project.setStartDate(new Timestamp(new Date().getTime()));
		project.setPriority(Priority.HIGH);
		project.setProjectName("New Project");
		project.setProjectOwner("Test");
		project.setStatus(Status.IN_PROGRESS);

		projectService.save(project);
	}
}
