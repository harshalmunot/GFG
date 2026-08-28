class Solution {
    public int minCost(int[][] mat) {
        int n = mat.length;

        int[] dp = new int[3];

        // First row
        dp[0] = mat[0][0];
        dp[1] = mat[0][1];
        dp[2] = mat[0][2];

        // Remaining rows
        for (int i = 1; i < n; i++) {
            int[] newDp = new int[3];

            newDp[0] = mat[i][0] + Math.min(dp[1], dp[2]);
            newDp[1] = mat[i][1] + Math.min(dp[0], dp[2]);
            newDp[2] = mat[i][2] + Math.min(dp[0], dp[1]);

            dp = newDp;
        }

        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}