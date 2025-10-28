package org.example.tree.bst;

import org.example.util.SleepUtil;

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

      inOrderTraversal(root.left);


      visit(root, Color.ORANGE, 300);
      System.out.print(root.key + " ");
      root.visited = true;
      panel.repaint();
      SleepUtil.sleepMillis(300);

      inOrderTraversal(root.right);


      if ((root.left == null || root.left.visited) && (root.right == null || root.right.visited)) {
         visit(root, Color.BLUE, 300);
      }


      visit(root, Color.GREEN, 300);

   }

   public void preOrderTraversal(Node root) {

      if (root == null) {
         return;
      }

      visit(root, Color.ORANGE, 300);
      System.out.print(root.key + " ");
      root.visited = true;
      panel.repaint();
      SleepUtil.sleepMillis(300);


      preOrderTraversal(root.left);
      preOrderTraversal(root.right);

      if ((root.left == null || root.left.visited) && (root.right == null || root.right.visited)) {
         visit(root, Color.BLUE, 300);
      }

      visit(root, Color.GREEN, 300);
   }

   public void postOrderTraversal(Node root) {

      if (root == null) {
         return;
      }

      postOrderTraversal(root.left);
      postOrderTraversal(root.right);


      visit(root, Color.ORANGE, 300);
      System.out.print(root.key + " ");
      root.visited = true;
      panel.repaint();
      SleepUtil.sleepMillis(300);

      if ((root.left == null || root.left.visited) && (root.right == null || root.right.visited)) {
         visit(root, Color.BLUE, 300);
      }

      visit(root, Color.GREEN, 300);
   }
}
