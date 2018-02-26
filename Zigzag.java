class Solution {
    public String convert(String s, int numRows) {
        int length = s.length();
        if (length == 0 || length == 1) return s;
        StringBuffer[] matrix = new StringBuffer[numRows];
        
        for (int j = 0; j < numRows; j++) {
            matrix[j] = new StringBuffer("");
        }
        
        int i = 0;
        while (i < length) {
            for (int j = 0; j < numRows && i < length; j++) {
                matrix[j].append(s.charAt(i));
                i++;
            }
            for (int j = numRows - 2; j >= 1 && i < length; j--) {
                matrix[j].append(s.charAt(i));
                i++;
            }
        }
        
        for (int j = 1; j < numRows; j++) {
            matrix[0].append(matrix[j]);
        }
        
        return matrix[0].toString();
        
    }
}