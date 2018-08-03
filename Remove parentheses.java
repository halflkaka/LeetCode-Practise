class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        
        if (s.length() == 0) {
            res.add(s);
            return res;
        }
        
        queue.add(s);
        set.add(s);
        
        boolean check = false;
        
        while (!queue.isEmpty()) {
            String s1 = queue.poll();
            
            if (isValid(s1)) {
                res.add(s1);
                check = true;
            }
            if (check) continue;
            
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != '(' && s1.charAt(i) != ')') continue;
                String ans = s1.substring(0, i) + s1.substring(i+1);
                if (!set.contains(ans)) {
                    set.add(ans);
                    queue.add(ans);
                }
            }
        }
        
        return res;
    }
    
    public boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') count ++;
            if (s.charAt(i) == ')') count --;
            if (count < 0) return false;
        }
        return count == 0;
    }
}