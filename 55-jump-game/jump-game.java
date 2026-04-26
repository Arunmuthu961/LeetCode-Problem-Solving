class Solution {
    public boolean canJump(int[] nums) {
        int farthest = 0;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            // If the current index is beyond our reach, we're stuck
            if (i > farthest) {
                return false;
            }
            
            // Update the farthest reachable index
            farthest = Math.max(farthest, i + nums[i]);
            
            // Optimization: If we can already reach the last index, stop early
            if (farthest >= n - 1) {
                return true;
            }
        }
        
        return farthest >= n - 1;
    }
}
