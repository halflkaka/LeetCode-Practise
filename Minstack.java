class MinStack {
    private Stack<Integer> s;
    private List<Integer> list;
    /** initialize your data structure here. */
    public MinStack() {
        s = new Stack<>();
        list = new ArrayList<>();
    }
    
    public void push(int x) {
        s.push(x);
        list.add(x);
    }
    
    public void pop() {
        s.pop();
        list.remove(list.size()-1);
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        int[] nums = new int[list.size()];
        int i = 0;
        for (int num:list) {
            nums[i++] = num;
        }
        Arrays.sort(nums);
        return nums[0];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */