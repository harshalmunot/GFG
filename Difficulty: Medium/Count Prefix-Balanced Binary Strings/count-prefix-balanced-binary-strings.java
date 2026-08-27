class Solution {
    public int prefixStrings(int n) {
        final int MOD = 1_000_000_007;
        int[][] dp = new int[n + 1][n + 1];
        dp[0][0] = 1;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == 0 && j == 0) continue;
                long ways = 0;
                if (i > 0) ways += dp[i - 1][j];     // place a '1'
                if (j > 0) ways += dp[i][j - 1];     // place a '0'
                dp[i][j] = (int) (ways % MOD);
            }
        }

        return dp[n][n];
    }
}