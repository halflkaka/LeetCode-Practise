class Solution {
    
    private int max = 0, start;
    
    public String longestPalindrome(String s) {
        
        if (s.length() == 1) {return s;}
        
        for (int i = 0; i < s.length(); i++) {
            extend(s, i ,i);
            extend(s, i, i+1);
        }
        
        return s.substring(start, start+max);
    }
    
    public void extend(String s, int j, int k) {
        while (j >= 0 && k < s.length()) {
            if (s.charAt(j) == s.charAt(k)) {
                j--;
                k++;
            } else {break;}
        }
        if (max < k - j - 1) {
            max = k - j - 1;
            start = j + 1;
        }
    }
    

}