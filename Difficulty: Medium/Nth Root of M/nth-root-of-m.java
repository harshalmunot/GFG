class Solution {

    public int nthRoot(int n, int m) {
        if (m == 0 || m == 1) {
            return m;
        }

        int s = 1;
        int e = m;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            long power = 1;

            for (int i = 0; i < n; i++) {
                power *= mid;
            }

            if (power == m) {
                return mid;
            }

            if (power < m) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return -1;
    }
}