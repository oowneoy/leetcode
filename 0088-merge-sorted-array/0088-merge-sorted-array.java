class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = nums1.length - 1;
        int i = m - 1;
        int j = n - 1;
        while (i > -1 || j > -1) {
            if (moveNums1(nums1, i, nums2, j)) {
                nums1[index--] = nums1[i--];
            } else {
                nums1[index--] = nums2[j--];
            }
        }
    }

    private boolean moveNums1(int[] nums1, int i, int[] nums2, int j) {
        return (i == -1 ? Integer.MIN_VALUE : nums1[i]) 
                > (j == -1 ? Integer.MIN_VALUE : nums2[j]);
    }
}