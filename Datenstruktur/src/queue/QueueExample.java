package queue;

public class QueueExample {

    private int[] array;
    private int front;
    private int rear; // hinerste Element bzw. zu letzt hinzugefügtes Element
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
        QueueExample queueExample = new QueueExample(10);

        try {
            queueExample.enqueue(30);
            queueExample.enqueue(1);
            queueExample.enqueue(10);
            queueExample.enqueue(4);
            queueExample.enqueue(100);
            queueExample.printQueue();

            System.out.println(queueExample.peek());

            queueExample.dequeue();
            queueExample.printQueue();

            System.out.println(queueExample.peek());

        } catch (OverflowException e) {
            e.printStackTrace();
        } catch (UnderFlowException e) {
            e.printStackTrace();
        }

        /*
        try {
            System.out.println(new QueueExample(10).peek());
        } catch (UnderFlowException e) {
            e.printStackTrace();
        }

         */

    }

    public int peek() throws UnderFlowException {
        if(isEmpty()) {
            throw new UnderFlowException("ERROR: Queue is empty!" + System.lineSeparator()
                                        + "Please add an element...");
        }
        return array[front];
    }

    // add element
    public void enqueue(int element) throws OverflowException {
        if(isFull()) {
            throw new OverflowException("ERROR: Queue is full!");
        }
        System.out.println("added element: " + element);

        rear = (rear + 1) % capacity;
        array[rear] = element;
        count++;

         // array[count] = element;
         // count++;
    }

    // load from queue
    public void dequeue() throws UnderFlowException {
        if(isEmpty()) {
            throw new UnderFlowException("ERROR: Queue is empty!" + System.lineSeparator()
                    + "Please add an element...");
        }
        System.out.println("loaded and deleted item: "  + array[front]);
        // updateQueue(array);

        front = (front + 1) % capacity;
        count--;
    }


    // helper methods
    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isFull() {
        return size() == capacity;
    }

    public void printQueue() {
        System.out.println(System.lineSeparator() + "Current Queue:");
        for(int i = front; i < array.length; i++) {
            if(i == array.length - 1) {
                System.out.println(array[i]);
                break;
            }
            System.out.print(array[i] + ", ");
        }
    }
/*
    public void updateQueue(int[] array) {
        int[] tempArray = new int[capacity - 1];
        for(int i = 0, k = 0; i < array.length; i++) {
            if(i == front) {
                continue;
            }
            tempArray[k++] = array[i];
        }
        array = tempArray;
    }

 */
}
