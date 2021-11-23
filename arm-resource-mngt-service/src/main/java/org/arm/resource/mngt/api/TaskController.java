package org.arm.resource.mngt.api;

import java.util.List;

import org.arm.resource.mngt.entity.Task;
import org.arm.resource.mngt.impl.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
	@Autowired
	private ITaskService taskService;
	
	@GetMapping("/task")
	public ResponseEntity<List<Task>> allTasks(){
		List<Task> task = taskService.getAllTask();
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "");
		headers.add("info", "");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(task);

	}
}
