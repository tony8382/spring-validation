package com.lyyang.dto;

import com.lyyang.vo.BigModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BigModelMapper {
    BigModelMapper INSTANCE = Mappers.getMapper(BigModelMapper.class);

    BigModelDto toDTO(BigModel bigModel);

}