class Solution {
    public int findMinArrowShots(int[][] points) {
        //[1,6], [2,8], [7,12], [10,16]
        if (points.length == 0) return 0;
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        
        int count = 1;
        int end = points[0][1];
        
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= end && points[i][1] >= end) {
                continue;
            }
            count ++;
            end = points[i][1];
        }
        return count;
    }
}