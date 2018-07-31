class Solution {
    public String largestNumber(int[] nums) {
        String[] Nums = new String[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            Nums[i] = toString(nums[i]);
        }
        Comparator<String> comp = new Comparator<String>(){
            @Override
            public int compare(String str1, String str2) {
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s2.compareTo(s1);
            }
        };
        
        Arrays.sort(Nums,comp);
        if (Nums[0].charAt(0) == '0') return "0";
        
        StringBuilder res = new StringBuilder("");
        for (String str:Nums) {
            res.append(str);
        }
        
        return res.toString();
    }
    public String toString(int n) {
        return String.valueOf(n);
    }
}