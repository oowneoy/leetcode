class Solution {
    static Map<Integer, Integer> memo = new HashMap<>();
    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        if (!memo.containsKey(n)) {
            memo.put(n, climbStairs(n - 1) + climbStairs(n - 2));
        }

        return memo.get(n);
    }
}