package com.mkrosnicki.task2;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

  private static final String LINE_SEPARATOR = System.getProperty("line.separator");
  private final PrintStream standardOut = System.out;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

  @BeforeEach
  public void setUp() {
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @Test
  @DisplayName("Example from instruction")
  public void test_displayResultsFor_testCase1() {
    final List<Integer> testData = Lists.newArrayList(1, 2, 10, 7, 5, 3, 6, 6, 13, 0);
    final Task2 task2 = new Task2(13);

    task2.displayResultsFor(testData);
    assertEquals(
            new StringBuilder()
                    .append("0 13")
                    .append(LINE_SEPARATOR)
                    .append("3 10")
                    .append(LINE_SEPARATOR)
                    .append("6 7")
                    .append(LINE_SEPARATOR)
                    .append("6 7").toString(),
            outputStreamCaptor.toString().trim());
  }

  @Test
  @DisplayName("Example from instruction, but shuffled")
  public void test_displayResultsFor_testCase2() {
    final List<Integer> testData = Lists.newArrayList(1, 2, 10, 6, 5, 3, 7, 6, 13, 0);
    final Task2 task2 = new Task2(13);

    task2.displayResultsFor(testData);
    assertEquals(
            new StringBuilder()
                    .append("0 13")
                    .append(LINE_SEPARATOR)
                    .append("3 10")
                    .append(LINE_SEPARATOR)
                    .append("6 7")
                    .append(LINE_SEPARATOR)
                    .append("6 7").toString(),
            outputStreamCaptor.toString().trim());
  }

  @Test
  @DisplayName("Many repetitions, in different order")
  public void test_displayResultsFor_testCase3() {
    final List<Integer> testData = Lists.newArrayList(-20, 7, 20, -7, -7, 20, 0, 13);
    final Task2 task2 = new Task2(13);

    task2.displayResultsFor(testData);
    assertEquals(
            new StringBuilder()
                    .append("-7 20")
                    .append(LINE_SEPARATOR)
                    .append("-7 20")
                    .append(LINE_SEPARATOR)
                    .append("-7 20")
                    .append(LINE_SEPARATOR)
                    .append("-7 20")
                    .append(LINE_SEPARATOR)
                    .append("0 13").toString(),
            outputStreamCaptor.toString().trim());
  }

  @Test
  @DisplayName("Same numbers only")
  public void test_displayResultsFor_testCase4() {
    final List<Integer> testData = Lists.newArrayList(1, 1, 1, 1);
    final Task2 task2 = new Task2(2);

    task2.displayResultsFor(testData);
    assertEquals(
            new StringBuilder()
                    .append("1 1")
                    .append(LINE_SEPARATOR)
                    .append("1 1")
                    .append(LINE_SEPARATOR)
                    .append("1 1")
                    .append(LINE_SEPARATOR)
                    .append("1 1")
                    .append(LINE_SEPARATOR)
                    .append("1 1")
                    .append(LINE_SEPARATOR)
                    .append("1 1").toString(),
            outputStreamCaptor.toString().trim());
  }

  @AfterEach
  public void tearDown() {
    System.setOut(standardOut);
  }

}
