package com.example.javaassignment.web.dto.request;

import com.example.javaassignment.web.dto.validation.annotation.EnsureNumber;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EnsureNumber
public class NumberValidateRequestDto {
  private String number;
}
