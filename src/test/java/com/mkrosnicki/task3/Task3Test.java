package com.mkrosnicki.task3;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task3Test {

  private final PrintStream standardOut = System.out;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

  @BeforeEach
  public void setUp() {
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @Test
  @DisplayName("Example from instruction")
  public void displayResultsFor_testCase1() {
    final Task3 task3 = new Task3();
    final List<List<Integer>> testData = Lists.newArrayList(
            Lists.newArrayList(2, 3),
            Lists.newArrayList(1, 2),
            Lists.newArrayList(5, 6)
    );
    task3.displayResultsFor(testData);

    assertEquals("2", outputStreamCaptor.toString().trim());
  }

  @Test
  @DisplayName("Example from instruction with additional joined nodes")
  public void displayResultsFor_testCase2() {
    final Task3 task3 = new Task3();
    final List<List<Integer>> testData = Lists.newArrayList(
            Lists.newArrayList(2, 3),
            Lists.newArrayList(1, 2),
            Lists.newArrayList(5, 6),
            Lists.newArrayList(6, 8)
    );
    task3.displayResultsFor(testData);

    assertEquals("2", outputStreamCaptor.toString().trim());
  }

  @Test
  @DisplayName("Example from instruction with additional disjoint nodes")
  public void displayResultsFor_testCase3() {
    final Task3 task3 = new Task3();
    final List<List<Integer>> testData = Lists.newArrayList(
            Lists.newArrayList(2, 3),
            Lists.newArrayList(1, 2),
            Lists.newArrayList(5, 6),
            Lists.newArrayList(7, 8)
    );
    task3.displayResultsFor(testData);

    assertEquals("3", outputStreamCaptor.toString().trim());
  }

  @Test
  @DisplayName("Self pointing nodes")
  public void displayResultsFor_testCase4() {
    final Task3 task3 = new Task3();
    final List<List<Integer>> testData = Lists.newArrayList(
            Lists.newArrayList(1, 1),
            Lists.newArrayList(2, 2)
    );
    task3.displayResultsFor(testData);

    assertEquals("2", outputStreamCaptor.toString().trim());
  }

  @AfterEach
  public void tearDown() {
    System.setOut(standardOut);
  }

}
