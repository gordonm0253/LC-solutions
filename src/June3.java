import java.util.*;

public class June3 {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int ct = 0;
        int n = status.length;
        boolean[] open = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        for (int box: initialBoxes) {
            q.add(box);
        }
        while (!q.isEmpty()) {
            boolean opened = false;
            int size = q.size();
            for (int i = 0; i<size; i++) {
                int poll = q.poll();
                if (open[poll]) continue; //if the box is already opened
                if (status[poll] == 1) { // if the box is open and unprocessed
                    open[poll] = true;
                    opened = true;
                    ct += candies[poll];
                    for (int key: keys[poll]) {
                        status[key] = 1; //getting the key to a box, so it open if we encounter it
                    }
                    for (int b: containedBoxes[poll]) {
                        q.add(b); //add contained boxes to process in the queue
                    }
                } else { //add it back in case opening other boxes will open this one
                    q.add(poll);
                }
            }
            if (!opened) {
                // if no new boxes were opened this time, then nothing will change in the next iterations
                // therefore we can return our answer
                return ct;
            }
        }
        return ct;
    }
}
