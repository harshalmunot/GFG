class Solution {
    public int maxProduct(int[] arr, int k) {

        int n = arr.length;
        long INF = Long.MAX_VALUE / 4;

        long[][] max = new long[k + 1][n + 1];
        long[][] min = new long[k + 1][n + 1];

        // Initialize
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                max[i][j] = -INF;
                min[i][j] = INF;
            }
        }

        // Product of choosing 0 elements = 1
        for (int j = 0; j <= n; j++) {
            max[0][j] = 1;
            min[0][j] = 1;
        }

        for (int count = 1; count <= k; count++) {

            for (int i = 1; i <= n; i++) {

                // Don't take current element
                max[count][i] = max[count][i - 1];
                min[count][i] = min[count][i - 1];

                // Take current element
                if (max[count - 1][i - 1] != -INF) {

                    long p1 = max[count - 1][i - 1] * arr[i - 1];
                    long p2 = min[count - 1][i - 1] * arr[i - 1];

                    max[count][i] = Math.max(max[count][i], 
                                             Math.max(p1, p2));

                    min[count][i] = Math.min(min[count][i], 
                                             Math.min(p1, p2));
                }
            }
        }

        return (int) max[k][n];
    }
}