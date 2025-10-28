package org.datastructures.tree.bst;

import java.awt.*;

class Node {
   int key;
   Node left, right;
   Boolean visited = false;
   Color tempColor;

   public Node(int key){
      this.key = key;
      this.left = null;
      this.right = null;
   }
}