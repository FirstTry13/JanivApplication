package com.janiv.api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.janiv.api.model.User;

//repository that extends CrudRepository 
public interface UsersRepository extends CrudRepository<User, Long>   {

	@Query("SELECT u FROM User u WHERE u.mobilenumber = :username")
    public User getUserByUsername(@Param("username") Long username);

}
