package org.datastructures.tree.bst;

import org.datastructures.util.SleepUtil;

import java.awt.*;

public class BinarySearchTree {
   Node root;
   Node current;
   BSTPanel panel;

   public BinarySearchTree(BSTPanel panel) {
      this.panel = panel;
   }

   public void insert(int key) {
      root = insertRecursive(root, key);
   }

   private void visit(Node node, Color color, int delay) {
      if (current != null && current != node) {
         current.tempColor = null;
      }
      current = node;
      node.tempColor = color;
      panel.repaint();
      SleepUtil.sleepMillis(delay);
   }



   private Node insertRecursive(Node root, int key) {
      if (root == null) {
         root = new Node(key);
         return root;
      }

      if (key < root.key)
         root.left = insertRecursive(root.left, key);
      else if (key > root.key)
         root.right = insertRecursive(root.right, key);


      return root;
   }

   public void inOrderTraversal(Node root) {

      if (root == null) {
         return;
      }

      visit(root, Color.GRAY, 500);
      inOrderTraversal(root.left);

      visit(root, Color.ORANGE, 500);
      System.out.print(root.key + " ");
      root.visited = true;
      panel.repaint();
      SleepUtil.sleepMillis(500);

      visit(root, Color.GRAY, 500);
      inOrderTraversal(root.right);


      if ((root.left == null || root.left.visited) && (root.right == null || root.right.visited)) {
         visit(root, Color.GRAY, 300);
      }


      visit(root, Color.GREEN, 300);

   }

   public void preOrderTraversal(Node root) {

      if (root == null) {
         return;
      }

      visit(root, Color.ORANGE, 500);
      System.out.print(root.key + " ");
      root.visited = true;
      panel.repaint();
      SleepUtil.sleepMillis(500);

      visit(root, Color.GRAY, 500);
      preOrderTraversal(root.left);

      visit(root, Color.GRAY, 500);
      preOrderTraversal(root.right);

      if ((root.left == null || root.left.visited) && (root.right == null || root.right.visited)) {
         visit(root, Color.GRAY, 300);
      }

      visit(root, Color.GREEN, 300);
   }

   public void postOrderTraversal(Node root) {

      if (root == null) {
         return;
      }

      visit(root, Color.GRAY, 500);
      postOrderTraversal(root.left);

      visit(root, Color.GRAY, 500);
      postOrderTraversal(root.right);


      visit(root, Color.ORANGE, 500);
      System.out.print(root.key + " ");
      root.visited = true;
      panel.repaint();
      SleepUtil.sleepMillis(500);

      if ((root.left == null || root.left.visited) && (root.right == null || root.right.visited)) {
         visit(root, Color.GRAY, 300);
      }

      visit(root, Color.GREEN, 300);
   }
}
