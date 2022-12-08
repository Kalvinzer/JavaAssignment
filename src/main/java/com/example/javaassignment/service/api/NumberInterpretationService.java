package com.example.javaassignment.service.api;

import com.example.javaassignment.service.models.NumberModel;
import java.util.List;

public interface NumberInterpretationService {
  List<String> numberInterpretation(NumberModel numberModel);

  String validateNumber(NumberModel numberModel);
}
