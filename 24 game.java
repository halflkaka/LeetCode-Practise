class Solution {
    boolean res = false;
    double epi = 0.001;
    public boolean judgePoint24(int[] nums) {
        List<Double> ans = new LinkedList<>();
        for (int n: nums) {
            ans.add((double)n);
        }
        helper(ans);
        return res;
    }
    public void helper(List<Double> ans) {
        if (ans.size() == 1) {
            if (Math.abs(ans.get(0) - 24.0) < epi) {
                res = true;
            }
            return;
        }
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < i; j++) {
                List<Double> next = new LinkedList<>();
                double x = ans.get(i), y = ans.get(j);
                next.addAll(Arrays.asList(x+y, x*y, x-y, y-x));
                if (Math.abs(x) > epi) next.add(y/x);
                if (Math.abs(y) > epi) next.add(x/y);
                
                ans.remove(i);
                ans.remove(j);
                for (Double n: next) {
                    ans.add(n);
                    helper(ans);
                    ans.remove(ans.size()-1);
                }
                ans.add(j, y);
                ans.add(i, x);
            }
        }
    }
}