public class June1 {
    public long distributeCandies(int n, int limit) {
        long ct = 0;
        for (int i = 0; i<=Math.min(n, limit); i++) { //enumerating all possible quantities for the first child
            int left = n - i; //amount of candy we have left to give
            if (left <= limit) {
                //e.g. if we have 3 leftover candies to give to 2 people with limit 3,
                //we have 4 different ways of splitting it - (0, 3), (1, 2), (2, 1), (3, 0)
                ct += left + 1;
            } else if (left <= limit * 2) {
                //find the "window" of which a valid split can be achieved of the remaining candy
                //range of values of candy to be given is between (left - limit) and limit
                int lower = left - limit;
                ct += limit - lower + 1;
            }
        }
        return ct;
    }
}
