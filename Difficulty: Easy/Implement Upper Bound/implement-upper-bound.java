class Solution {
    int upperBound(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;
        int ans = arr.length;

        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (arr[mid] > target) {
                ans = mid;
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return ans;
    }
}