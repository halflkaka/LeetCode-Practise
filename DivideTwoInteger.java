class Solution {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = -1;
        }
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        if (ldividend == 0) return 0;
        if (ldivisor == 0) return Integer.MAX_VALUE;
        long res = ldivide(ldividend, ldivisor);
        int ans;
        if (res > Integer.MAX_VALUE) {
            if (sign == 1) return Integer.MAX_VALUE;
            else return Integer.MIN_VALUE;
        } else {
            ans = (int)(sign*res);
            return ans;
        }
    }
    
    public long ldivide(long ldividend, long ldivisor) {
        if (ldividend < ldivisor) return 0;
        long sum = ldivisor, div = 1;
        while ((sum + sum) <= ldividend) {
            sum += sum;
            div += div;
        }
        return div + ldivide(ldividend - sum, ldivisor);
    }
}