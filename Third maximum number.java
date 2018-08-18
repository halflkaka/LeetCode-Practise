class Solution {
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                queue.offer(nums[i]);
                set.add(nums[i]);
            }
            if (queue.size() > 3) {
                queue.poll();
            }
        }
        if (queue.size() < 3) {
            int res = queue.poll();
            while (queue.size() > 0) {
                res = queue.poll();
            }
            return res;
        } else {
            return queue.poll();
        }
    }
}