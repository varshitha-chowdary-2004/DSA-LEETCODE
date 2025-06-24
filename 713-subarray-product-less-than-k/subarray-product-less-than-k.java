class Solution {
    public int numSubarrayProductLessThanK(int[] arr, int target) {
        int i = 0, j = 0, pro = 1, count = 0, n = arr.length;
        
        if (target <= 1) return 0;

        while (j < n) {
            pro *= arr[j];

            // shrink window if product >= target
            while (pro >= target && i <= j) {
                pro /= arr[i++];
            }

            // count all valid subarrays ending at j
            count += j - i + 1;
            j++;
        }

        return count;
    }
}
