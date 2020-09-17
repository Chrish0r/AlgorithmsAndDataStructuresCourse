package stack_stapel.url;

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
}
