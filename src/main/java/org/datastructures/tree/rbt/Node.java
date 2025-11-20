package org.datastructures.tree.rbt;

class Node {

  int data;
  boolean color;
  Node left, right, parent;

  Node(int data) {
    this.data = data;
    this.color = RedBlackTree.RED;
    left = right = parent = null;
  }
}
