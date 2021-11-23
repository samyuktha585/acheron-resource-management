package org.arm.resource.mngt.impl;

import java.util.List;

import org.arm.resource.mngt.dataaccess.CampaignRepository;
import org.arm.resource.mngt.dataaccess.ProjectRepository;
import org.arm.resource.mngt.entity.Campaign;
import org.arm.resource.mngt.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService implements IProjectService{

	@Autowired
	ProjectRepository projectRepository;
	
	@Override
	public List<Project> getAllProject() {
		// TODO Auto-generated method stub
		return projectRepository.findAll();
	}


}
