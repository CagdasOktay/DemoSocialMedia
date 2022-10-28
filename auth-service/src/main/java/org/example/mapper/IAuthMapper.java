package org.example.mapper;


import org.example.dto.request.NewCreateUserDto;
import org.example.dto.request.RegisterRequestDto;
import org.example.repository.entity.Auth;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface IAuthMapper {

    IAuthMapper INSTANCE = Mappers.getMapper(IAuthMapper.class);

    Auth toAuth(final RegisterRequestDto dto);

    @Mapping(source = "id", target = "authid")
    NewCreateUserDto toNewCreateUserDto(final Auth auth);

}
