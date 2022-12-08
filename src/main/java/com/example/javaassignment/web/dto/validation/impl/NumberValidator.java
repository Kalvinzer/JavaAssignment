package com.example.javaassignment.web.dto.validation.impl;

import com.example.javaassignment.web.dto.request.NumberValidateRequestDto;
import com.example.javaassignment.web.dto.validation.annotation.EnsureNumber;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NumberValidator implements ConstraintValidator<EnsureNumber, NumberValidateRequestDto> {

  @Override
  public boolean isValid(
      NumberValidateRequestDto requestDto, ConstraintValidatorContext constraintValidatorContext) {
    String number = requestDto.getNumber();
    if (number == null) {
      return false;
    }

    String noSpacesNumber = number.replaceAll("\\s", "");

    if (!isGreekNumber(noSpacesNumber)) {
      return false;
    }
    if (!noSpacesNumber.matches("[0-9]+")) {
      return false;
    }

    List<String> innerNumbers = List.of((number.split("\\s")));

    for (String innerNumber : innerNumbers) {
      if (innerNumber.length() > 3) {
        return false;
      }
    }
    return true;
  }

  private boolean isGreekNumber(String noSpacesNumber) {
    int numberLength = noSpacesNumber.length();

    return (numberLength == 10
            && (noSpacesNumber.startsWith("2") || noSpacesNumber.startsWith("69")))
        || (numberLength == 14
            && (noSpacesNumber.startsWith("00302") || noSpacesNumber.startsWith("003069")));
  }
}
