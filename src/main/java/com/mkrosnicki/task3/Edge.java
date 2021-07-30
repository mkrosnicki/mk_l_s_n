package com.mkrosnicki.task3;

final class Edge {
  private final int src;
  private final int dest;

  Edge(final int src, final int dest) {
    this.src = src;
    this.dest = dest;
  }

  int getSrc() {
    return src;
  }

  int getDest() {
    return dest;
  }

  int getHigherVertexIndex() {
    return Integer.max(src, dest);
  }
}
