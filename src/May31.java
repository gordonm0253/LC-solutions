import java.util.*;

public class May31 {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] adjList = getAdj(board);
        boolean[] visited = new boolean[n * n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        int step = 1;
        //BFS - storing the steps to know how many dice rolls are taken to reach each element in the queue
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i<size; i++) {
                int polled = q.poll();
                if (visited[polled]) continue; //ignore the element in the queue if we have already visited it before
                visited[polled] = true;
                for (int j = polled + 1; j <= Math.min(polled + 6, n * n); j++) {
                    int p = j;
                    if (adjList[j] != -1) {
                        p = adjList[j];
                    }
                    if (p == n * n) {
                        return step; //we've reached the end if this is true!
                    }
                    q.add(p);
                }
            }
            step++;
        }
        return -1; //case where the end is not reachable

    }
    public int[] getAdj(int[][] board) {
        //creates 1D adjacency list of 2D board
        int n = board.length;
        int[] arr = new int[n * n + 1];
        int r = n - 1;
        int c = 0;
        int ctr = 1; //index
        boolean right = true; //to know if we are traversing right/left
        while (ctr <= n * n) {
            arr[ctr] = board[r][c];
            if (right) {
                if (c + 1 == n) {
                    //if we reach the right of our board, we want to move up one and start going to the left
                    r--;
                    right = false;
                } else {
                    c++;
                }
            } else {
                if (c - 1 < 0) {
                    //if we reach the left of our board, we move up one and go right
                    r--;
                    right = true;
                } else {
                    c--;
                }
            }
            ctr++;
        }
        return arr;
    }
}
