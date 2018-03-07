class Solution {
    public boolean isValid(String s) {
        if (s.length() == 0) return true;
        if (s.length() == 1) return false;
        
        Map map = new HashMap();
        Stack<Character> set = new Stack<Character>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                set.push(s.charAt(i));
            } else {
                if (!set.empty()){
                    char top = set.pop();
                    if ((char)map.get(top) != s.charAt(i)) return false;
                } else return false;
            }
        }
        if (set.empty()) return true;
        return false;
    }
}