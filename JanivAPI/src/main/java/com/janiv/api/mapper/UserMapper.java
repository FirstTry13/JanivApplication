package com.janiv.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.janiv.api.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {


	void updateUserFromDto(User dto, @MappingTarget User entity);
}
