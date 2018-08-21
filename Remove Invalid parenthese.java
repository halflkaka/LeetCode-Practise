class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null) {
            return ans;
        }
        
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        q.add(s);
        visited.add(s);
        boolean found = false;
        
        while (!q.isEmpty()) {
            s = q.poll();
            
            if (isValid(s)) {
                ans.add(s);
                found = true;
            }
            
            if (found) continue;
            
            for (int i = 0; i < s.length(); i++) {
                
                if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;
                
                String t = s.substring(0,i) + s.substring(i+1);
                if (!visited.contains(t)) {
                    q.add(t);
                    visited.add(t);
                }
            }
        }
        
        return ans;
    }

    public boolean isValid(String s) {
      int count = 0;
    
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c == '(') count++;
        if (c == ')' && count-- == 0) return false;
      }
    
      return count == 0;
    }
}