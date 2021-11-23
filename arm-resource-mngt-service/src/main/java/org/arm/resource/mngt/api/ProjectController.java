package org.arm.resource.mngt.api;

import java.util.List;
import org.arm.resource.mngt.entity.Project;
import org.arm.resource.mngt.impl.IProjectService;
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
	
	@GetMapping("/project")
	public ResponseEntity<List<Project>> getAllProject(){
		List<Project> project= projectService.getAllProject();
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "");
		headers.add("info", "");
		projectService.getAllProject().forEach(System.out::println);
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(project);
	}
}
