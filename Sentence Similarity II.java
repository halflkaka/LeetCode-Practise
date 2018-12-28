class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        Map<String, String> map = new HashMap<>();
        
        for (int i = 0; i < pairs.length; i++) {
            String first = find(map, pairs[i][0]), second = find(map, pairs[i][1]);
            if (!first.equals(second)) {
                map.put(first, second);
            }
        }
        
        if (words1.length != words2.length) return false;
        
        for (int i = 0; i < words1.length; i++) {
            if (!words1[i].equals(words2[i]) && !find(map,words1[i]).equals(find(map,words2[i]))) {
                return false;
            }
        }
        return true;
    }
    public String find(Map<String, String> map, String target) {
        if (!map.containsKey(target)) map.put(target, target);
        while (target != map.get(target)) {
            target = map.get(target);
        }
        return target;
    }
}