package com.example.javaassignment.web.mappers;

import com.example.javaassignment.service.models.NumberModel;
import com.example.javaassignment.web.dto.request.NumberInterpretRequestDto;
import com.example.javaassignment.web.dto.request.NumberValidateRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

// @Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
@Mapper
public interface WebLayerMapper {

  WebLayerMapper I = Mappers.getMapper(WebLayerMapper.class);

  NumberModel numberValidateRequestDtoToModel(NumberValidateRequestDto requestDto);

  NumberModel numberInterpretRequestDtoToModel(NumberInterpretRequestDto requestDto);
}
