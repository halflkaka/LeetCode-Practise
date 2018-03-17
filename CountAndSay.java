class Solution {
    public String countAndSay(int n) {
        String cur = "1";
        for (int i = 1; i < n; i++) {
            char num = cur.charAt(0);
            int count = 1;
            String pre = cur;
            cur = "";
            for (int j = 1; j < pre.length(); j++) {
                if (pre.charAt(j) != num) {
                    cur = cur + count + num;
                    count = 1;
                    num = pre.charAt(j);
                } else {
                    count ++;
                }
            }
            cur = cur + count + num;
        }
        return cur;
    }
}