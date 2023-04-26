import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//A graph is a way of representing relationships between pairs of objects. 
//Meaning that a graph consists of vertices and form a pairwise connection between them with edges
//We wanna implement an undirected graph with weight where (u, v) is is the same (v, u)
//As opposed to a directed graph as can be assumed to be sailing routes are symmetric: if ship has sailed from A to B, then it can go from B to A.
//However in reality it might not be as simple..

//Vertices u and v said to be are adjacent if the endspoints of the edge are u and v. 
//An edge is incident to af vertex if it is one of it's endpoints. 

//To define a graph interface or not?
//Too much work if we start defining functions we dont need

//Adjancency list stores a list of incident edges to the given vertex. 
//More specifically, for every vertex, we have a list containing edges incident to that vertext
//Allows to for quick access to incident edges + adjacent vertices
//Java collection --> List, queue, set
// "We require that the primary structure for an adjacency list maintain the collection V of vertices in a way so that we can locate the secondary structure I(v)
// for a given vertex v in O(1) time." So the basic idea behind adjlist is to have a vertex, where each vertext contains a list of its adjacent vertexies
// Many ways of implementing it - arrays, linkedlist
//Typically the collection is a list/linkedlist
//The collection of vertices must be able to acess the secondary structure or auxilary data structure (the hashset) in O(1)
//HashMap<Vertex,Set<Edge>> outEdge = new HashMap<>();

//Wish the java book covered the implementation

// In Java, it is also possible to nest classes (a class within a class). 
// The purpose of nested classes is to group classes that belong together, which makes your code more readable and maintainable

public class Graph {

    // How do we determine the design of our vertex and edge class?
    // Every vertex resembles a port, so it should have name
    // Since its an adjacencyList, every vertext should have a collection of
    HashMap<Vertex, Set<Edge>> outEdge = new HashMap<>();

    class Vertex {
        String name;

        Vertex(String s) {
            name = s;
        }

        public String toString() {
            return name;
        }

        
    }

    class Edge {
        Vertex from, to;
        int weight;

        Edge(Vertex from, Vertex to, int w) {
            this.from = from;
            this.to = to;
            weight = w;
        }

        public String toString() {
            return from.name + " - " + weight + " -> " + to.name;
        }
    }

    

    void insertEdge(String u, String v, int w) {
        Edge e = new Edge(vertex(u), vertex(v), w);
        if (!outEdge.containsKey(e.from))
            outEdge.put(e.from, new HashSet<Edge>());
        outEdge.get(e.from).add(e);
    }



    Collection<Edge> edges() {
        Set<Edge> edges = new HashSet<>();
        for (Vertex v : outEdge.keySet())
            edges.addAll(outEdge.get(v));
        return edges;
    }

}
