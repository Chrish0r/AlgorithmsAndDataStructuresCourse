package stack_stapel.url;

/**
 * This class implements a stack as a kind of reversed linked list - attention: lifo-principle.
 */
public class StackExample {
    private final int MAX_STACK_SIZE = 10; // Größe vom Stack
    private URLElement topElement = null; // Top = Immer DAS oberste Element vom Stack
    private int currentHeight = 0; // Aktuelle Höhe des Stacks

    /*
     * Methoden vom Stack (Stapel)
     *
     * push() - Erzeugt ein neues Element und legt es oben drauf
     * pop() - Oberste Element auslesen und es entfernen
     * peek() - Oberste Element auslesen ohne es zu entfernen
     *
     */

    public static void main(String[] args) {
        StackExample stack = new StackExample();

        try {
            stack.push("google.de");
            System.out.println("Das oberste Element ist: " + stack.peek());
            stack.push("youtube.com");
            System.out.println("Das oberste Element ist: " + stack.peek());
            stack.push("news.de");
            System.out.println("Das oberste Element ist: " + stack.peek());
            stack.push("gaming.de");
            System.out.println("Das oberste Element ist: " + stack.peek());
            System.out.println();

            System.out.println("Clicked 'BACK'-Button");
            System.out.println(stack.pop());
            System.out.println("Clicked 'BACK'-Button");
            System.out.println(stack.pop());
            System.out.println("Clicked 'BACK'-Button");
            System.out.println(stack.pop());
            System.out.println("Clicked 'BACK'-Button");
            System.out.println(stack.pop());
        } catch (OverflowException e) {
            e.printStackTrace();
        } catch (UnderflowException e) {
            e.printStackTrace();
        }
    }

    public void push(String url) throws OverflowException {
        if(currentHeight == MAX_STACK_SIZE) {
            throw new OverflowException("ERROR: The stack is full!");
        } else {
            URLElement urlElement = new URLElement(url, topElement);
            topElement = urlElement;

            currentHeight++;
        }
    }

    public String pop() throws UnderflowException {
        if(currentHeight == 0) {
            throw new UnderflowException("ERROR: The stack is empty!" + System.lineSeparator()
                                          + "Please push an element onto the stack" + System.lineSeparator());
        } else {
            String urlString = topElement.getUrl();
            topElement = topElement.getNext();
            currentHeight--;
            return urlString;  // da zu diesem Objekt nun keine Referenz mehr vorhanden ist, wird es bei Zeiten vom gargbage collector gelöscht.
        }
    }

    public String peek() throws UnderflowException {
        if(currentHeight == 0) {
            throw new UnderflowException("ERROR: The stack is empty!" + System.lineSeparator()
                    + "Please push an element onto the stack" + System.lineSeparator());
        } else {
            return topElement.getUrl();
        }
    }

/* not really applicable ragarding data structure stack


    public void printStack() throws UnderflowException {
        if(currentHeight == 0) {
            throw new UnderflowException("ERROR: The stack is empty!" + System.lineSeparator()
                    + "Please push an element onto the stack");
        } else {
            URLElement currentElement = topElement;
            while(currentElement != null) {
                System.out.println(currentElement.getUrl());
                currentElement = currentElement.getNext();
            }


        }
    }
 */
}
