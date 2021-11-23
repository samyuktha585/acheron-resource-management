package org.arm.resource.mngt.impl;

import java.util.List;

import org.arm.resource.mngt.dataaccess.TaskRepository;
import org.arm.resource.mngt.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ITaskServiceImpl implements ITaskService {

	@Autowired
	TaskRepository taskRepository;

	

	@Override
	public List<Task> getAllTask() {
		// TODO Auto-generated method stub
		return taskRepository.findAll();
	}
}
