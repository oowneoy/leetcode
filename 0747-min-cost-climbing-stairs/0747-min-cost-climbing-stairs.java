class Solution {
    static int[] memo;
    public int minCostClimbingStairs(int[] cost) {
        memo = new int[cost.length + 1];
        memo[0] = cost[0];
        memo[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            memo[i] = Math.min(cost[i] + memo[i - 1], cost[i] + memo[i - 2]);
        }

        return Math.min(memo[cost.length - 1], memo[cost.length - 2]);
    }
}