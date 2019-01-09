class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(people, (a,b)->{
            if (a[0] != b[0]) {
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });
        
        for (int[] p : people) {
            ans.add(p[1], p);
        }
        return ans.toArray(new int[people.length][2]);
    }
}