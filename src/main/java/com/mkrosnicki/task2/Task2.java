package com.mkrosnicki.task2;

import com.google.common.collect.Maps;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;

public class Task2 {

  private final int sumUpTo;

  public Task2(final int sumUpTo) {
    this.sumUpTo = sumUpTo;
  }

  public void displayResultsFor(final List<Integer> input) {
    if (input.size() < 2) {
      return;
    }

    Collections.sort(input, Comparator.comparing(v -> Math.min(v, sumUpTo - v)));

    final Map<Integer, Integer> valuesToOccurencesSoFar = Maps.newHashMap();

    for (int i = 0; i < input.size(); i++) {
      final Integer currentValue = input.get(i);
      final int currentValueDiff = sumUpTo - currentValue;

      if (valuesToOccurencesSoFar.containsKey(currentValueDiff)) {
        for (int j = 0; j < valuesToOccurencesSoFar.get(currentValueDiff); j++) {
          final int minValue = Math.min(currentValue, currentValueDiff);
          System.out.println(String.format("%d %d", minValue, sumUpTo - minValue));
        }
      }

      valuesToOccurencesSoFar.compute(currentValue, (k, v) -> isNull(v) ? 1 : v + 1);
    }
  }
}
