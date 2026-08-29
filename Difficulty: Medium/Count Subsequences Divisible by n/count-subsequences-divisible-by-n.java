class Solution {
    public int countSubsequences(String s, int n) {

        final long MOD = 1000000007L;

        long[] dp = new long[n];

        for (char ch : s.toCharArray()) {

            int digit = ch - '0';

            // Copy old dp because current digit
            // can be used only once
            long[] next = dp.clone();

            // Start a new subsequence with current digit
            int rem = digit % n;
            next[rem] = (next[rem] + 1) % MOD;

            // Add current digit to existing subsequences
            for (int r = 0; r < n; r++) {

                if (dp[r] != 0) {

                    int newRem = (r * 10 + digit) % n;

                    next[newRem] =
                        (next[newRem] + dp[r]) % MOD;
                }
            }

            dp = next;
        }

        return (int) dp[0];
    }
}