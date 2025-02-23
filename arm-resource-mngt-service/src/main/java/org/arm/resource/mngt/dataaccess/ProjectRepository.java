package org.arm.resource.mngt.dataaccess;

import org.arm.resource.mngt.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
