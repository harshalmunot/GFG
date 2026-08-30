class Solution {
    public List<Integer> getMarks(int[] l, int[] r, int[] rank) {
        int n = l.length;
        int[] prefix = new int[n];
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int len = r[i] - l[i] + 1;
            prefix[i] = len + (i > 0 ? prefix[i - 1] : 0);
        }

        for (int x : rank) {
            int low = 0, high = n - 1;

            while (low < high) {
                int mid = low + (high - low) / 2;

                if (prefix[mid] >= x)
                    high = mid;
                else
                    low = mid + 1;
            }

            int prev = low == 0 ? 0 : prefix[low - 1];
            ans.add(l[low] + x - prev - 1);
        }

        return ans;
    }
}