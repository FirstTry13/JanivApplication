package com.janiv.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.janiv.api.model.User;



//repository that extends CrudRepository 
@Repository
public interface UsersRepository extends CrudRepository<User, Long>  {

	@Query("SELECT u FROM User u WHERE u.mobilenumber = :mobilenumber")
    public User getUserByUsername(@Param("mobilenumber") Long mobilenumber);

	
	//@Query("SELECT u FROM User u WHERE u.mobilenumber = :mobilenumber")
    //public List<User> findByMobilenumber(@Param("mobilenumber") Long username);

}
