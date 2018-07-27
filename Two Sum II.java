class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] indices = new int[2];
        if (numbers.length < 2) return indices;
        
        int lf = 0, rg = numbers.length - 1;
        while (lf < rg) {
            if (numbers[lf] + numbers[rg] == target) {
                indices[0] = lf + 1;
                indices[1] = rg + 1;
                return indices;
            } else if (numbers[lf] + numbers[rg] < target) {
                lf ++;
            } else {
                rg --;
            }
        }
        return indices;
    }
}