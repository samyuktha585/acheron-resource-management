package org.arm.resource.mngt.api;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.arm.resource.mngt.entity.Priority;
import org.arm.resource.mngt.entity.Status;
import org.arm.resource.mngt.entity.Task;
import org.arm.resource.mngt.service.ITaskService;
import org.arm.resource.mngt.vo.TaskMapper;
import org.arm.resource.mngt.vo.TaskVO;
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

	@GetMapping("/tasks")
	ResponseEntity<List<Task>> getTasks() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get");
		List<Task> task = taskService.getAllTask();
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(task);
	}

	@GetMapping("/task")
	ResponseEntity<List<TaskVO>> getTask() {
		List<TaskVO> taskVO = new ArrayList<TaskVO>();
		List<Task> allTask = taskService.getAllTask();
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get");
		for (Task task : allTask) {
			TaskMapper mapper = TaskMapper.INSTANCE;
			TaskVO vo = mapper.fromTask(task);
			taskVO.add(vo);
		}

		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(taskVO);
	}

	@GetMapping("/task/create")
	public void createTask() {
		// List<Task> tasks = new ArrayList<>();
		Task task = new Task();
		task.setCreateDate(new Timestamp(new Date().getTime()));
		task.setDuration(10);
		task.setEndDate(new Timestamp(new Date().getTime() + 15 * 86400));
		task.setStartDate(new Timestamp(new Date().getTime()));
		task.setIsDeleted(0);
		task.setPriority(Priority.MEDIUM);
		// task.setProjectId(1);
		task.setStatus(Status.IN_PROGRESS);
		task.setTaskName("Task5");
		task.setTaskOwner("Test");	
		taskService.createTasks(task);
	}
}
