class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[mid + 1]) {
                // We are on an upward slope, so a peak lies to the right
                left = mid + 1;
            } else {
                // We are on a downward slope, so mid could be a peak or it lies to the left
                right = mid;
            }
        }

        // 'left' and 'right' converge to the peak element index
        return left;
    }
}
