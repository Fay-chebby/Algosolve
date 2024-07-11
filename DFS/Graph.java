import java.util.*;

// This class represents a directed graph using adjacency list representation
class Graph {
    private int V; // Number of vertices

    // Array of arrays for Adjacency List Representation
    private int adj[][];

    // Constructor
    Graph(int v) {
        V = v;
        adj = new int[v][v]; // Initialize the adjacency matrix with 0s
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v][w] = 1; // Set the value in the adjacency matrix to 1
    }

    // A function used by DFS
    void DFSUtil(int v, boolean visited[]) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        // Recur for all the vertices adjacent to this vertex
        for (int i = 0; i < V; i++) {
            if (adj[v][i] == 1 && !visited[i]) {
                DFSUtil(i, visited);
            }
        }
    }

    // The function to do DFS traversal. It uses recursive DFSUtil()
    void DFS(int v) {
        // Mark all the vertices as not visited (set as false by default in Java)
        boolean visited[] = new boolean[V];

        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited);
    }

    // Driver Code
    public static void main(String args[]) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);


        System.out.println("Following is Depth First Traversal (starting from vertex 2)");

        // Function call
        g.DFS(2);
    }
}

