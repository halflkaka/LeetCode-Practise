class Solution {
    public int maxArea(int[] height) {
        int area = 0;
        
        int i = 0, j = height.length - 1;
        while (i != j) {
            int width = j - i;
            int hgt = (height[i] > height[j]? height[j]:height[i]);
            if (area < width * hgt) {
                area = width * hgt;
            }
            if (height[i] > height[j]) {
                j --;
            } else {
                i ++;
            }
        }
        
        return area;
    }
    
    
}