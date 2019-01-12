class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+') {
                if (i < s.length() -1 && s.charAt(i+1) == '+') {
                    StringBuilder sb = new StringBuilder();
                    sb.append(s.substring(0,i)).append("--");
                    if (i != s.length()-2) {
                        sb.append(s.substring(i+2, s.length()));
                    }
                    ans.add(sb.toString());
                }
            }
        }
        return ans;
    }
}