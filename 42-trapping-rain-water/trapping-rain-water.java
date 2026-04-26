class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int totalWater = 0;
        
        while (left < right) {
            // We process the shorter side because it's the limiting factor for water
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left]; // Update left maximum
                } else {
                    totalWater += leftMax - height[left]; // Water trapped at this bar
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right]; // Update right maximum
                } else {
                    totalWater += rightMax - height[right]; // Water trapped at this bar
                }
                right--;
            }
        }
        
        return totalWater;
    }
}
