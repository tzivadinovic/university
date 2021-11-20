package zad10;

import java.util.LinkedList;

class Main {

    private final LinkedList<Integer>[] adj;

    @SuppressWarnings("unchecked")
    Main(int v) {
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    int countPathsUtil(int u, int d, int pathCount) {
        if (u == d) {
            pathCount++;
        }

        else {
            for (int n : adj[u]) {
                pathCount = countPathsUtil(n, d, pathCount);
            }
        }
        return pathCount;
    }

    int countPaths(int s, int d) {
        int pathCount = 0;
        pathCount = countPathsUtil(s, d, pathCount);
        return pathCount;
    }

    public static void main(String[] args)
    {
        Main g = new Main(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);

        int s = 0, d = 3;
        System.out.println(g.countPaths(s, d));
    }
}
