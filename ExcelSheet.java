class Solution {
    public String convertToTitle(int n) {
        //A 65
        StringBuilder s = new StringBuilder();
        while (n != 0) {
            n --;
            s.insert(0, (char)('A' + n % 26));
            n /= 26;
        }
        
        return s.toString();
    }
}