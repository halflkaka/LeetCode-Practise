class Solution {
    public String simplifyPath(String path) {
        Stack<String> s = new Stack<String>();
        if (path.charAt(path.length()-1) != '/') {path = path + "/";}
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                int k = i;
                if (i == path.length() - 1) {
                    break;
                } else {
                    while (path.charAt(i+1) != '/') {
                        i++;
                    }
                    if (i != k) {
                        String cur = path.substring(k,i+1);
                        // System.out.println(cur);
                        if (cur.equals("/..")) {
                            if (!s.empty()) s.pop();
                        } else if (cur.equals("/.")) {}
                        else {s.push(cur);}
                    }
                }
            }
        }
        String res = new String();
        if (s.empty()) return "/";
        while (!s.empty()) {
            res = s.pop() + res;
        }
        return res;
        
    }
}