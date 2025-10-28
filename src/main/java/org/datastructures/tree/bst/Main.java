package org.datastructures.tree.bst;

import javax.swing.*;

public class Main {
   public static void main(String[] args) {
      SwingUtilities.invokeLater(() -> {
         JFrame frame = new JFrame("BST Visualization");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(800, 600);

         BinarySearchTree bst = new BinarySearchTree(null);
         BSTPanel panel = new BSTPanel(bst);
         bst.panel = panel;

         frame.add(panel);
         frame.setVisible(true);

         new Thread(() -> {
            int[] array = {8, 3, 5, 2, 2, 10, 9, 12};
//            char[] array = {'R', 'A', 'B', 'C', 'D', 'E', 'F', 'G',};


            for (int value : array) {
               bst.insert(value);

            }

            // Then animate traversal
            System.out.println("\nIn-order traversal:");
            bst.inOrderTraversal(bst.root);
            bst.current = null; // clear highlight


//            System.out.println("\nPre-order traversal:");
//            bst.preOrderTraversal(bst.root);
//            bst.current = null;

//            System.out.println("\nPost-order traversal:");
//            bst.postOrderTraversal(bst.root);
//            bst.current = null;


            panel.repaint();
         }).start();
      });
   }
}
