package topologicalSort;

import java.util.*;

class Graph {
    private final int v;
    private final LinkedList<Integer>[] adj;

    Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v,int w) { adj[v].add(w); }

    void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        Integer i;

        for (Integer integer : adj[v]) {
            i = integer;
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }
        stack.push(v);
    }

    void topologicalSort() {
        Stack<Integer> stack = new Stack<>();

        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++)
            visited[i] = false;

        for (int i = 0; i < v; i++)
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);

        while (!stack.empty())
            System.out.print(stack.pop() + " ");
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Topološko sortiranje");
        g.topologicalSort();
    }
}
