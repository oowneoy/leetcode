class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        for (int n : set) {
            if (!set.contains(n - 1)) {
                int count = 0;
                while (set.contains(n + 1)) {
                    count += 1;
                    n += 1;
                }

                answer = Math.max(answer, count);
            }
        }

        return answer + 1;
    }
}