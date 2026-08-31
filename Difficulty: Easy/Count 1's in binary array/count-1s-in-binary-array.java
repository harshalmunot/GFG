class Solution {
    public int countOnes(int[] arr) {
        // code here
        int i =0, j = arr.length-1;
        int count = 0;
        for (int x : arr) {
            if (x == 1)
                count++;
        }

        return count;
    }
}