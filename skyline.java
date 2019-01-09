class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        
        for (int[] bud: buildings) {
            height.add(new int[]{bud[0], -bud[2]});
            height.add(new int[]{bud[1], bud[2]});
        }
        
        Collections.sort(height, (a,b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->(b-a));
        q.offer(0);
        int top = 0;
        for (int[] h : height) {
            if (h[1] < 0) {
                q.offer(-h[1]);
            } else {
                q.remove(h[1]);
            }
            if (q.peek() != top) {
                res.add(new int[]{h[0], q.peek()});
                top = q.peek();
            }
        }
        return res;
    }
}