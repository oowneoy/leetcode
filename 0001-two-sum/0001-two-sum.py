class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        arr = [0, 0]
        for i in range(len(nums)):
            answer = target - nums[i]
            for j in range(len(nums)):
                if answer == nums[j] and i != j:
                    return i, j
        return i, j