class Solution {
    public long maxDiffSum(int[] arr) {
        int n = arr.length;

        long keep = 0;
        long replace = 0;

        for (int i = 1; i < n; i++) {

            long newKeep = Math.max(
                keep + Math.abs(arr[i] - arr[i - 1]),
                replace + Math.abs(arr[i] - 1)
            );

            long newReplace = Math.max(
                keep + Math.abs(1 - arr[i - 1]),
                replace
            );

            keep = newKeep;
            replace = newReplace;
        }

        return Math.max(keep, replace);
    }
}