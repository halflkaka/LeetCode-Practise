class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] pos = new int[26];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            pos[S.charAt(i) - 'a'] = i;
        }
        int right = 0, left = 0;
        for (int i = 0; i < S.length(); i++) {
            right = Math.max(right, pos[S.charAt(i) - 'a']);
            if (right == i) {
                list.add(right - left +1);
                left = right + 1;
            }
        }
        return list;
        
    }
}