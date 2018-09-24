class TrieNode {
    public TrieNode[] next;
    public char val;
    public TrieNode(){}
    int flag;
    public TrieNode(char c) {
        next = new TrieNode[26];
        val = c;
        flag = 0;
    }
}
class Trie {
    
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode(' ');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (cur.next[word.charAt(i)-'a'] == null) {
                cur.next[word.charAt(i)-'a'] = new TrieNode(word.charAt(i));
            }
            cur = cur.next[word.charAt(i)-'a'];
        }
        cur.flag = 1;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (cur.next[word.charAt(i)-'a'] != null) {
                cur = cur.next[word.charAt(i)-'a'];
                count ++;
            } else if (count != word.length()) {
                return false;
            }
        }
        if (cur.flag != 1) return false;
        return true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (cur.next[prefix.charAt(i)-'a'] != null) {
                cur = cur.next[prefix.charAt(i)-'a'];
            } else {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */