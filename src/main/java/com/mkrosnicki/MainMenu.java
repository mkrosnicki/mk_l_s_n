package com.mkrosnicki;

import com.google.common.collect.Lists;
import com.mkrosnicki.task1.Task1;
import com.mkrosnicki.task2.Task2;
import com.mkrosnicki.task3.Task3;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public class MainMenu {

  private static final String QUIT_OPTION = "0";

  public void start() {
    showMainMenu();
  }

  private void showMainMenu() {
    final Scanner scanner = new Scanner(System.in);
    boolean appRunning = true;

    while (appRunning) {
      displayMainMenuOptions();

      final String selectedOption;

      if (scanner.hasNext()) {
        selectedOption = scanner.next();

        switch (selectedOption) {
          case "1":
            showSubmenu_Task1(scanner);
            break;
          case "2":
            showSubmenu_Task2(scanner);
            break;
          case "3":
            showSubmenu_Task3(scanner);
            break;
          case QUIT_OPTION:
            displayFarewell();
            appRunning = false;
            break;
          default:
            displayNoSuchCommendWarning();
        }
      }
    }
  }

  private void displayMainMenuOptions() {
    System.out.println("-------------------------\n");
    System.out.println("Choose task");
    System.out.println("-------------------------\n");
    System.out.println("1 - TASK 1");
    System.out.println("2 - TASK 2");
    System.out.println("3 - TASK 3");
    System.out.println(String.format("%s - Quit", QUIT_OPTION));
  }

  private void showSubmenu_Task1(final Scanner scanner) {
    displayTaskSelectedHeader();
    final List<Integer> integers1 = collectIntsList(scanner);
    final Task1 task1 = new Task1();
    task1.displayResultsFor(integers1);
  }

  private void showSubmenu_Task2(final Scanner scanner) {
    displayTaskSelectedHeader();
    final List<Integer> integers = collectIntsList(scanner);
    final Task2 task2 = new Task2(13);
    task2.displayResultsFor(integers);
  }

  private void showSubmenu_Task3(final Scanner scanner) {
    displayTaskSelectedHeader();
    final List<List<Integer>> pairs = collectIntPairs(scanner);
    final Task3 task3 = new Task3();
    task3.displayResultsFor(pairs);
  }

  private void displayFarewell() {
    System.out.println("Thank you, bye!");
  }

  private void displayNoSuchCommendWarning() {
    System.out.println("No such task!");
  }

  private void displayTaskSelectedHeader() {
    System.out.println(String.format("Enter test data:"));
  }

  private final List<Integer> collectIntsList(final Scanner scanner) {
    scanner.nextLine();
    List<Integer> intsList = null;
    while (isNull(intsList)) {
      try {
        final String input = scanner.nextLine();
        final String[] inputSplitted = input.split(" ");
        intsList = Arrays.stream(inputSplitted).map(Integer::valueOf).collect(Collectors.toList());
      } catch (final NumberFormatException e) {
        System.out.println("Enter numbers separated with \" \"!");
      }
    }
    return intsList;
  }

  private final List<List<Integer>> collectIntPairs(final Scanner scanner) {
    scanner.nextLine();
    final int pairsCount = scanner.nextInt();
    scanner.nextLine();
    final List<List<Integer>> pairs = Lists.newArrayList();
    while (pairs.size() != pairsCount) {
      final String input = scanner.nextLine();
      final String[] inputSplitted = input.split(" ");
      if (inputSplitted.length != 2) {
        System.out.println("Wrong input length!");
      } else {
        try {
          final List<Integer> intPairs = Arrays.stream(inputSplitted).map(Integer::valueOf).collect(Collectors.toList());
          pairs.add(intPairs);
        } catch (final NumberFormatException e) {
          System.out.println("Enter numbers!");
        }
      }
    }

    return pairs;
  }

}
