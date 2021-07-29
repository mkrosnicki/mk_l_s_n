package com.mkrosnicki.task1;

import com.google.common.collect.Sets;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task1 {

  public void displayResultsFor(final List<Integer> input) {
    displayResultForMeasurer(input, this::getSortedListToString);
    displayResultForMeasurer(input, this::getListCountString);
    displayResultForMeasurer(input, this::getListCountDistinctString);
    displayResultForMeasurer(input, this::getMinListValueString);
    displayResultForMeasurer(input, this::getMaxListValueString);
  }

  private void displayResultForMeasurer(final List<Integer> input, final Function<List<Integer>, String> listMeasurer) {
    System.out.println(listMeasurer.apply(input));
  }

  String getSortedListToString(final List<Integer> integers) {
    return integers.stream()
            .distinct()
            .sorted()
            .map(Object::toString)
            .collect(Collectors.joining(" "));
  }

  String getListCountString(final List<Integer> integers) {
    return "count: " + integers.size();
  }

  String getListCountDistinctString(final List<Integer> integers) {
    return "distinct: " + Sets.newHashSet(integers).size();
  }

  String getMinListValueString(final List<Integer> integers) {
    return "min: " + integers.stream()
            .min(Comparator.naturalOrder())
            .map(Objects::toString)
            .orElse("");
  }

  String getMaxListValueString(final List<Integer> integers) {
    return "max: " + integers.stream()
            .max(Comparator.naturalOrder())
            .map(Objects::toString)
            .orElse("");
  }
}
