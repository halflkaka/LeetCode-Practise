class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int lmax = 0, rmax = 0;
        int res = 0;
        while (l < r) {
            lmax = Math.max(height[l], lmax);
            rmax = Math.max(height[r], rmax);
            if (lmax < rmax) {
                res += lmax - height[l];
                l++;
            } else {
                res += rmax - height[r];
                r--;
            }
        }
        return res;
    }
}