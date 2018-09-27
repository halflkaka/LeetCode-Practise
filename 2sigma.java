class TrieNode {
    public TrieNode next;
    public char val;
    public int flag;
    public TrieNode(char c) {
        val = c;
        flag = 0;
        next = null;
    }
}

class Solution {
    private TrieNode minBranch;
	private TrieNode maxBranch;
    /** Initialize your data structure here. */
    public Solution() {
        minBranch = new TrieNode(' ');
        maxBranch = new TrieNode(' ');
    }
    public String longestPalindrome(String input) {
        TrieNode curMin = minBranch, curMax = maxBranch;
        String s;
        int lastCon = 0;
		int minVow = -1, minCon = -1, maxVow = -1, maxCon = -1;
        for (int i = input.length() - 1; i >= 0; i--) {
            if (!isVowel(input.charAt(i))) {
                lastCon = i;
                break;
            }
        }
        s = input.substring(0, lastCon+1);
        
		for (int i = 0; i < s.length(); i++) {
			if (isVowel(s.charAt(i))) {
				if (minVow == -1 || s.charAt(i) < s.charAt(minVow)) {
					minVow = i;
					minBranch.next = new TrieNode(s.charAt(minVow));
					curMin = minBranch;
				}
				if (maxVow != -1 && s.charAt(i) == s.charAt(maxVow)) {
					if (i < s.length()-1 && maxBranch.next.next != null && s.charAt(i+1) > maxBranch.next.next.val) {
						maxBranch.next.next = new TrieNode(s.charAt(i+1));
						curMax = maxBranch.next;
                        maxVow = i;
					}
				}
				if (maxVow == -1 || s.charAt(i) > s.charAt(maxVow)) {
					maxVow = i;
					maxBranch.next = new TrieNode(s.charAt(maxVow));
					curMax = maxBranch;
				}
				if (curMin.next == null && curMin.flag != 1) {
					curMin.next = new TrieNode(s.charAt(i));
				}
				if (curMax.next == null) {
					curMax.next = new TrieNode(s.charAt(i));
				}
				if (curMin.next != null) {
					curMin = curMin.next;
				}
				if (curMax.next != null) {
					curMax = curMax.next;
				}
			} else {
				if (minVow != -1 && curMin.flag != 1) {
					curMin.next = new TrieNode(s.charAt(i));
					curMin.next.flag = 1;
					minCon = i;
					curMin = curMin.next;
				}
                if (maxVow != -1 && maxBranch.next.next != null && s.charAt(i) > maxBranch.next.next.val) {
					maxCon = i;
					maxBranch.next.next = new TrieNode(s.charAt(maxCon));
					curMax = maxBranch.next.next;
                } else if (maxVow != -1) {
					maxCon = i;
                    if (curMax.next == null) {
                        curMax.next = new TrieNode(s.charAt(i));
					    curMax = curMax.next;
                    } else {
                        curMax = curMax.next;
                    }
				}
			}
		}
        // String Min = "", Max = "";
        // curMin = minBranch, curMax = maxBranch;
//         while (curMin.next != null) {
//             Min += curMin.next.val;
//             if (curMin.next.flag == 1) break;
//             curMin = curMin.next;
//         }
        
//         while (curMax.next != null) {
//             Max += curMax.next.val;
//             curMax = curMax.next;
//         }
        if (minVow >= minCon) {
            System.out.println("false");
        } else {
            System.out.println(s.substring(minVow, minCon+1));
        }
        if (maxVow >= maxCon) {
            System.out.println("false");
        } else {
            System.out.println(s.substring(maxVow, maxCon+1));
        }
		
        return "";
    }
    
    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    
}