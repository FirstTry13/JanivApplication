package com.janiv.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.janiv.api.model.Project;
import com.janiv.api.model.User;

public interface ProjectRepository  extends JpaRepository<Project, Integer>   {

}
