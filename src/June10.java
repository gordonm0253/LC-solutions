public class June10 {
    public int maxDifference(String s) {
        int[] freq = new int[26];
        for (char c: s.toCharArray()) {
            freq[c - 'a']++;
        }
        int maxOdd = 0;
        int minEven = 101;
        for (int i = 0; i<26; i++) {
            if (freq[i] > 0) {
                if (freq[i] % 2 == 0) {
                    minEven = Math.min(freq[i], minEven);
                } else {
                    maxOdd = Math.max(freq[i], maxOdd);
                }
            }

        }
        return maxOdd - minEven;
    }
}
