package org.arm.resource.mngt.vo;

import org.arm.resource.mngt.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface ProjectMapper {
	ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);
	ProjectVO fromProject(Project project);
	
}
