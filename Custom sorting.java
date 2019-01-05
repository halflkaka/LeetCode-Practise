class Solution {
    public String customSortString(String S, String T) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < T.length(); i++) {
            map.put(new Character(T.charAt(i)), map.getOrDefault(new Character(T.charAt(i)), 0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (map.containsKey(Character.valueOf(S.charAt(i))) && map.get(Character.valueOf(S.charAt(i))) != 0) {
                while (map.get(Character.valueOf(S.charAt(i))) > 0) {
                    sb.append(S.charAt(i));
                    map.put(Character.valueOf(S.charAt(i)), map.get(Character.valueOf(S.charAt(i)))-1);
                }
                
            }
        }
        
        for (char c : map.keySet()) {
            while (map.get(c) > 0) {
                sb.append(c);
                map.put(c, map.get(c)-1);
            }
        }
        return sb.toString();
    }
}