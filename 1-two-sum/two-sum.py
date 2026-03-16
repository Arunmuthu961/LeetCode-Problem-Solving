class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # Dictionary to store value: index pairs
        num_map = {}
        
        for i, num in enumerate(nums):
            complement = target - num
            
            # If the required partner is already in the map, return their indices
            if complement in num_map:
                return [num_map[complement], i]
            
            # Otherwise, store the current number's index and keep looking
            num_map[num] = i
            
        return [] # Guaranteed to have a solution per constraints
