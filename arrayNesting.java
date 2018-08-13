The idea is to, start from every number, find circles in those index-pointer-chains, every time you find a set (a circle) mark every number as visited (-1) so that next time you won't step on it again.

Java

public class Solution {
    public int arrayNesting(int[] a) {
        int maxsize = 0;
        for (int i = 0; i < a.length; i++) {
            int size = 0;
            for (int k = i; a[k] >= 0; size++) {
                int ak = a[k];
                a[k] = -1; // mark a[k] as visited;
                k = ak;
            }
            maxsize = Integer.max(maxsize, size);
        }

        return maxsize;
    }
}