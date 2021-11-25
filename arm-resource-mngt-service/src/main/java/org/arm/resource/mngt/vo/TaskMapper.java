package org.arm.resource.mngt.vo;


import org.arm.resource.mngt.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface TaskMapper {
	TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);
	TaskVO fromTask(Task task);
	
}
