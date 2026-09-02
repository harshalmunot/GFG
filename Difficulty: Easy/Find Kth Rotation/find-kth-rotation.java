class Solution {
    public int findKRotation(int arr[]) {
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            int mid = i + (j - i) / 2;

            if (arr[mid] > arr[j]) {
                i = mid + 1;
            } else if (arr[mid] < arr[j]) {
                j = mid;
            } else {
                j--;
            }
        }

        return i;
        
        
        
    }
}