package org.datastructures.queuestack;

public class Queue {

    private Node front;
    private Node rear;
    private int size;

    Queue() {
        this.front = this.rear = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.front == null;
    }

    public void enqueue(int value) {
        Node data = new Node(value);

        if (isEmpty()) {
            front = rear = data;
        } else {
            rear.next = data;
            rear = data;
        }
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException(
                "Queue kosong, tidak bisa dequeue."
            );
        }

        Node prevTemp = front;
        front = front.next;

        if (front == null) {
            rear = null;
        }
        size--;

        return prevTemp.data;
    }

    public int size() {
        return this.size;
    }

    public void traverse() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        Node current = front;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" <-> ");
            }
            current = current.next;
        }
        System.out.print("\n");
    }

    // Swap node (bukan hanya isi data) dengan error handling
    public void swap(int x, int y) {
        if (isEmpty()) {
            throw new IllegalStateException("Queue kosong, tidak bisa swap.");
        }

        if (x == y) {
            throw new IllegalArgumentException(
                "Tidak bisa swap node dengan nilai yang sama: " + x
            );
        }

        Node prevX = null,
            currX = front;
        while (currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }

        Node prevY = null,
            currY = front;
        while (currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
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
            front = currY;
        }

        // Hubungkan prevY ke currX
        if (prevY != null) {
            prevY.next = currX;
        } else {
            front = currX;
        }

        // Tukar next pointer
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;

        // Update rear kalau perlu
        if (currX.next == null) rear = currX;
        if (currY.next == null) rear = currY;
    }
}
