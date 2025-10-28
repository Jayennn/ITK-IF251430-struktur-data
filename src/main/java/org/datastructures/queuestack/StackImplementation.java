package org.datastructures.queuestack;

public class StackImplementation {

    public static void main(String[] args) {
        Stack s = new Stack();

        System.out.println("Pop stack saat masih kosong:");
        // s.pop();

        // Push stack berupa angka
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);

        System.out.println("Awal stack:");
        s.traverse();

        System.out.println("Pop stack: " + s.pop());
        s.traverse();

        try {
            s.swap(30, 20);
            System.out.println("Setelah swap 40 dan 20:");
            s.traverse();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            System.out.println("Peek: " + s.peek());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            s.pop();
            System.out.println("Setelah pop:");
            s.traverse();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Ukuran stack sekarang: " + s.size());
    }
}
