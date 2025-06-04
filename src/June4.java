class June4 {
    public String answerString(String word, int numFriends) {
        int len = word.length();
        String max = null;
        int maxLength = len - numFriends + 1;
        if (numFriends == 1) {
            return word;
        }
        int large = 0;
        for (int i = 0; i<word.length(); i++) {
            large = Math.max(word.charAt(i) - 'a', large);
        }
        String first = ((char) (large + 'a')) + "";
        int index = word.indexOf(first);
        while (index != -1) {
            String str = word.substring(index, Math.min(len, index + maxLength));
            if (!compare(max, str)) {
                max = str;
            }
            index = word.indexOf(first, index + 1);
        }
        return max;
    }
    public boolean compare(String s1, String s2) {
        if (s1 == null) {
            return false;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        for (int i = 0; i<Math.min(c2.length, c1.length); i++) {
            int cur1 = c1[i] - 'a';
            int cur2 = c2[i] - 'a';
            if (cur1 > cur2) {
                return true;
            } else if (cur2 > cur1) {
                return false;
            }
        }
        return c1.length > c2.length;
    }
}