import java.util.ArrayList;
import java.util.Arrays;

public class May30 {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        //run dfs on from both points to get distances of all other nodes from starting point
        int[] d1 = dfs(edges, node1);
        int[] d2 = dfs(edges, node2);
        int min = Integer.MAX_VALUE;
        int node = -1;
        //compare node distances
        //in order for node to be considered, it must be reachable from both starting points (i.e. distance != -1)
        for (int i = 0; i < n; i++) {
            if (d1[i] != -1 && d2[i] != -1 && Math.max(d1[i], d2[i]) < min) {
                min = Math.max(d1[i], d2[i]);
                node = i;
            }
        }
        return node;
        //time complexity: O(N)
        //for dfs, we are traversing at max N vertices and N edges
        //we also store distances in an O(N) space array that we iterate over to get our final answer
    }
    public int[] dfs(int[] edges, int curr) {
        int n = edges.length;
        int[] distance = new int[n];
        Arrays.fill(distance, -1);
        distance[curr] = 0;
        //in order to continue the loop, the current node must point to another node in the graph
        //Additionally, the next node must be undiscovered (i.e. distance to it is unmarked or -1)
        while (edges[curr] != -1 && distance[edges[curr]] == -1) {
            distance[edges[curr]] = distance[curr] + 1;
            curr = edges[curr];
        }
        return distance;
    }
}
