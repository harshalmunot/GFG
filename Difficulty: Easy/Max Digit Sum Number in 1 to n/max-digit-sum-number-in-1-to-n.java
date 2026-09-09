class Solution {
    public int findMax(int n) {
        int ans = n;

        for (long i = 10; i <= n; i *= 10) {
            int num = (int)((n / i - 1) * i + i - 1);

            if (num > 0 && digitSum(num) > digitSum(ans)) {
                ans = num;
            }
        }

        return ans;
    }

    public int digitSum(int n) {
        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }
}