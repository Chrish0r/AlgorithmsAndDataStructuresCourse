package queue;

import java.util.concurrent.LinkedBlockingQueue;

public class QueueExampleJDK {
    public static void main(String[] args) {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

        try {
            queue.put(1);
            queue.put(2);
            queue.put(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(Integer item : queue) {
            System.out.println(item);
        }

        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println();

        for(Integer item : queue) {
            System.out.println(item);
        }

        System.out.println(queue.poll());

        System.out.println();
        for(Integer item : queue) {
            System.out.println(item);
        }
        System.out.println(System.lineSeparator() + queue.peek());


    }
}
