import java.util.Arrays;

class Solution {
    public int maxArea(int[][] mat) {
        int R = mat.length;
        int C = mat[0].length;

        int[] hist = new int[C];
        int maxArea = 0;

        for (int i = 0; i < R; i++) {
            // Update histogram (consecutive 1's ending at this row) for each column
            for (int j = 0; j < C; j++) {
                if (mat[i][j] == 1) {
                    hist[j] += 1;
                } else {
                    hist[j] = 0;
                }
            }

            // Copy and sort this row's histogram in descending order
            int[] sorted = hist.clone();
            Arrays.sort(sorted);
            for (int l = 0, r = C - 1; l < r; l++, r--) {
                int tmp = sorted[l];
                sorted[l] = sorted[r];
                sorted[r] = tmp;
            }

            // Check every width using the tallest (j+1) columns
            for (int j = 0; j < C; j++) {
                int width = j + 1;
                int area = sorted[j] * width;
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
}