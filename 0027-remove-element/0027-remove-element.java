class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                nums[i] = -1;
            } else {
                count++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == -1) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[k] != -1) {
                        nums[j] = nums[k];
                        nums[k] = -1;
                        break;
                    }
                }
            }
        }

        return count;
    }
}