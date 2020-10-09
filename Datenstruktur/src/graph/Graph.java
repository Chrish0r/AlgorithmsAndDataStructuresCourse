package graph;

import java.util.LinkedList;
import java.util.List;

public class Graph {
    // Adjazenzliste -> LinkedList / ArrayList

    int vertex;
    LinkedList<Integer> list[];

    public Graph(int vertex) {
        this.vertex = vertex;
        list = new LinkedList[vertex];

        for(int i = 0; i < vertex; i++) {
            list[i] = new LinkedList<Integer>();
        }
    }

    public static void main(String[] args) {
        Graph graph1 = new Graph(5);

        graph1.addEdge(0, 1);
        graph1.addEdge(0, 4);
        graph1.addEdge(1, 2);
        graph1.addEdge(2, 3);
        graph1.addEdge(3, 4);

        graph1.printGraph();

    }

    public void addEdge(int source, int destination) {
        // add edge (Kante())
        list[source].add(destination);
        // list[source].addFirst(destination);

        /* add back edge -> if graph  undirected -> also opposed/reversed.
           When a directed graph is required, then just comment the code-snippet below out or remove it.
         */
        list[destination].add(source);
           //  list[destination].addFirst(source);
    }

    public void printGraph() {
        for(int i = 0; i < vertex; i++) {
            // check if the current vertice has a list
            if(list[i].size() > 0) {
                System.out.println("Vertice " + i + " is connected with vertices:");
                for(int j = 0; j < list[i].size(); j++) {
                    if(j == list[i].size() - 1) {
                        System.out.println(list[i].get(j));
                        break;
                    }
                    // -> print out the element at the position j from the list at the position i
                    System.out.print(list[i].get(j) + ", ");
                }
            }
        }
    }

}

