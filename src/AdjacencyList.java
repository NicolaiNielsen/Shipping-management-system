import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class AdjacencyList {

    // In Java, it is also possible to nest classes (a class within a class).
    // The purpose of nested classes is to group classes that belong together, which
    // makes your code more readable and maintainable

    class Vertex {
        private String name;

        public Vertex(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    class Edge {
        private Vertex from;
        private Vertex to;
        private int weight;

        public Edge(Vertex from, Vertex to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public Vertex getFrom() {
            return from;
        }

        public Vertex getTo() {
            return to;
        }

        public int getWeight() {
            return weight;
        }

        public String toString() {
            return from.getName() + " - " + weight + " -> " + to.getName();
        }
    }
    // NESTED A DATA structure that represents the adjlist
    // list of lists where the outer list represents all the vertices in the graph
    // and the inner list the edges

    // {
    // Vertex("New York") : {("New York", "Los Angeles", 4), ("New York", "Houston",
    // 5)},
    // Vertex("Los Angeles") : {("New York", "Los Angeles", 4), ("Los Angeles",
    // "Chicago", 3)},
    // Vertex("Chicago") : {("Los Angeles", "Chicago", 3), ("Chicago", "Houston",
    // 2)},
    // Vertex("Houston") : {("New York", "Houston", 5), ("Chicago", "Houston", 2)}
    // }

    // uses a hashmap of that stores key-value pairs
    // the key is the vertex and the value is a set of incident edge objects
    private HashMap<Vertex, Set<Edge>> adjList;
    
    //To be able to look up if a city is added to adjList in constant time, we can use the city name as key in a different hashmap
    //And the value as
    private HashMap<String, Vertex> vertex = new HashMap<>();

    // Constructor for adjacencylist
    // just initializes empty hashmap of adjlist, since it has no vertices or edges
    // yet.
    public AdjacencyList() {
        adjList = new HashMap<>();
    }

    //Helper function that creates a vertex object
    //Checks if vertex object with given string
    //The vertex object is then added as key to adjList hashmap
    //with an empty HashSet as its value 
    public void addCity(String cityName) {
        Vertex city = new Vertex(cityName);
        adjList.put(city, new HashSet<>());
    }

    public void search(String cityName) {
        for (Vertex city : adjList.keySet()) {
            if (city.getName().equals(cityName)) {
                System.out.println("The adjacency list contains a vertex with city name '" + cityName + "'");
                break;
            }
        }   
    }

    public void addEdge(String from, String to, int weight) {
        // Get the Vertex objects for the starting and ending cities of the edge

        Vertex fromCity = getCityByName(from);
        Vertex toCity = getCityByName(to);

        // If either vertex is not found in the graph, return without adding the edge
        if (fromCity == null || toCity == null) {
            System.out.println("Invalid edge: one or both vertices not found in the graph.");
            return;
        }

        // Create two Edge objects for the bidirectional edge
        Edge edge1 = new Edge(fromCity, toCity, weight);
        Edge edge2 = new Edge(toCity, fromCity, weight);

        // Add both edges to the adjacency list of their respective vertices
        adjList.get(fromCity).add(edge1);
        adjList.get(toCity).add(edge2);
    }

    private Vertex getCityByName(String cityName) {
        for (Vertex city : adjList.keySet()) {
            if (city.getName().equals(cityName)) {
                return city;
            }
        }
        return null;
    }

    public void printAdjList() {
        for (Vertex city : adjList.keySet()) {
            System.out.print(city.getName() + " -> ");
            Set<Edge> edges = adjList.get(city);
            for (Edge edge : edges) {
                System.out.print(edge.getTo().getName() + " (" + edge.getWeight() + ") ");
            }
            System.out.println();
        }
    }

    public boolean isConnected() {
        // Create a set to keep track of visited vertices
        Set<Vertex> visited = new HashSet<>();
        
        // Create a queue for BFS
        LinkedList<Vertex> queue = new LinkedList<>();
        
        // Add any vertex to the queue and mark it as visited
        Vertex start = adjList.keySet().iterator().next();
        queue.add(start);
        visited.add(start);
        
        while (queue.size() != 0) {
            // Dequeue a vertex from the queue
            Vertex current = queue.poll();
        
            // Get all adjacent vertices of the dequeued vertex and check if they
            // have been visited
            Set<Edge> edges = adjList.get(current);
            for (Edge edge : edges) {
                Vertex adjacentVertex = edge.getTo();
                if (!visited.contains(adjacentVertex)) {
                    visited.add(adjacentVertex);
                    queue.add(adjacentVertex);
                }
            }
        }
        
        // Check if all vertices are visited
        return visited.size() == adjList.keySet().size();
    }
    


    public static void main(String[] args) {
    AdjacencyList graph = new AdjacencyList();

    graph.addCity("Laem Chabang");
    graph.addCity("Bangkok");
    graph.addCity("Hong Kong");
    graph.addCity("Nansha New Port");
    graph.addCity("Tokyo");
    graph.addCity("Yokohama");
    graph.addCity("Nagoya");
    graph.addCity("Kobe");
    graph.addCity("Hakata");
    graph.addCity("Kaohsiung");
    graph.addCity("Keelung");
    graph.addCity("Yantian");
    graph.addCity("Chittagong");
    graph.addCity("Shanghai");
    graph.addCity("Dalian");
    graph.addCity("Xingang");
    graph.addCity("Qingdao");
    graph.addCity("Singapore");
    graph.addCity("Tanjung Pelepas");
    graph.addCity("Jakarta");
    graph.addCity("Surabaya");
    graph.addCity("Haiphong");
    graph.addCity("Ningbo");
    graph.addCity("Mombasa");
    graph.addCity("Dar es Salaam");

    graph.addEdge("Bangkok", "Laem Chabang", 1);
    graph.addEdge("Laem Chabang", "Hong Kong", 5);
    graph.addEdge("Hong Kong", "Nansha New Port", 1);
    graph.addEdge("Nansha New Port", "Tokyo", 5);
    graph.addEdge("Tokyo", "Yokohama", 1);
    graph.addEdge("Yokohama", "Nagoya", 1);
    graph.addEdge("Nagoya", "Kobe", 1);
    graph.addEdge("Kobe", "Hakata", 2);
    graph.addEdge("Kaohsiung", "Keelung", 2);
    graph.addEdge("Keelung", "Nansha New Port", 2);
    graph.addEdge("Nansha New Port", "Yantian", 1);
    graph.addEdge("Yantian", "Hong Kong", 1);
    graph.addEdge("Hong Kong", "Chittagong", 9);
    graph.addEdge("Shanghai", "Dalian", 4);
    graph.addEdge("Dalian", "Xingang", 2);
    graph.addEdge("Xingang", "Qingdao", 3);
    graph.addEdge("Qingdao", "Keelung", 3);
    graph.addEdge("Keelung", "Singapore", 6);
    graph.addEdge("Singapore", "Tanjung Pelepas", 2);
    graph.addEdge("Tanjung Pelepas", "Jakarta", 3);
    graph.addEdge("Jakarta", "Surabaya", 2);
    graph.addEdge("Chittagong", "Tanjung Pelepas", 8);
    graph.addEdge("Tanjung Pelepas", "Singapore", 2);
    graph.addEdge("Singapore", "Laem Chabang", 4);
    graph.addEdge("Laem Chabang", "Ningbo", 1);
    graph.addEdge("Chittagong", "Singapore", 8);
    graph.addEdge("Tanjung Pelepas", "Keelung", 7);
    graph.addEdge("Keelung", "Kaohsiung", 2);
    graph.addEdge("Kaohsiung", "Hong Kong", 2);
    graph.addEdge("Hong Kong", "Haiphong", 3);
    graph.addEdge("Haiphong", "Hong Kong", 3);
    graph.addEdge("Hong Kong", "Kaohsiung", 2);
    graph.addEdge("Kaohsiung", "Keelung", 2);
    graph.addEdge("Ningbo", "Nansha New Port", 4);
    graph.addEdge("Nansha New Port", "Tanjung Pelepas", 4);
    graph.addEdge("Tanjung Pelepas", "Mombasa", 13);
    graph.addEdge("Mombasa", "Dar es Salaam", 5);
    graph.addEdge("Dar es Salaam", "Tanjung Pelepas", 13);
    graph.addEdge("Tanjung Pelepas", "Laem Chabang", 3);
    graph.addEdge("Laem Chabang", "Ningbo", 1);
    
    graph.printAdjList();

    boolean connected = graph.isConnected();
    System.out.println("The graph is " + (connected ? "" : "not ") + "connected.");
    





    }

}
