package com.mkrosnicki.task3;

import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;

public class Task3 {

  public void displayResultsFor(final Collection<List<Integer>> input) {

    final List<Edge> edges = Lists.newArrayList();

    for (final List<Integer> integers : input) {
      if (integers.size() != 2) {
        throw new IllegalArgumentException("Not correct input!");
      }
      edges.add(new Edge(integers.get(0), integers.get(1)));
    }

    final Graph g = new Graph(edges);
    final int subgraphsCount = g.getSubgraphsCount(Graph.CountingMode.IGNORE_NOT_CONNECTED_VERTICES);

    System.out.println(subgraphsCount);
  }

}
