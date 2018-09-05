class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("+") && !stack.isEmpty()) {
                int n1 = stack.pop();
                int n2 = stack.pop();
                int n1n2 = n1 + n2;
                sum += n1n2;
                stack.push(n2);
                stack.push(n1);
                stack.push(n1n2);
            } else if (ops[i].equals("D") && !stack.isEmpty()) {
                int n = stack.pop();
                int nd = n * 2;
                sum += nd;
                stack.push(n);
                stack.push(nd);
            } else if (ops[i].equals("C") && !stack.isEmpty()) {
                int n = stack.pop();
                sum -= n;
            } else {
                stack.push(Integer.parseInt(ops[i]));
                sum += Integer.parseInt(ops[i]);
            }
        }
        return sum;
    }
}