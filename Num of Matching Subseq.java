class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        Map<Character,Queue<String>> map = new HashMap<>();
        for (String word: words) {
            char start = word.charAt(0);
            map.put(start, map.getOrDefault(start, new LinkedList<>()));
            map.get(start).offer(word);
        }
        
        int ans = 0;
        
        for (int i = 0 ; i < S.length(); i++) {
            Queue<String> q = map.getOrDefault(S.charAt(i), new LinkedList<>());
            int size = q.size();
            for (int j = 0; j < size; j++) {
                String s = q.poll();
                if (s.length()-1 == 0) {
                    ans ++;
                    System.out.println(s);
                } else {
                    String ns = s.substring(1, s.length());
                    map.put(ns.charAt(0), map.getOrDefault(ns.charAt(0), new LinkedList<>()));
                    map.get(ns.charAt(0)).offer(ns);
                }
            }
        }
        return ans;
    }
}