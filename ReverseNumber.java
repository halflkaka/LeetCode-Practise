class Solution {
    public int reverse(int x) {
        int revNum = 0;
        
        while (x != 0) {
            int lastNum = x % 10;
            if ((revNum * 10 + lastNum - lastNum) / 10 == revNum){
                revNum = revNum * 10 +lastNum;
            } else {return 0;}
            x /= 10;
        }
        
        return revNum;
    }
}