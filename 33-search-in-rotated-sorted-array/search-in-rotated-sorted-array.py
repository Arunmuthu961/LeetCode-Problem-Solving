class Solution:
    def search(self, nums: list[int], target: int) -> int:
        # Linear Search: Check every element from start to finish
        for i in range(len(nums)):
            if nums[i] == target:
                return i
        
        # If the loop finishes, the target wasn't found
        return -1
