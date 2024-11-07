class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] >= target ? 0 : 1;
        }
        int start = 0;
        int end = nums.length - 1;
        int median = nums.length / 2;

        while (true) {
            if (end - start == 1) {
                if (target > nums[start]) {
                    return target > nums[end] ? end + 1 : end;
                }
                return start;
            }
            if (nums[median] == target) {
                return median;
            } else if (nums[median] < target) {
                start = median;
                median = (end - start) / 2 + start;
            } else {
                end = median;
                median /= 2;
            }
        }
    }
}