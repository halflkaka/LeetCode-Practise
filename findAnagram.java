class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() == 0 || s == null || p == null) return ans;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int left = 0, right = 0, count = map.size();
        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right))-1);
                if (map.get(s.charAt(right)) == 0) count--;
            }
            right ++;
            while (count == 0) {
                char lf = s.charAt(left);
                if (map.containsKey(lf)) {
                    map.put(lf, map.get(lf)+1);
                    if (map.get(lf) > 0) count++;
                }
                if (right - left == p.length()) {
                    ans.add(left);
                }
                left ++;
            }
        }
        return ans;
    }
}