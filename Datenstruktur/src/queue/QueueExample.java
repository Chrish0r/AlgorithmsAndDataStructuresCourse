package queue;

public class QueueExample {

    private int[] array;
    private int front;
    private int rear; // hinerste Element
    private int capacity;
    private int count;

    public QueueExample(int size) {
        array = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }

    public static void main(String[] args) {

    }
}
