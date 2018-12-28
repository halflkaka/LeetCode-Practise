class Solution {
    public String crackSafe(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int target = (int)Math.pow(k,n);
        Set<String> visited = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            sb.append('0');
        }
        visited.add(sb.toString());
        
        dfs(target, n, k, sb, visited);
        return sb.toString();
    }
    public boolean dfs(int target, int n, int k, StringBuilder sb, Set<String> visited) {
        if (visited.size() == target) return true;
        String sub = sb.substring(sb.length()-n+1, sb.length());
        for (int i = 0; i < k; i++) {
            String next = sub + i;
            if (!visited.contains(next)) {
                visited.add(next);
                sb.append(i);
                if (dfs(target, n, k, sb, visited)) {
                    return true;
                } else {
                    visited.remove(next);
                    sb.delete(sb.length()-1, sb.length());
                }
            }
        }
        return false;
    }
}