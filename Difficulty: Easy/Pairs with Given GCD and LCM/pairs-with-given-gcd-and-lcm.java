class Solution {
    public int pairCount(int x, int y) {

        // LCM must be divisible by GCD
        if (y % x != 0) {
            return 0;
        }

        int n = y / x;
        int count = 0;

        // Find all factor pairs
        for (int a = 1; a * a <= n; a++) {
            if (n % a == 0) {
                int b = n / a;

                // Only count if a and b are coprime
                if (gcd(a, b) == 1) {
                    if (a == b) {
                        count += 1;
                    } else {
                        count += 2;
                    }
                }
            }
        }

        return count;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}