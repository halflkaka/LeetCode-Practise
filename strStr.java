class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (haystack.length() < needle.length()) return -1;
        
        int pos = -1;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int k = 0;
                int len = 0;
                for (int j = i; j < i + needle.length(); j++) {
                    if (haystack.charAt(j) != needle.charAt(k)) break;
                    else if (haystack.charAt(j) == needle.charAt(k)) {
                        len++;
                    }
                    System.out.println(len);
                    if (len == needle.length()) {
                        return (j - needle.length() + 1);
                    }
                    k++;
                }
            }
        }
        return pos;
    }
}