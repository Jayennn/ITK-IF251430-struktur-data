package org.example.tree.bst;

import javax.swing.*;
import java.awt.*;

public class BSTPanel extends JPanel {
   private BinarySearchTree tree;

   public BSTPanel(BinarySearchTree tree) {
      this.tree = tree;
      setBackground(Color.WHITE);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (tree.root != null) {
         drawTree(g, tree.root, getWidth() / 2, 50, getWidth() / 4);
      }
   }

   private void drawTree(Graphics g, Node node, int x, int y, int offset) {

      if (node == null) {
         return;
      }

      if (node.tempColor != null) {
         g.setColor(node.tempColor);
      } else if (node.visited ){
         g.setColor(Color.GREEN);
      } else {
         g.setColor(Color.LIGHT_GRAY);
      }

      g.fillOval(x - 20, y - 20, 40, 40);
      g.setColor(Color.BLACK);
      g.drawOval(x - 20, y - 20, 40, 40);

      g.drawString(String.valueOf(node.key), x - 5, y + 5);

      g.setColor(Color.BLACK);
      if (node.left != null) {
         g.drawLine(x - 10, y + 10, x - offset + 10, y + 60 - 10);
         drawTree(g, node.left, x - offset, y + 60, offset / 2);
      }
      if (node.right != null) {
         g.drawLine(x + 10, y + 10, x + offset - 10, y + 60 - 10);
         drawTree(g, node.right, x + offset, y + 60, offset / 2);
      }
   }
}
