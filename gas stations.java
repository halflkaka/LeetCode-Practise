class Solution {
    public double minmaxGasDist(int[] stations, int K) {
        double lo=0, hi=stations[stations.length-1]-stations[0];
        while (lo + 1e-6 < hi) {
            double mid = (lo+hi)/2;
            int count = 0;
            for (int i = 1; i < stations.length; i++) {
                count += Math.ceil((stations[i]-stations[i-1])/mid)-1;
            }
            if (count > K) {
                lo = mid;
            } else {
                hi = mid;;
            }
        }
        return hi;
    }
}