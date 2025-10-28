package queuestack;

public class QueueImplementation {

    public static void main(String[] args) {
        Queue q = new Queue();
        // q.dequeue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);

        System.out.print("Awal: ");
        q.traverse();

        System.out.println("Dequeue: " + q.dequeue());
        // q.dequeue();

        try {
            q.swap(20, 40);
            System.out.print("Setelah swap 20 dan 40: ");
            q.traverse();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            q.swap(50, 60); // Error karena node tidak ada
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            q.dequeue();
            System.out.print("Setelah dequeue: ");
            q.traverse(); // 40 <-> 30 <-> 20
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Ukuran queue sekarang: " + q.size());
    }
}
