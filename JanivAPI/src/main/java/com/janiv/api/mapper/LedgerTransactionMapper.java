package com.janiv.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.janiv.api.model.LedgerTransaction;
import com.janiv.api.model.User;

@Mapper(componentModel = "spring")
public interface LedgerTransactionMapper {
	
	void updateLedgerTransactionFromDto(LedgerTransaction dto, @MappingTarget LedgerTransaction entity);
}
