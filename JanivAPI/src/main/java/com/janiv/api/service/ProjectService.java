package com.janiv.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.janiv.api.model.Project;
import com.janiv.api.model.User;
import com.janiv.api.repository.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	ProjectRepository projectrepo;
	
	public Project getProjectById(Integer Id) {
		Optional<Project> proj=projectrepo.findById(Id);
		if( proj.isPresent())
			return proj.get();
		else
			return null;
	}

}
