class Solution {
    public int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("\\."), ver2 = version2.split("\\.");
        int m = ver1.length, n = ver2.length;
        int i = 0;
        int len = Math.max(m,n);
        for (i = 0; i < len; i++) {
            Integer num1 = (i < m? Integer.parseInt(ver1[i]) : 0);
            Integer num2 = (i < n? Integer.parseInt(ver2[i]) : 0);
            if (num1.compareTo(num2) != 0) {
                return num1.compareTo(num2);
            }
        }

        return 0;
    }
}