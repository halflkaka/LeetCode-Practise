class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if (digits[len-1] != 9) {
            digits[len-1] ++;
            return digits;
        }
        int flag = 1;
        for (int i = len - 1; i >= 0; i--) {
            if (flag == 1) {
                flag = (digits[i] + 1) / 10;
                digits[i] = (digits[i] + 1) % 10;
            }
        }
        if (digits[0] == 0) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                res[i+1] = digits[i];
            }
            return res;
        } else {
            return digits;
        }
    }
}