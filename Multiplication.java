class Solution {
    public String multiply(String num1, String num2) {
        int[] pos = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int m = i + j, n = i + j + 1;
                int sum = mul + pos[n];
                pos[n] = sum % 10;
                pos[m] += sum / 10;
            }
        }
        StringBuffer ans = new StringBuffer();
        for (int num:pos) {
            if (!(ans.length() == 0 && num == 0)) {
                ans.append(num);
            }
        }
        if (ans.length() == 0) return "0";
        else return ans.toString();
    }
}