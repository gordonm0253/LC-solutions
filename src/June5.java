import java.util.*;

public class June5 {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length();
        int[][] graph = new int[26][26]; //create adjacency graph
        for (int i = 0; i<n; i++) {
            //build the graph - there is an edge from char a and b if they occur at the same index of s1 and s2
            int a = s1.charAt(i) - 'a';
            int b = s2.charAt(i) - 'a';
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        boolean[] visited = new boolean[26];
        int[] arr = new int[26];
        for (int i = 0; i<26; i++) {
            ArrayList<Integer> li = new ArrayList<>();
            int min = dfs(li, graph, visited, i);
            for (int j: li) {
                arr[j] = min;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c: baseStr.toCharArray()) {
            // take the smallest value according to arr[c - 'a']
            // ensures that the string is lexicographically smallest
            sb.append((char) (arr[c - 'a'] + 'a'));
        }
        return sb.toString();
    }
    // dfs returns the path taken (equivalent characters) and the lexicographically smallest character
    public int dfs(ArrayList<Integer> li, int[][] graph, boolean[] visited, int curr) {
        if (visited[curr]) { //base case - if we have already visited
            return Integer.MAX_VALUE;
        }
        visited[curr] = true;
        li.add(curr); // add current char/node to path
        int min = curr;
        for (int i = 0; i<26; i++) {
            if (visited[i] || graph[curr][i] == 0 || curr == i) continue;
            min = Math.min(dfs(li, graph, visited, i), min);
        }
        return min; //keep the smallest char since it is the lexicographically smallest one
    }
}
