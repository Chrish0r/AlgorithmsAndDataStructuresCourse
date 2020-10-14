package stack_stapel.url;

/**
 * This class implements a stack as an array.
 */
public class StackExample2 {
    private int [] stack;
    private int top;

    public StackExample2(int capacity) {
        stack = new int[capacity];
    }

    /*
     * Methoden vom Stack (Stapel)
     *
     * push() - Erzeugt ein neues Element und legt es oben drauf
     * pop() - Oberste Element auslesen und es entfernen
     * peek() - Oberste Element auslesen ohne es zu entfernen
     *
     */

    public void push(int value) {
        if(top == stack.length) {
            int[] newStack = new int[2 * stack.length];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }
        stack[top++] = value;
	/*
 	   stack[top] = value;
	   top = top + 1;
        Note: within lecture different approach -> top has been initialized (within constructor) with -1 and then everywhere else post-increment and/or +1
	*/
    }

    public int pop() throws UnderflowException {
        if(isEmpty()) {
            throw new UnderflowException("ERROR: The stack is empty!" + System.lineSeparator()
                    + "Please push an element onto the stack" + System.lineSeparator());
        }
        int value = stack[--top];
        stack[top] = 0; // bei Objekten würden wir auf null setzen
        return value;
    }

    public int peek() throws UnderflowException {
        if(isEmpty()) {
            throw new UnderflowException("ERROR: The stack is empty!" + System.lineSeparator()
                    + "Please push an element onto the stack" + System.lineSeparator());
        }
       return stack[top - 1];
    }


   // helper methods
    public int size() {
        return top;
    }

    public boolean isEmpty() {
        return top == 0;
    }
}
