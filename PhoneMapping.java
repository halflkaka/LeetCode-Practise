class Solution {
    public List<String> letterCombinations(String digits) {
        String[] phone = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        LinkedList<String> letters = new LinkedList<String>();
        if (digits.length() == 0) return letters;
        letters.add("");
        
        for (int i = 0; i < digits.length(); i++) {
            int pos = digits.charAt(i) - '0';
            while (letters.peek().length() == i) {
                String letter = letters.remove();
                for (char s: phone[pos].toCharArray()) {
                    letters.add(letter + s);
                }
            }
        }
        
        return letters;
    }
}