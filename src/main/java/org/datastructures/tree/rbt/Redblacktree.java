package org.datastructures.tree.rbt;

class RedBlackTree {

  protected static final boolean RED = true;
  protected static final boolean BLACK = false;

  Node root;

  private void leftRotate(Node x) {
    Node y = x.right;
    x.right = y.left;

    if (y.left != null) {
      y.left.parent = x;
    }

    y.parent = x.parent;

    if (x.parent == null) {
      root = y;
    } else if (x == x.parent.left) {
      x.parent.left = y;
    } else {
      x.parent.right = y;
    }

    y.left = x;
    x.parent = y;
  }

  private void rightRotate(Node x) {
    Node y = x.left;
    x.left = y.right;

    if (y.right != null) {
      y.right.parent = x;
    }

    y.parent = x.parent;

    if (x.parent == null) {
      root = y;
    } else if (x == x.parent.right) {
      x.parent.right = y;
    } else {
      x.parent.left = y;
    }

    y.right = x;
    x.parent = y;
  }

  public void insert(int data) {
    Node node = new Node(data);
    node.color = RED;

    Node parent = null;
    Node current = root;

    while (current != null) {
      parent = current;
      if (node.data < current.data) {
        current = current.left;
      } else {
        current = current.right;
      }
    }

    node.parent = parent;

    if (parent == null) {
      root = node;
    } else if (node.data < parent.data) {
      parent.left = node;
    } else {
      parent.right = node;
    }

    fixInsert(node);
  }

  private void fixInsert(Node node) {
    Node parent;
    Node grandparent;

    while (node != root && node.parent != null && node.parent.color == RED) {
      parent = node.parent;
      grandparent = parent.parent;

      if (parent == grandparent.left) {
        Node uncle = grandparent.right;

        // CASE 1: Uncle is RED → Recolor only
        if (uncle != null && uncle.color == RED) {
          parent.color = BLACK;
          uncle.color = BLACK;
          grandparent.color = RED;

          node = grandparent;
        } else {

          // CASE 2: Node is RIGHT child → rotate left first
          if (node == parent.right) {
            leftRotate(parent);
            node = parent;
            parent = node.parent;
          }

          // CASE 3: Node is LEFT child → rotate right
          rightRotate(grandparent);

          parent.color = BLACK;
          grandparent.color = RED;
          node = parent;
        }

      } else {

        Node uncle = grandparent.left;

        if (uncle != null && uncle.color == RED) {
          parent.color = BLACK;
          uncle.color = BLACK;
          grandparent.color = RED;
          node = grandparent;
        } else {

          if (node == parent.left) {
            rightRotate(parent);
            node = parent;
            parent = node.parent;
          }

          leftRotate(grandparent);

          parent.color = BLACK;
          grandparent.color = RED;
          node = parent;
        }
      }
    }

    root.color = BLACK;
  }

  private void printHelper(Node root) {
    String color;
    if (root.color == RED) {
      color = "R";
    } else {
      color = "B";
    }

    System.out.print(root.data + "(" + color + ") ");
  }

  public void inOrderTraversal(Node root) {
    if (root == null)
      return;

    inOrderTraversal(root.left);
    // System.out.print(root.data + " ");
    printHelper(root);
    inOrderTraversal(root.right);
  }

  public void preOrderTraversal(Node root) {
    if (root == null)
      return;

    System.out.print(root.data + " ");
    preOrderTraversal(root.left);
    preOrderTraversal(root.right);
  }

  public void postOrderTraversal(Node root) {
    if (root == null)
      return;

    postOrderTraversal(root.left);
    postOrderTraversal(root.right);
    System.out.print(root.data + " ");
  }

}
