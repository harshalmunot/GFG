class Solution {
    public int maxFruits(ArrayList<Integer> arr, int m) {
        int n = arr.size();

        if (m >= n) {
            int sum = 0;
            for (int x : arr) {
                sum += x;
            }
            return sum;
        }

        int sum = 0;

        for (int i = 0; i < m; i++) {
            sum += arr.get(i);
        }

        int ans = sum;

        for (int i = m; i < n + m - 1; i++) {
            sum += arr.get(i % n);
            sum -= arr.get((i - m) % n);

            ans = Math.max(ans, sum);
        }

        return ans;
    }
}