package com.example.javaassignment.service.mappers;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, builder = @Builder(disableBuilder = true))
public interface ServiceLayerMapper {

  ServiceLayerMapper I = Mappers.getMapper(ServiceLayerMapper.class);
}
