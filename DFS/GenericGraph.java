import java.util.*;

public class GenericGraph<T> {
    private Map<T, Map<T, Integer>> adj; // Adjacency matrix using Map

    // Constructor
    public GenericGraph() {
        adj = new HashMap<>(); // Initialize the adjacency matrix with an empty HashMap
    }

    // Function to add a vertex to the graph
    public void addVertex(T vertex) {
        adj.putIfAbsent(vertex, new HashMap<>());
    }

    // Function to add an edge into the graph
    public void addEdge(T v, T w) {
        addVertex(v);
        addVertex(w);
        adj.get(v).put(w, 1); // Set the value in the adjacency matrix to 1
    }

    // A function used by DFS
    private void DFSUtil(T v, Set<T> visited) {
        visited.add(v); // Mark the current node as visited
        System.out.print(v + " ");

        // Recur for all the vertices adjacent to this vertex
        for (T neighbor : adj.get(v).keySet()) {
            if (!visited.contains(neighbor)) {
                DFSUtil(neighbor, visited);
            }
        }
    }

    // The function to do DFS traversal. It uses recursive DFSUtil()
    public void DFS(T v) {
        Set<T> visited = new HashSet<>(); // Mark all the vertices as not visited
        DFSUtil(v, visited); // Call the recursive helper function to print DFS traversal
    }


    public static void main(String[] args) {
        GenericGraph<String> g = new GenericGraph<>();

        g.addEdge("A", "B");
        g.addEdge("A", "C");
        g.addEdge("B", "D");
        g.addEdge("B","E");
        g.addEdge("C", "F");
        g.addEdge("C", "G");
        g.addEdge("F","H");
        g.addEdge("F","I");

        System.out.println("Following is Depth First Traversal (starting from vertex A)");

        g.DFS("C");
    }
}

