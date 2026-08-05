class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // If the array is not rotated or has only one element
        if (nums[left] <= nums[right]) {
            return nums[left];
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if mid+1 is the minimum element
            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            // Check if mid itself is the minimum element
            if (mid > 0 && nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            // Decide whether to search the left half or the right half
            if (nums[mid] > nums[left]) {
                // Left half is sorted, minimum is in the right half
                left = mid + 1;
            } else {
                // Right half is sorted, minimum is in the left half
                right = mid - 1;
            }
        }
        
        return nums[left];
    }
}
