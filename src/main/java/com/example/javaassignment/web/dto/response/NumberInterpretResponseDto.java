package com.example.javaassignment.web.dto.response;

import com.example.javaassignment.web.dto.validation.annotation.EnsureNumber;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EnsureNumber
public class NumberInterpretResponseDto {
  private List<String> possibleCombinations;
}
