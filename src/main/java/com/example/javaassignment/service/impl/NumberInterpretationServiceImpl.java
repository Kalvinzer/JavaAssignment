package com.example.javaassignment.service.impl;

import com.example.javaassignment.service.api.NumberInterpretationService;
import com.example.javaassignment.service.models.NumberModel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class NumberInterpretationServiceImpl implements NumberInterpretationService {

  @Override
  public String validateNumber(NumberModel numberModel) {
    return numberModel.getNumber().replaceAll("\\s", "");
  }

  public List<String> numberInterpretation(NumberModel numberModel) {
    List<String> numbersList = List.of((numberModel.getNumber().split("\\s")));
    ArrayList<String> resultList = new ArrayList<>();
    recurs(0, numbersList, resultList);
    return new ArrayList<>(new HashSet<>(resultList));
  }

  private void recurs(int position, List<String> list, ArrayList<String> resultList) {
    if (position < list.size() - 1) {
      List<String> tempList = new ArrayList<>(list);
      recurs(position + 1, tempList, resultList);

      int intNumber = Integer.parseInt(list.get(position));
      int intNextNumber = Integer.parseInt(list.get(position + 1));
      int tenthRemaining;
      int hundredthRemaining;

      if (intNumber < 100) {
        if (intNumber > 10) {
          tenthRemaining = intNumber % 10;
          if (tenthRemaining == 0 && intNextNumber < 10) {
            replaceTwoNumbersWithSum(
                position, list, resultList, position, intNumber, intNextNumber);
          }
          if (tenthRemaining != 0) {
            replaceNumberWithTwoParts(
                position, list, resultList, position, intNumber, tenthRemaining);
          }
        }
      } else {
        tenthRemaining = intNumber % 10;
        hundredthRemaining = intNumber % 100;
        if (hundredthRemaining == 0) {
          if (intNextNumber < 100) {
            replaceTwoNumbersWithSum(
                position, list, resultList, position, intNumber, intNextNumber);
          }
        } else {
          if (hundredthRemaining > 10) {
            tempList = new ArrayList<>(list);
            resultList.add(tempList.stream().map(String::valueOf).collect(Collectors.joining()));
            tempList.remove(position);
            tempList.add(position, String.valueOf(intNumber - hundredthRemaining));
            tempList.add(position + 1, String.valueOf(hundredthRemaining - tenthRemaining));
            tempList.add(position + 2, String.valueOf(tenthRemaining));
            resultList.add(tempList.stream().map(String::valueOf).collect(Collectors.joining()));
            recurs(position + 1, tempList, resultList);
          }
          replaceNumberWithTwoParts(
              position, list, resultList, position, intNumber, hundredthRemaining);
        }
      }
    }
  }

  private void replaceNumberWithTwoParts(
      int position,
      List<String> list,
      ArrayList<String> resultList,
      int i,
      int intNumber,
      int hundredthRemaining) {
    List<String> tempList = new ArrayList<>(list);
    resultList.add(tempList.stream().map(String::valueOf).collect(Collectors.joining()));
    tempList.remove(i);
    tempList.add(i, String.valueOf(intNumber - hundredthRemaining));
    tempList.add(i + 1, String.valueOf(hundredthRemaining));
    resultList.add(tempList.stream().map(String::valueOf).collect(Collectors.joining()));
    recurs(position + 1, tempList, resultList);
  }

  private void replaceTwoNumbersWithSum(
      int position,
      List<String> list,
      ArrayList<String> resultList,
      int i,
      int intNumber,
      int intNextNumber) {
    List<String> tempList = new ArrayList<>(list);
    resultList.add(tempList.stream().map(String::valueOf).collect(Collectors.joining()));
    tempList.remove(i + 1);
    tempList.remove(i);
    tempList.add(i, String.valueOf(intNumber + intNextNumber));
    resultList.add(tempList.stream().map(String::valueOf).collect(Collectors.joining()));
    recurs(position + 1, tempList, resultList);
  }
}
