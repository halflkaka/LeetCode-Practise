class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] s = str.split(" ");
        if (pattern.length() != s.length) return false;
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            map.put(pattern.charAt(i), "0");
        }
        for (int i = 0; i < s.length; i++) {
            if (map.get(pattern.charAt(i)).equals("0")) {
                if (map.containsValue(s[i])) return false;
                map.put(pattern.charAt(i), s[i]);
            } else {
                if (!map.get(pattern.charAt(i)).equals(s[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}