class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>(), appen = new HashMap<>();
        
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n,0)+1);
        }
        
        for (int n : nums) {
            if (freq.get(n) == 0) continue;
            if (appen.getOrDefault(n,0) > 0) {
                appen.put(n, appen.get(n)-1);
                appen.put(n+1, appen.getOrDefault(n+1,0)+1);
            } else if (freq.getOrDefault(n+1,0) > 0 && freq.getOrDefault(n+2,0) > 0) {
                freq.put(n+1, freq.get(n+1)-1);
                freq.put(n+2, freq.get(n+2)-1);
                appen.put(n+3, appen.getOrDefault(n+3,0)+1);
            } else {
                return false;
            }
            freq.put(n, freq.get(n)-1);
        }
        return true;
    }
}