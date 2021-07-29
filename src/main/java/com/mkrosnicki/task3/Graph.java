package com.mkrosnicki.task3;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class Graph {

  final List<List<Integer>> adjacencyList = new ArrayList<>();

  Graph(final Collection<Edge> edges) {
    if (edges.isEmpty()) {
      throw new IllegalArgumentException("Graph requires some edges to be instantiated.");
    }

    final int maxVertexIndex = edges.stream().mapToInt(Edge::getHigherVertexIndex).max().getAsInt();

    for (int i = 0; i <= maxVertexIndex; i++) {
      adjacencyList.add(i, Lists.newLinkedList());
    }

    for (final Edge current : edges) {
      adjacencyList.get(current.getSrc()).add(current.getDest());
    }
  }

  int getSubgraphsCount(final CountingMode countingMode) {
    final boolean[] vistedVertices = new boolean[adjacencyList.size()];

    int count = 0;
    for (int vertexIndex = 0; vertexIndex < adjacencyList.size(); vertexIndex++) {
      if (vistedVertices[vertexIndex]) {
        continue;
      }
      final boolean hasConnectedVertices = adjacencyList.get(vertexIndex).isEmpty();
      if (countingMode.is(CountingMode.IGNORE_NOT_CONNECTED_VERTICES) && !hasConnectedVertices) {
        doDFS(vertexIndex, vistedVertices);
        count++;
      }
    }
    return count;
  }

  void doDFS(final int vertexIndex, final boolean[] visitedVertex) {
    visitedVertex[vertexIndex] = true;
    for (final Integer adjacentVertexIndex : adjacencyList.get(vertexIndex)) {
      if (!visitedVertex[adjacentVertexIndex]) {
        doDFS(adjacentVertexIndex, visitedVertex);
      }
    }
  }

  enum CountingMode {
    IGNORE_NOT_CONNECTED_VERTICES,
    INCLUDE_NOT_CONNECTED_VERTICES;

    private boolean is(final CountingMode countingMode) {
      return this == countingMode;
    }
  }
}
