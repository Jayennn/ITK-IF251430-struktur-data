package org.datastructures.tree.rbt;

public class Main {
  public static void main(String[] args) {
    RedBlackTree tree = new RedBlackTree();

    int[] values = { 10, 5, 1, 7, 40, 30, 70, 80, 35, 6 };

    for (int val : values) {
      tree.insert(val);
    }

    System.out.println("PreOrder:");
    tree.inOrderTraversal(tree.root);

    System.out.println("");

    System.out.println("PostOrder:");
    tree.postOrderTraversal(tree.root);

    System.out.println("");

    System.out.println("Inorder:");
    tree.inOrderTraversal(tree.root);

    System.out.println("");
  }
}
