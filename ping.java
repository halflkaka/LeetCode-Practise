class RecentCounter {

    PriorityQueue<Integer> q;
    public RecentCounter() {
        q = new PriorityQueue<>();
    }
    
    public int ping(int t) {
        int start = t - 3000;
        q.offer(t);
        while (q.size() > 0 && q.peek() < start) {
            q.poll();
        }
        return q.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */