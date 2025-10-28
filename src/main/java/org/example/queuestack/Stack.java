package queuestack;

public class Stack {

    private Node top;
    private int size;

    Stack() {
        this.top = null;
        this.size = 0;
    }

    boolean isEmpty() {
        return top == null;
    }

    public void push(int value) {
        Node data = new Node(value);
        data.next = top;
        top = data;
        size++;
    }

    public Node swap(int x, int y) {
        if (isEmpty()) {
            throw new IllegalStateException("Stack kosong, tidak bisa swap.");
        }

        if (x == y) {
            throw new IllegalArgumentException(
                "Tidak bisa swap node dengan nilai yang sama: " + x
            );
        }

        Node prevX = null,
            currX = null;
        Node prevY = null,
            currY = null;

        Node curr = top;

        // Cari x
        while (curr != null) {
            if (curr.data == x) {
                currX = curr;
                break;
            }
            prevX = curr;
            curr = curr.next;
        }

        curr = top;

        // Cari y
        while (curr != null) {
            if (curr.data == y) {
                currY = curr;
                break;
            }
            prevY = curr;
            curr = curr.next;
        }

        if (currX == null || currY == null) {
            throw new IllegalArgumentException(
                "Node dengan nilai " + x + " atau " + y + " tidak ditemukan."
            );
        }

        // Hubungkan prevX ke currY
        if (prevX != null) {
            prevX.next = currY;
        } else {
            top = currY;
        }

        // Hubungkan prevY ke currX
        if (prevY != null) {
            prevY.next = currX;
        } else {
            top = currX;
        }

        // Tukar next
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;

        return top;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack kosong, tidak bisa peek.");
        }
        return top.data;
    }

    public int size() {
        return this.size;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack kosong, tidak bisa pop.");
        }

        Node prev = top;
        top = top.next;
        size--;

        return prev.data;
    }

    public void traverse() {
        if (isEmpty()) {
            throw new IllegalStateException(
                "Stack kosong, tidak bisa traverse."
            );
        }

        Node current = top;
        System.out.println();
        while (current != null) {
            System.out.println("| " + current.data + " |");
            current = current.next;
        }
        System.out.println("------");
    }
}
