class Solution {
    public String makeLargestSpecial(String S) {
        int count = 0, i = 0;
        List<String> ans = new ArrayList<>();
        
        for (int j = 0; j < S.length(); j++) {
            if (S.charAt(j) == '1') {
                count ++;
            } else {
                count --;
            }
            if (count == 0) {
                ans.add('1'+makeLargestSpecial(S.substring(i+1, j))+'0');
                i = j+1;
            }
        }
        
        
        Collections.sort(ans, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String s : ans) {
            sb.append(s);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}