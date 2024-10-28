class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++) {
            int value = target - nums[i];
            for(int j = i + 1; j < nums.length; j++) {
                if (value == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return result;
    }
}