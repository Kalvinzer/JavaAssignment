package com.example.javaassignment.web.controller;

import com.example.javaassignment.service.api.NumberInterpretationService;
import com.example.javaassignment.service.models.NumberModel;
import com.example.javaassignment.web.dto.request.NumberInterpretRequestDto;
import com.example.javaassignment.web.dto.request.NumberValidateRequestDto;
import com.example.javaassignment.web.dto.response.NumberInterpretResponseDto;
import com.example.javaassignment.web.mappers.WebLayerMapper;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/number")
@RequiredArgsConstructor
public class NumberInputController {
  private final NumberInterpretationService interpretationService;

  @PostMapping("/interpret")
  @Operation(summary = "Get all possible number variations")
  public ResponseEntity<NumberInterpretResponseDto> numberInterpretation(
      @Validated @RequestBody NumberInterpretRequestDto requestDto) {
    final NumberModel numberModel = WebLayerMapper.I.numberInterpretRequestDtoToModel(requestDto);
    return ResponseEntity.ok(
        new NumberInterpretResponseDto(interpretationService.numberInterpretation(numberModel)));
  }

  @PostMapping("/validate")
  @Operation(summary = "validate a number")
  public ResponseEntity<String> numberValidation(
      @Validated @RequestBody NumberValidateRequestDto requestDto) {
    final NumberModel numberModel = WebLayerMapper.I.numberValidateRequestDtoToModel(requestDto);
    return ResponseEntity.ok(interpretationService.validateNumber(numberModel));
  }
}
