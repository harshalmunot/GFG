class Solution {
    public int minCount(int[] arr) {
        int n = arr.length;

       
        int[][] dp = new int[101][102];

        for (int x : arr) {
            int[][] next = new int[101][102];

            for (int inc = 0; inc <= 100; inc++) {
                for (int dec = 1; dec <= 101; dec++) {

                    int curr = dp[inc][dec];

                    // Don't take x
                    next[inc][dec] = Math.max(next[inc][dec], curr);

                    // Take x in increasing subsequence
                    if (x > inc) {
                        next[x][dec] = Math.max(
                            next[x][dec],
                            curr + 1
                        );
                    }

                    // Take x in decreasing subsequence
                    if (x < dec) {
                        next[inc][x] = Math.max(
                            next[inc][x],
                            curr + 1
                        );
                    }
                }
            }

            dp = next;
        }

        int maxSelected = 0;

        for (int inc = 0; inc <= 100; inc++) {
            for (int dec = 1; dec <= 101; dec++) {
                maxSelected = Math.max(maxSelected, dp[inc][dec]);
            }
        }

        return n - maxSelected;
    }
}