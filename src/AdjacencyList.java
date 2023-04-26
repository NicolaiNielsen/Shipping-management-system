import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class AdjacencyList {

    // In Java, it is also possible to nest classes (a class within a class).
    // The purpose of nested classes is to group classes that belong together, which
    // makes your code more readable and maintainable


    //Nested vertex class representing the city
    class Vertex {
        private String name;

        public Vertex(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    //Nested edge class representing the route between two cities with the weight being travel days
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
    // counter to count num of cities
    int counter = 0; 
    public AdjacencyList() {
        adjList = new HashMap<>();
    }

    //Function to check if a vertex exists, if not then add it to the adjlist with the empty hashset value
    //We could loop through the adjlist to check if the vertex exists, but that would be O(n) time
    //By using a hashmap, we can check if the vertex exists in constant time

    public Vertex addCity(String cityName) {
        if (!vertex.containsKey(cityName)) { //if not in hashmap, add it to the hashmap and adjlist
            Vertex city = new Vertex(cityName);//create a new vertex object
            adjList.put(city, new HashSet<>()); //add the vertex to the adjlist with an empty hashset value
            vertex.put(cityName, city); //add the vertex to the hashmap3
            //System.out.println("City added");
            //counter++;
            //System.out.println("Number of cities: " + counter);
            //System.out.println(vertex.get(cityName).getName());
            return city;
           
        } else {
            //System.out.println("City already exists");
            //System.out.println(vertex.get(cityName).getName());
            return vertex.get(cityName);
        }
    }

    //Function to add vertices to the adjlist if they dont exists already
    //Incident edges should be added to the adjlist as well in the hashset
    //The function should check whether or not the vertex exists in the vertex hashmap
    //f not then create a new vertex object and add it to the hashmap and adjlist
    //Then create two edge objects for the bidirectional edge
    //we need to add the edge to the hashset of the from the adjlist

    public void addEdge(String from, String to, int weight) {
        // Check if the cities exist in the graph
        Edge edge1 = new Edge(addCity(from), addCity(to), weight);
        Edge edge2 = new Edge(addCity(to), addCity(from), weight);

        // Add both edges to the hashset via (key.add(value)) in the adjacency list of their respective vertices
        adjList.get(addCity(from)).add(edge1);
        adjList.get(addCity(to)).add(edge2);
    }

    //Function to init edges + vertices from txt.file
    public void initGraphFromFile(String filename) {
        try {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            String from = parts[0];
            String to = parts[1];
            int weight = Integer.parseInt(parts[2]);
            addEdge(from, to, weight);
            //System.out.println("From: " + from);
            //System.out.println("To: " + to);
            //System.out.println("Weight: " + weight);
        }
        reader.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
        
    }

    //Function to print the adjlist
    //Loop through the adjlist and print the city name
    //Then loop through the hashset of edges and print the edge
    public void printAdjList() {
        int counter = 0;
        for (Vertex city : adjList.keySet()) {
            System.out.print(city.getName() + " -> ");
            counter++;
            Set<Edge> edges = adjList.get(city);
            
            for (Edge edge : edges) {
                System.out.print(edge.getTo().getName() + " (" + edge.getWeight() + ") ");
            }
            System.out.println();
            System.out.println("Counter: " + counter);
            System.out.println();
        }
        if (counter < adjList.size()) {
            System.out.println("Not all cities are printed");
            System.out.println("There is maybe collision in the hashmap");
        }
        System.out.println(adjList.size());
        System.out.println(vertex.size());
    }

    //Function to print all vertex names
    //Loop through the adjlist and print the city name
    public void printAllVertexNames() {

        for (Vertex city : adjList.keySet()) {

            System.out.println(city.getName());
        }
    }
    //


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
        graph.initGraphFromFile("network.txt");
        System.out.println();
        graph.printAllVertexNames();
        graph.printAdjList();
        
 
    }
}
