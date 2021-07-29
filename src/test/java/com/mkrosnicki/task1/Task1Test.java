package com.mkrosnicki.task1;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test {

  private static Task1 task1;
  private static List<Integer> testData1;
  private static List<Integer> testData2;

  @BeforeAll
  static void initTestData() {
    task1 = new Task1();
    testData1 = Lists.newArrayList(1, 10, 20, 20, 2, 5);
    testData2 = Lists.newArrayList(Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
  }

  @Test
  @DisplayName("Tests parsing list to string of sorted elements")
  void getSortedListToStringTest() {
    assertAll(() -> {
      assertEquals("1 2 5 10 20", task1.getSortedListToString(testData1));
      assertEquals("-2147483648 2147483647", task1.getSortedListToString(testData2));
    });
  }

  @Test
  @DisplayName("Tests parsing list to string of count of it's distinct elements")
  void getListCountStringTest() {
    assertAll(() -> {
      assertEquals("count: 6", task1.getListCountString(testData1));
      assertEquals("count: 3", task1.getListCountString(testData2));
    });
  }

  @Test
  @DisplayName("Tests parsing list to string of count of it's elements")
  void getListCountDistinctStringTest() {
    assertAll(() -> {
      assertEquals("distinct: 5", task1.getListCountDistinctString(testData1));
      assertEquals("distinct: 2", task1.getListCountDistinctString(testData2));
    });
  }

  @Test
  @DisplayName("Tests parsing list to string of it's min value")
  void getMinListValueStringTest() {
    assertAll(() -> {
      assertEquals("min: 1", task1.getMinListValueString(testData1));
      assertEquals("min: -2147483648", task1.getMinListValueString(testData2));
    });
  }

  @Test
  @DisplayName("Tests parsing list to string of it's max value")
  void getMaxListValueStringTest() {
    assertAll(() -> {
      assertEquals("max: 20", task1.getMaxListValueString(testData1));
      assertEquals("max: 2147483647", task1.getMaxListValueString(testData2));
    });
  }

  @AfterAll
  static void dispose() {
    task1 = null;
    testData1 = null;
    testData2 = null;
  }

}
