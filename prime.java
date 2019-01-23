class Solution {
    public int countPrimes(int n) {
        boolean[] prime = new boolean[n];
        int count = 0;
        
        for (int i = 2; i < n; i++) {
            if (!prime[i]) {
                count ++;
                for (int j = 2; j * i < n; j++) {
                    prime[i*j] = true;
                }
            }
        }
        return count;
    }
}