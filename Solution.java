import java.util.*;

public class Solution{

     public static void main(String []args){
        Scanner in = new Scanner(System.in);
        //Target number
        int target = in.nextInt();
        //Read input
        while (in.hasNext()) {
            //Sequence of digits
            String seq = in.next();
            List<String> result = addOperators(seq, target);
            for (String s : result) {
                System.out.println(s);
            }
            if (result.size() == 0) {
                System.out.println("impossible");
            }
            System.out.println();
        }
     }
     
     public static List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        if (Integer.parseInt(num) == target) {
            ans.add(num);
            return ans;
        }
        helper(ans, num, target, "", 0, 0, 0);;
        return ans;
    }
    
    public static void helper(List<String> ans, String num, int target, String sb, int start, long sum, long mul) {
        if (sum == target && start == num.length()) {
            ans.add(sb.toString());
            return;
        }
        for (int i = start; i < num.length(); i++) {
            if (i != start && num.charAt(start) == '0') break;
            long cur = Long.parseLong(num.substring(start, i+1));
            if (start == 0) {
                helper(ans, num, target, sb+cur, i+1, cur, cur);
            } else {
                helper(ans, num, target, sb+"+"+cur, i+1, sum+cur, cur);
                helper(ans, num, target, sb+"-"+cur, i+1, sum-cur, -cur);
                helper(ans, num, target, sb+"*"+cur, i+1, sum - mul + mul*cur, mul*cur);
            }
        }
    }
     
}