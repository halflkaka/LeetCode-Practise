class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] freq = new int[n+1];
        
        for (int i = 0; i < n; i++) {
            if (citations[i] > n) {
                freq[n] += 1;
            } else {
                freq[citations[i]] += 1;
            }
        }
        
        int sum = 0;
        for (int i = n; i >= 0; i--) {
            sum += freq[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }
}