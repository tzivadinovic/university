package zad11;

import java.util.*;

class Main {
    static int ROW = 9;
    static int COL = 10;

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class queueNode {
        Point pt;
        int dist;

        public queueNode(Point pt, int dist) {
            this.pt = pt;
            this.dist = dist;
        }
    }

    static boolean isValid(int row, int col) {
        return (row >= 0) && (row < ROW) &&
                (col >= 0) && (col < COL);
    }

    static int[] rowNum = {-1, 0, 0, 1};
    static int[] colNum = {0, -1, 1, 0};

    static int findShortestPath(int[][] mat, Point src, Point dest) {
        if (mat[src.x][src.y] != 1 ||
                mat[dest.x][dest.y] != 1)
            return -1;

        boolean[][] visited = new boolean[ROW][COL];

        visited[src.x][src.y] = true;

        Queue<queueNode> q = new LinkedList<>();

        queueNode s = new queueNode(src, 0);
        q.add(s);

        while (!q.isEmpty()) {
            queueNode curr = q.peek();
            Point pt = curr.pt;

            if (pt.x == dest.x && pt.y == dest.y)
                return curr.dist;
            q.remove();

            for (int i = 0; i < 4; i++) {
                int row = pt.x + rowNum[i];
                int col = pt.y + colNum[i];

                if (isValid(row, col) && mat[row][col] == 1 && !visited[row][col]) {
                    visited[row][col] = true;
                    queueNode cell = new queueNode
                            (new Point(row, col), curr.dist + 1);
                    q.add(cell);
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] mat = {{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }};

        Point source = new Point(0, 0);
        Point dest = new Point(3, 4);

        int dist = findShortestPath(mat, source, dest);

        if (dist != -1)
            System.out.println("Najkraca putanja je " + dist);
        else
            System.out.println("Najkraca putanja ne postoji");
    }
}
