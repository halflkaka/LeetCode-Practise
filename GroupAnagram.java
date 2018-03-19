class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> set = new HashMap<>();
        for (String str:strs) {
            char[] characters = str.toCharArray();
            Arrays.sort(characters);
            String cur = String.valueOf(characters);
            if (!set.containsKey(cur)) {
                set.put(cur, new ArrayList<String>());
            }
            set.get(cur).add(str);
        }
        return new ArrayList<List<String>>(set.values());
    }
    
}