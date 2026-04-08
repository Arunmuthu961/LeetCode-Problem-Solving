class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // 1. Rearrange numbers to their correct indices
        for (int i = 0; i < n; i++) {
            // Target index for nums[i] is nums[i] - 1
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] with the value at its target position
                int targetIdx = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[targetIdx];
                nums[targetIdx] = temp;
            }
        }

        // 2. Identify the first index i where nums[i] != i + 1
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // 3. If all numbers 1 to n are present, the answer is n + 1
        return n + 1;
    }
}
