class Solution {
    static int findFloor(int[] arr, int x) {
        int i = 0, j = arr.length - 1;
        int ans = -1;

        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (arr[mid] <= x) {
                ans = mid;
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        return ans;
    }
}