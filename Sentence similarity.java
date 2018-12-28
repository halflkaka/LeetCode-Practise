class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        Map<String, Set<String>> map = new HashMap<>();
        for (int i = 0; i < pairs.length; i++) {
            String first = pairs[i][0], second = pairs[i][1];
            Set<String> set = map.getOrDefault(first, new HashSet<String>()),
                                set2 = map.getOrDefault(second, new HashSet<String>());
            set.add(second);
            set2.add(first);
            map.put(first, set);
            map.put(second, set2);
        }
        
        if (words1.length != words2.length) return false;
        for (int i = 0; i <words1.length; i++) {
            if (words1[i].equals(words2[i])) continue;
            if (!map.containsKey(words1[i]) || !map.get(words1[i]).contains(words2[i])) {
                return false;
            }
        }
        return true;
    }
}